package com.web.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz){
		
		T bean = null;
		try {
			bean = clazz.newInstance();
			Enumeration<String> enumeration = request.getParameterNames();
			while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return bean;
	}
	
	public static String makeId(){
		return UUID.randomUUID().toString();
	}
	

}
