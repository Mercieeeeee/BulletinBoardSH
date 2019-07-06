package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.MemberBean;

public class MemberDAO {
	private Session session = null;
	public MemberDAO(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}
	
	public MemberBean select(int no) {
		return (MemberBean) this.getSession().get(MemberBean.class, no);
	}
	
	public List<MemberBean> selectMany(int first) {
		Query query = this.getSession().createQuery("FROM MemberBean", MemberBean.class);
		query.setFirstResult(first);
		query.setMaxResults(10);
		return (List<MemberBean>) query.list(); 
	}
	
	public List<MemberBean> selectAll() {
		Query query = this.getSession().createQuery("from MemberBean");
		return (List<MemberBean>) query.list();
	}
	
	public int insert(MemberBean bean) {
		int n = 0;
		MemberBean temp = (MemberBean) this.getSession().get(MemberBean.class, bean.getUserId());
		if (temp == null) {
			this.getSession().save(bean);
			n = 1;
			return n;
		}
		return n;
	}
	
	public int update(String userId, String password) {
		int n = 0;
		MemberBean result = (MemberBean) this.getSession().get(MemberBean.class, userId);
		if (result == null) {
			result = new MemberBean(userId, password);
			n = 1;
			return n;
		}
		return n;
	}
	
	public int delete(String userId, String password) {
		MemberBean bean = (MemberBean) this.getSession().get(MemberBean.class, userId);
		if (bean != null) {
			if (password == bean.getPassword()) {
			this.getSession().delete(bean);
			return 1;
			}
		}
		return 0;
	}
	
	public MemberBean searchByUserId(String userId) {
		MemberBean bean = (MemberBean) this.getSession().get(MemberBean.class, userId);
		if (bean != null) {
			return bean;
		} else {
			return null;
		}
	}
	
	public int getCounts() {
		int counts = 0;
		String hql = "SELECT count(*) FROM MemberBean";
		Query query = this.getSession().createQuery(hql);
		counts = ((int)query.uniqueResult());
		return counts;
	}
	
	public int getTotalPages() {
		int totalPages = (int) (Math.ceil(getCounts()/10));
		return totalPages;
	}
}
