package com.wanghuan.utils;

import java.util.regex.Pattern;

public class MyStringUtil {

	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
}
	
}
