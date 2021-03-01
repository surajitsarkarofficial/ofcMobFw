package com.globant.qe.in.utils;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import com.globant.qe.in.ConfigParams;
import com.globant.qe.in.StaticContextAccessor;

@Component
public class FileUtil {

	private static String TEST_DATA_PATH = System.getProperty("user.dir")
			+ StaticContextAccessor.getBean(ConfigParams.class).dataPath;

	public static String fileName(Method method) {
		StringBuilder resources = new StringBuilder();
		return resources.append(TEST_DATA_PATH).append("/").append(method.getDeclaringClass().getSimpleName())
				.append("/").append(method.getName()).append(".json").toString();
	}
}
