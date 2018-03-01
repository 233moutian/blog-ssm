package com.blog.util;

import org.ehcache.UserManagedCache;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

import java.util.concurrent.TimeUnit;

/**
 * Created by moutian on 2017/7/25 0025.
 */
public class EhcacheManagerUtil {

    public UserManagedCache<String, String> userManagedCache;

    public static EhcacheManagerUtil ehcacheManager = null;

    //默认设置缓存时间
    private final Integer DEFAULT_TIMEOUT = 7200;

    public EhcacheManagerUtil(){};

    public static EhcacheManagerUtil getInstance(){
        if( ehcacheManager == null ){
            ehcacheManager = new EhcacheManagerUtil();
        }
        return ehcacheManager;
    }


    /**
     * 初始化缓存
     * @author yhl 2017-01-19
     */
    private void initManager( int timeout ) {
        if( timeout > 0 ){
            userManagedCache  =  UserManagedCacheBuilder.newUserManagedCacheBuilder(String.class, String.class)
                    .withExpiry( Expirations.timeToLiveExpiration( Duration.of( timeout , TimeUnit.SECONDS ) ) ).build(false);
        }else{
            userManagedCache  =  UserManagedCacheBuilder.newUserManagedCacheBuilder(String.class, String.class).build(false);
        }
        userManagedCache.init();
    }

    /**
     * 设置缓存,不限制时间
     * @author yhl 2017-01-19
     * @param key
     * @param value
     */
    public void setCache( String key , String value ){
        setCache( key , value , 0 );
    }

    /**
     * 设置缓存
     * 默认为 7200秒
     * @author yhl 2017-01-19
     * @param key
     * @param value
     */
    public void setCacheDefault( String key , String value ){
        setCache( key , value , DEFAULT_TIMEOUT );
    }



    /**
     * 设置缓存
     * @param key
     * @param value
     */
    public void setCache( String key , String value , int second ){
        if( userManagedCache == null ){
            initManager( second );
        }
        userManagedCache.put( key , value );
    }

    /**
     * 移除缓存
     * @param key
     */
    public void removeCache( String key ){
        if( userManagedCache != null ){
            userManagedCache.remove( key );
        }
    }

    /**
     * 根据key获取缓存
     * @param key
     * @return
     */
    public String getCache( String key ){
        String cacheValue = userManagedCache.get( key );
        return cacheValue;
    }

}
