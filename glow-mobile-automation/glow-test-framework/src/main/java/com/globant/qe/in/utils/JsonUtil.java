package com.globant.qe.in.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.globant.qe.in.exceptions.ApiModelChangedException;

public class JsonUtil {
	
	public static <T> T jsonToBean(String json, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(json, clazz);
		} catch (Exception e) {
			if (e instanceof UnrecognizedPropertyException) {
				throw new ApiModelChangedException(e);
			}
		}
		return null;
	}


}
