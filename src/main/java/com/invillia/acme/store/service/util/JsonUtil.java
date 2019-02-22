package com.invillia.acme.store.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	public static String generateJsonOfObject(Object obj) {
		
		ObjectMapper objMapper = new ObjectMapper();
		String json = obj.toString();
		
		try {
			json = objMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// n�o faz nada
		}
		
		return json;
	}

}
