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

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhacungcap;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Nhacungcap.
 * @see com.qlbh.model.Nhacungcap
 * @author Hibernate Tools
 */
@Stateless
public class NhacungcapHome extends AbstractDao{

	private static final Log log = LogFactory.getLog(NhacungcapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Nhacungcap transientInstance) {
		log.debug("persisting Nhacungcap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Nhacungcap persistentInstance) {
		log.debug("removing Nhacungcap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Nhacungcap merge(Nhacungcap detachedInstance) {
		log.debug("merging Nhacungcap instance");
		try {
			Nhacungcap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Nhacungcap findById(Integer id) {
		log.debug("getting Nhacungcap instance with id: " + id);
		try {
			Nhacungcap instance = entityManager.find(Nhacungcap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Nhacungcap> getNhaCungCapList() {
		Session session = HibernateFactory.openSession();
		List<Nhacungcap> khohangs = null;
		try {
			String hql = "FROM Nhacungcap Where Activity = true";
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
