package service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.BulletinBoardDAO;
import entity.BulletinBoardBean;
import util.HibernateUtil;

@WebServlet("/service/CreateInformation")
public class CreateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		BulletinBoardBean bbb = new BulletinBoardBean();
		String title = request.getParameter("title");
		bbb.setTitle(title);
		String author = request.getParameter("author");
		bbb.setAuthor(author);
		Date publishDate = new Date();
		bbb.setPublishDate(publishDate);
		Date deadDate = new Date();
		bbb.setDeadDate(deadDate);
		String content = request.getParameter("content");
		bbb.setContent(content);
		int n = 0;
		try {
			session.beginTransaction();
			BulletinBoardDAO bbd = new BulletinBoardDAO(session);
			n = bbd.insert(bbb);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (n == 1) {
			response.sendRedirect("../success.jsp");
		} else {
			response.sendRedirect("../error.jsp");
		}
	}
}
