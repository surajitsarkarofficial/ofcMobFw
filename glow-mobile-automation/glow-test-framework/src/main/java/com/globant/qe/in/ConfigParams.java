package com.globant.qe.in;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigParams {

	@Value("${browser.name:chrome}")
	public String browserName;

	@Value("${base.url:https://www.google.co.in/}")
	public String baseUrl;

	@Value("${max.small.wait:10}")
	public long maxSmallWait;

	@Value("${max.big.wait:30}")
	public long maxBigWait;
	
	@Value("${data.path}")
	public String dataPath;
	
}
