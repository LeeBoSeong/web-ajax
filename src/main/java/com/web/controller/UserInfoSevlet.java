package com.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.service.UserInfoService;
import com.web.service.impl.UserInfoServiceImpl;
import com.web.vo.UserInfoVO;

@WebServlet("/user-info/*")
public class UserInfoSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private UserInfoService uiSerivec = new UserInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);

		String json = "";
		if ("list".equals(uri)) {
			json = gson.toJson(uiSerivec.selectUserInfoList(null));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);

		request.setCharacterEncoding("UTF-8");
		BufferedReader bf = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		while ((str = bf.readLine()) != null) {
			sb.append(str);
		}
		UserInfoVO user = gson.fromJson(sb.toString(), UserInfoVO.class);
		int json = 0;
		
		if("insert".equals(uri)) {
			json = uiSerivec.insertUserInfo(user);
			System.out.println(json);
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
