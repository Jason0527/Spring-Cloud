package com.jason.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign注解 ，feign自带断路功能，在配置文件中加入：feign.hystrix.enabled=true  表示打开feign的断路器功能
 * value的值，表示feign要连接的服务的名称，该服务必须也在注册中心（eureka）注册
 * fallback的值，是一个实现FeignService接口的类，该类的方法就是对应的熔断方法
 * @author jason
 *
 */
@FeignClient(value="info-server",fallback=FeignHystrixBack.class)
public interface FeignService {
	
	@RequestMapping("test/getInfo")
	public String feignExecute();
}
