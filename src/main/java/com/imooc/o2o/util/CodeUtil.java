package com.imooc.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static Boolean checkVerifyCode(HttpServletRequest request) {
        // 在shopOperation.html中img的src发送请求给/o2o/Kaptcha给Kaptcha Servlet的时候，
        // 同时图片真实的验证码就会种植在session中，便于校验用户输入与真实是否相同
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCode = HttpServletRequestUtil.getString(request, "verifyCodeActual");
        if (verifyCode == null || !verifyCode.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
