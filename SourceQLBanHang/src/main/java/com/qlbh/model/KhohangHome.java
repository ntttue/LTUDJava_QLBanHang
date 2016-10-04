package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Khohang.
 * @see com.qlbh.model.Khohang
 * @author Hibernate Tools
 */
@Stateless
public class KhohangHome {

	private static final Log log = LogFactory.getLog(KhohangHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Khohang transientInstance) {
		log.debug("persisting Khohang instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Khohang persistentInstance) {
		log.debug("removing Khohang instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Khohang merge(Khohang detachedInstance) {
		log.debug("merging Khohang instance");
		try {
			Khohang result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Khohang findById(Integer id) {
		log.debug("getting Khohang instance with id: " + id);
		try {
			Khohang instance = entityManager.find(Khohang.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Khohang> getKhoHangList() {
		Session session = HibernateFactory.openSession();
		List<Khohang> khohangs = null;
		try {
			String hql = "FROM Khohang";
			Query query = session.createQuery(hql);
			khohangs = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return khohangs;
	}
}
