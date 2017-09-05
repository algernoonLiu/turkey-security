package com.algernoon.turkeysecurity.common.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisCacheConfiguration extends CachingConfigurerSupport {

	@Bean
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
		// cacheManager()，方法的返回值则是使用了我们的Redis缓存的管理器
		return new RedisCacheManager(redisTemplate);
	}

	// 支持自定义生成key规则
	@Override
	public KeyGenerator keyGenerator() {
		// return super.keyGenerator();

		return new KeyGenerator() {

			@Override
			public Object generate(Object o, Method method, Object... params) {
				// 格式化缓存key字符串
				StringBuffer sb = new StringBuffer();
				// 追加类名
				sb.append(o.getClass().getName());
				// 追加方法名
				sb.append(method.getName());
				// 遍历参数并且追加
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

}
