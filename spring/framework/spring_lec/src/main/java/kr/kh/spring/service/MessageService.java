package kr.kh.spring.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class MessageService { // interface 안거치고 바로 클래스로(기능 몇개 안돼서....)

	public void sendMessage(HttpServletResponse response, HttpServletRequest request, String message, String url) {
		response.setContentType("text/html;charset=UTF-8"); // 응답 객체
		PrintWriter out;
		try {
			out = response.getWriter();

			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='" + request.getContextPath() + url + "'");
			out.println("</script>");
			out.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
