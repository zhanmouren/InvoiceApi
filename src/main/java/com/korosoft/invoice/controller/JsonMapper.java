package com.korosoft.invoice.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JsonMapper() {
		this(Include.NON_EMPTY);
	}
	
	public JsonMapper(Include include) {
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
			@Override
			public void serialize(Object object, JsonGenerator generator,SerializerProvider provider) throws IOException,JsonProcessingException {
				generator.writeString("");
			}
		});
	}
}
