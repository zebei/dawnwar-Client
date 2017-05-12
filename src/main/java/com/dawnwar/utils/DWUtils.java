package com.dawnwar.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class DWUtils {
	/***
	 * List<String> 中值为数字 进行排序重写的collections compare方法
	 * @param list
	 */
	public static void sortListStrings(List<String> list) {
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				long s1 = Long.valueOf((String) o1);
				long s2 = Long.valueOf((String) o2);
				if (s1 > s2) {
					return 1;
				}
				if (s1 < s2) {
					return -1;
				}
				return 0;
			}

		});
	}
	/***
	 * 生成guid 去掉“——” 转全部大写
	 * @return
	 */
	public static String getGUID(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", ""); 
		return uuid.toUpperCase();
	}
	
	
	
	private static final String String_AMP = "&amp;";
	private static final String String_AMP_TRANS = "&";
	private static final String STRING_QUOT = "&quot;";
	private static final String STRING_QUOT_TRANS = "\"";
	private static final String STRING_SPRIT = "&#39;";
	private static final String STRING_SPRIT_TRANS = "\\";
	private static final String STRING_LT = "&lt;";
	private static final String STRING_LT_TRANS = "<";
	private static final String STRING_GT = "&gt;";
	private static final String STRING_GT_TRANS = ">";

	/**
	 * 
	 * @param beReplaceName
	 * @return
	 */
	public static String escapeCharacterTransfer(String str) {
		String toward = str;
		if (String.valueOf(str).contains(String_AMP)
				|| String.valueOf(str).contains(STRING_QUOT)
				|| String.valueOf(str).contains(STRING_SPRIT)
				|| String.valueOf(str).contains(STRING_LT)
				|| String.valueOf(str).contains(STRING_GT)) {
			toward = str.replace(String_AMP, String_AMP_TRANS)
					.replace(STRING_QUOT, STRING_QUOT_TRANS)
					.replace(STRING_SPRIT, STRING_SPRIT_TRANS)
					.replace(STRING_LT, STRING_LT_TRANS)
					.replace(STRING_GT, STRING_GT_TRANS);
		}
		return toward;
	}
	
}
