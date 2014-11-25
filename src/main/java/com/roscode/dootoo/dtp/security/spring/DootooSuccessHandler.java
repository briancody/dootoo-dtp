package com.roscode.dootoo.dtp.security.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class DootooSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Gson gson = new Gson();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("success", "true");
		String json = gson.toJson(map);
		PrintWriter writer = response.getWriter();
		writer.print(json);
		clearAuthenticationAttributes(request);
	}

}
