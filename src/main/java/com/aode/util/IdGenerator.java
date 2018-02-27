package com.aode.util;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public class IdGenerator {
    private final long twepoch = 1494521122245L;
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private final long maxWorkerId = 31L;
    private final long maxDatacenterId = 31L;
    private final long sequenceBits = 12L;
    private final long workerIdShift = 12L;
    private final long datacenterIdShift = 17L;
    private final long timestampLeftShift = 22L;
    private final long sequenceMask = 4095L;
    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public IdGenerator() {
        long workerId = 1L;
        long datacenterId = 1L;
        if(workerId <= 31L && workerId >= 0L) {
            if(datacenterId <= 31L && datacenterId >= 0L) {
                this.workerId = workerId;
                this.datacenterId = datacenterId;
            } else {
                throw new IllegalArgumentException(String.format("datacenter Id can\'t be greater than %d or less than 0", new Object[]{Long.valueOf(31L)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("worker Id can\'t be greater than %d or less than 0", new Object[]{Long.valueOf(31L)}));
        }
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if(timestamp < this.lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", new Object[]{Long.valueOf(this.lastTimestamp - timestamp)}));
        } else {
            if(this.lastTimestamp == timestamp) {
                this.sequence = this.sequence + 1L & 4095L;
                if(this.sequence == 0L) {
                    timestamp = this.tilNextMillis(this.lastTimestamp);
                }
            } else {
                this.sequence = 0L;
            }

            this.lastTimestamp = timestamp;
            return timestamp - 1494521122245L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequence;
        }
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
            ;
        }

        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        com.tools.keygen.IdGenerator idWorker = new com.tools.keygen.IdGenerator();
        long id = idWorker.nextId();
        System.out.println(id);
        System.out.println(System.currentTimeMillis());

        for(int i = 0; i < 1000; ++i) {
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }

    }
}

