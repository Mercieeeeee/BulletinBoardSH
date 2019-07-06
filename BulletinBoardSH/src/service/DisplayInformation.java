package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/service/DisplayInformation")
public class DisplayInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int pageNo = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String pageNoStr = request.getParameter("pageNo");
		List<BulletinBoardBean> list = null;
		if (pageNoStr == null) {
			pageNo = 1;
			try {
				session.beginTransaction();					BulletinBoardDAO bbd = new BulletinBoardDAO(session);
				list = bbd.selectMany(pageNo);
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
				throw e;
			}
		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (Exception e) {
				pageNo = 1;
			}
			try {
				session.beginTransaction();
				BulletinBoardDAO bbd = new BulletinBoardDAO(session);
				list = bbd.selectMany(10*(pageNo - 1) + 1);
				session.getTransaction().commit();
			} catch (Exception e) {					session.getTransaction().rollback();
				throw e;
			}
		}
		request.setAttribute("InformationList", list);
		request.setAttribute("pageNo", pageNo);
		RequestDispatcher rd = request.getRequestDispatcher("bulletinBoard.jsp");
		rd.forward(request, response);
		return;
	}
}
