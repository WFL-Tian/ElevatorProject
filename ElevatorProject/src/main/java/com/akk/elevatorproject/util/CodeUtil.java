package com.akk.elevatorproject.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request,String verifycode) {
		String verifyCodeExpected = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (verifycode == null
				|| !verifycode.equalsIgnoreCase(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
