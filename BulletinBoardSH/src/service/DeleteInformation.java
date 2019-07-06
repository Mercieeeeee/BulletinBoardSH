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

@WebServlet("/service/DeleteInformation")
public class DeleteInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String noStr = request.getParameter("no");
		int no = Integer.parseInt(noStr.trim());
		int n = 0;
		try {
			session.beginTransaction();
			BulletinBoardDAO bbd = new BulletinBoardDAO(session);
			n = bbd.delete(no);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (n == 1) {
			response.sendRedirect("../deleteSuccess.jsp");
		} else {
			response.sendRedirect("../deleteError.jsp");
		}
	}

}
