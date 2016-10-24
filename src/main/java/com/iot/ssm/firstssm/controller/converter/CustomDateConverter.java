package com.iot.ssm.firstssm.controller.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String,Date> {
	
	
	public Date convert(String s){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try{
			return simpleDateFormat.parse(s);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return null;
	}

}
