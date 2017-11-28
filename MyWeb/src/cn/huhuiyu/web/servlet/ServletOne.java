package cn.huhuiyu.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ServletOne",urlPatterns="/index.servlet")
public class ServletOne  extends HttpServlet{

	private static final long serialVersionUID = 7643480591521772048L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("<h1>servlet你好</h1>");
	}
}
