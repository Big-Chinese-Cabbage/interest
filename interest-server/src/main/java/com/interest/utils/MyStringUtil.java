package com.interest.utils;

import java.util.regex.Pattern;

public class MyStringUtil {

    /**
     * 判断String是否位数字
     * @param str
     * @return
     */
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
}
	
}
