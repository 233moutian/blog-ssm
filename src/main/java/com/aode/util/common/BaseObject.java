package com.aode.util.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by moutian on 2017/6/27 0027.
 */

public abstract class BaseObject {
    private Map<String, Object> properties = null;

    public BaseObject() {
    }

    public void setProperties(String key, Object value) {
        if(this.properties == null) {
            this.properties = new HashMap();
        }

        this.properties.put(key, value);
    }

    public Object getProperties(String key) {
        if(this.properties != null) {
            Object value = this.properties.get(key);
            return value == null?null:value;
        } else {
            return null;
        }
    }

    public void setProperties(Map properties) {
        if(this.properties == null) {
            this.properties = new HashMap();
        }

        if(properties != null) {
            this.properties.putAll(properties);
        }

    }

    public Map<String, Object> getProperties() {
        if(this.properties == null) {
            this.properties = new HashMap();
        }

        return this.properties;
    }

    public String toString() {
        Object map = null;
        Iterator keyIt = ((Map)map).keySet().iterator();
        StringBuilder builder = new StringBuilder(this.getClass().getName() + ": [ ");
        int i = 0;

        while(keyIt.hasNext()) {
            String key = (String)keyIt.next();
            if(!"class".equals(key)) {
                Object value = ((Map)map).get(key);
                if(i > 0) {
                    builder.append(", ");
                }

                builder.append(key + " = " + value);
                ++i;
            }
        }

        builder.append(" ]");
        return builder.toString();
    }
}

