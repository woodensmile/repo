package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login.xhtml")
public class LoginFormservlet extends HttpServlet{

	private static final long serialVersionUID = -506965450338307664L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("loginId") != null){
			resp.sendRedirect("main.xhtml");
			return;
		}
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>로그인</title>");
		writer.println("<link href='./login.css' rel='stylesheet' type='text/css' />");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<form action='login.do' method='post'>");
		writer.println("<table>");
		
		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<td>로그인 ID:<input type='text' name='loginId' class='loginInput' /></td>");
		writer.println("</tr>");
		writer.println("</thead>");

		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<td>패스워드:<input type='password' name='password' class='loginInput' /></td>");
		writer.println("</tr>");
		writer.println("</thead>");
		
		writer.println("</table>");
		writer.println("");
		writer.println("");
		writer.println("<input type='submit' id='id' value='login'>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
