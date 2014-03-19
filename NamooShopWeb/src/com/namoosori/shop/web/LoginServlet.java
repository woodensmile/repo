package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 3726843598739947134L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		
		String userId = context.getInitParameter("adminId");
		String password = context.getInitParameter("password");
		
		String paramLoginId = req.getParameter("loginId");
		String ParamPassword = req.getParameter("password");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = resp.getWriter();
		
		if(userId.equals(paramLoginId) && password.equals(ParamPassword)){
			HttpSession session = req.getSession();
			session.setAttribute("loginId", userId);
			resp.sendRedirect("main.xhtml");
		}else{
			HttpSession session=req.getSession();
			session.getAttribute("loginId");
			resp.sendRedirect("login.xhtml");
		}
		
		writer.println("</body>");
		writer.println("</html>");
	}

}
