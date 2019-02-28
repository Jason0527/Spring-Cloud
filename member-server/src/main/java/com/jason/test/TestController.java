package com.jason.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Autowired
    RestTemplate restTemplate;
	@Autowired
	FeignService feignService;
	
	/**
	 * rest+rebbon测试
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "hystrixExecute")//该注解对该方法创建了断路器的功能，指定hystrixExecute未断路方法
	@RequestMapping("restRibbonTest")
	public String restRibbonTest(){
		/**
		 * 加入断路器功能后，当info-server不可用时，会执行快速失败，执行下面的 hystrixExecute方法，而不是等待响应超时
		 */
		String ret = restTemplate.getForObject("http://info-server/test/getInfo", String.class);
		return ret;
	}
	
	/**
	 * feign测试
	 * @return
	 */
	@RequestMapping("feignTest")
	public String feignTest(){
		String ret = feignService.feignExecute();
		return ret;
	}
	
	/**
	 * restRibbonTest的熔断方法
	 * @return
	 */
	public String hystrixExecute(){
		return "restRibbonHystrix error";
	}
	
}
