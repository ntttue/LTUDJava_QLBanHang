package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.pojo.Khachhang;
import com.qlbh.util.HibernateUtil;

/**
 * Home object for domain model class Khachhang.
 * @see com.qlbh.model.Khachhang
 * @author Hibernate Tools
 */
@Stateless
public class KhachhangHome {

	private static final Log log = LogFactory.getLog(KhachhangHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public KhachhangHome() {
		super();
	}

	public void persist(Khachhang transientInstance) {
		log.debug("persisting Khachhang instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Khachhang persistentInstance) {
		log.debug("removing Khachhang instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Khachhang merge(Khachhang detachedInstance) {
		log.debug("merging Khachhang instance");
		try {
			Khachhang result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Khachhang findById(Integer id) {
		log.debug("getting Khachhang instance with id: " + id);
		try {
			Khachhang instance = entityManager.find(Khachhang.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List<Khachhang> getKhachHangs() {
		String hql = "from Khachhang";
		Query query = session.createQuery(hql);
		List<Khachhang> khachHangs = query.list();
		if (!khachHangs.isEmpty()) {
			return khachHangs;
		}
		return null;
	}
}
