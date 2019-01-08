package com.github.xjs.service.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 下午4:10:36<br/>
 */
@Service
public class RedisService {
		
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	public <T> boolean set(KeyPrefix keyPrefix, String key, T value) {
		return set(keyPrefix, key, value, false);
	}
	
    public <T> boolean set(KeyPrefix keyPrefix, String key, T value, boolean onlyAbsent) {
    	 ValueOperations<String,Object> operations = redisTemplate.opsForValue();
    	 String realKey = keyPrefix.getPrefix() + key;
    	 int seconds = keyPrefix.getExpireSeconds();
    	 if(seconds <= 0) {
    		 if(onlyAbsent) {
    			Boolean result = operations.setIfAbsent(realKey, value);
    			return result==null?false:result;
    		 }else {
    			 operations.set(realKey, value);
    			 return true;
    		 }
    	 }else {
    		 if(onlyAbsent) {
    			 Boolean result = false;
    			 redisTemplate.setEnableTransactionSupport(true);
        		 redisTemplate.multi();
        		 result = operations.setIfAbsent(realKey, value);
        		 if(result !=null && result) {
        			 redisTemplate.expire(realKey, seconds, TimeUnit.SECONDS);
        		 }
        		 redisTemplate.exec();
        		 redisTemplate.setEnableTransactionSupport(false);
        		 return result==null?false:result;
    		 }else {
    			 operations.set(realKey, value, seconds, TimeUnit.SECONDS);
    			 return true;
    		 }
    	 }
    }
   
    @SuppressWarnings("unchecked")
	public <T> T get(KeyPrefix keyPrefix,  String key, Class<T> value) {
   	 ValueOperations<String,Object> operations = redisTemplate.opsForValue();
   	String realKey = keyPrefix.getPrefix() + key;
   	 return (T)operations.get(realKey);
   };
	
}
