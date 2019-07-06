package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.BulletinBoardDAO;
import util.HibernateUtil;

@WebServlet("/service/UpdateInformation")
public class UpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String noStr = request.getParameter("no");
		int no = Integer.parseInt(noStr.trim());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int n = 0;
		try {
			session.beginTransaction();
			BulletinBoardDAO bbd = new BulletinBoardDAO(session);
			n = bbd.update(no, title, content);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (n == 1) {
			response.sendRedirect("../updateleteSuccess.jsp");
		} else {
			response.sendRedirect("../updateError.jsp");
		}
	}

}
