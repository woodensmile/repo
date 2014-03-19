package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/main.xhtml")
public class Main extends HttpServlet {

	private static final long serialVersionUID = -5441914164986289841L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Insert title here</title>");
		writer.println("<link href='./booklist.css' rel='stylesheet' type='text/css' />");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>상품목록</h1>");

		writer.println("<table>");
		writer.println("<thead>");
		writer.println("<tr>");
		writer.println("<th></th>");
		writer.println("<th class='1'>상품번호</th>");
		writer.println("<th class='2'>상품명</th>");
		writer.println("<th class='3'>가격</th>");
		writer.println("<th class='4'>평점</th>");
		writer.println("</tr>");
		
		writer.println("</thead>");
		writer.println("<tbody>");
		
		ProductService productService = NamooShopServiceFactory.getInstance().getProductService();
		List<Product> products = productService.getAllProducts();
		
		for (Product product : products) {
			writer.println("<tr>");
			writer.println("<td class='books'><input type='checkbox' name='book' value='"+product.getSerialNo()+"'/></td>");
			writer.println("<td class='1' >"+product.getSerialNo()+"</td>");
			writer.println("<td class='2' >"+product.getName()+"</td>");
			writer.println("<td class='3'>"+product.getPrice()+"</td>");
			writer.println("<td class='4'>"+product.getLike()+"</td>");//TODO.
			writer.println("</tr>");
		}
		
		writer.println("</tbody>");
		writer.println("</table>");
		writer.println("<input type='submit' id='jumun' value='주문하기'/>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
