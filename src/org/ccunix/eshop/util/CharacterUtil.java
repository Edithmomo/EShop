package org.ccunix.eshop.util;

import java.io.UnsupportedEncodingException;

public class CharacterUtil {
	
	public static String ISO8859_1ToUtf_8(String isoStr){
		String str = null;
		try {
			str = new String(isoStr.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}

}
