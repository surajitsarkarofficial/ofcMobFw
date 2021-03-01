package com.globant.qe.in.dataprovider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

import com.globant.qe.in.utils.FileUtil;

@SuppressWarnings("unchecked")
@Component
public class TestDataProvider {

	@DataProvider(name = "testDataProvider")
	public static Iterator<Object[]> getData(Method method) {

		List<Object[]> list = null;
		try {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(FileUtil.fileName(method)));
			list = (List<Object[]>) jsonArray.stream().map(object -> {
				JSONObject jsonObj = (JSONObject) object;
				return new Object[] { extractValues(jsonObj.toString()) };
			}).collect(Collectors.toList());
		} catch (ParseException | IOException e) {

		}
		return list.iterator();
	}

	private static Map<String, String> extractValues(String str) {
		Map<String, String> hashMap = null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(str);
			hashMap = (Map<String, String>) object.keySet().stream()
					.collect(Collectors.toMap(key -> key.toString(), key -> object.get(key.toString()).toString()));
		} catch (ParseException e) {

		}
		return hashMap;
	}

}
