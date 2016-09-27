package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.pojo.Nguoidung;
import com.qlbh.util.HibernateUtil;
import java.util.List;

/**
 * Home object for domain model class Nguoidung.
 * 
 * @see com.qlbh.model.Nguoidung
 * @author Hibernate Tools
 */
@Stateless
public class NguoidungHome {

	private static final Log log = LogFactory.getLog(NguoidungHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	Session session = HibernateUtil.getSessionFactory().openSession();

	public void persist(Nguoidung transientInstance) {
		log.debug("persisting Nguoidung instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Nguoidung persistentInstance) {
		log.debug("removing Nguoidung instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Nguoidung merge(Nguoidung detachedInstance) {
		log.debug("merging Nguoidung instance");
		try {
			Nguoidung result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Nguoidung findById(Integer id) {
		log.debug("getting Nguoidung instance with id: " + id);
		try {
			Nguoidung instance = entityManager.find(Nguoidung.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Nguoidung findByUsenamePass(String tenDangNhap, String matKhau) {
		Nguoidung nd = new Nguoidung();
		String hql = "from Nguoidung nd where nd.tennd = :tennd and nd.matkhau = :matkhau";
//		 String hql = "from Nguoidung";

		Query query = session.createQuery(hql);
		query.setParameter("tennd", tenDangNhap);
		query.setParameter("matkhau", matKhau);
		List<Nguoidung> ds = query.list();
		if (!ds.isEmpty()) {
			nd = ds.get(0);
			System.out.println(nd.getTennd());
			return nd;
		}

		return null;
	}
}
