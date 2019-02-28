package com.jason.test;

import org.springframework.stereotype.Component;

/**
 * 该类实现了FeignService接口，具体的方法就是对应的熔断方法
 * @author jason
 *
 */
@Component
public class FeignHystrixBack implements FeignService{

	@Override
	public String feignExecute() {
		return "feignHystrix Erroe";
	}

}
