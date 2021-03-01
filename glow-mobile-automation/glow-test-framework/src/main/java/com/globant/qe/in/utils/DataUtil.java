package com.globant.qe.in.utils;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataUtil {

	public Map<String, String> testData(Method method, String jsonKey) {

		ObjectMapper mapper = new ObjectMapper();
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		Map<String, String> hashMap = null;
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(FileUtil.fileName(method)));
			JSONObject jsonInnerObject = (JSONObject) jsonObject.get(jsonKey);
			hashMap = mapper.readValue(jsonInnerObject.toJSONString(), new TypeReference<Map<String, String>>() {
			});
		} catch (IOException | ParseException e) {

		}
		return hashMap;
	}

}
