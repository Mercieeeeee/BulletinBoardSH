package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.BulletinBoardBean;

public class BulletinBoardDAO {
	private Session session = null;
	public BulletinBoardDAO(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	public BulletinBoardBean select(int no) {
		return (BulletinBoardBean) this.getSession().get(BulletinBoardBean.class, no);
	}
	
	public List<BulletinBoardBean> selectMany(int first) {
		Query query = this.getSession().createQuery("FROM BulletinBoardBean", BulletinBoardBean.class);
		query.setFirstResult(first);
		query.setMaxResults(10);
		return (List<BulletinBoardBean>) query.list(); 
	}
	
	public List<BulletinBoardBean> selectAll() {
		Query query = this.getSession().createQuery("from BulletinBoardBean");
		return (List<BulletinBoardBean>) query.list();
	}
	
	public int insert(BulletinBoardBean bean) {
		int n = 0;
		BulletinBoardBean temp = (BulletinBoardBean) this.getSession().get(BulletinBoardBean.class, bean.getNo());
		if (temp == null) {
			this.getSession().save(bean);
			n = 1;
			return n;
		}
		return n;
	}
	
	public int update(int no, String title, String content) {
		int n = 0;
		BulletinBoardBean result = (BulletinBoardBean) this.getSession().get(BulletinBoardBean.class, no);
		if (result == null) {
			result.setTitle(title);
			result.setContent(content);
			n = 1;
			return n;
		}
		return n;
	}
	
	public int delete(int no) {
		BulletinBoardBean bean = (BulletinBoardBean) this.getSession().get(BulletinBoardBean.class, no);
		if (bean != null) {
			this.getSession().delete(bean);
			return 1;
		}
		return 0;
	}
	
	public int searchByTitle(String title) {
		BulletinBoardBean bean = (BulletinBoardBean) this.getSession().get(BulletinBoardBean.class, title);
		int no = bean.getNo();
		return no;
	}
	
	public int getCounts() {
		int counts = 0;
		String hql = "SELECT count(*) FROM BulletinBoard";
		Query query = this.getSession().createQuery(hql);
		counts = ((int)query.uniqueResult());
		return counts;
	}
	
	public int getTotalPages() {
		int totalPages = (int) (Math.ceil(getCounts()/10));
		return totalPages;
	}
}
