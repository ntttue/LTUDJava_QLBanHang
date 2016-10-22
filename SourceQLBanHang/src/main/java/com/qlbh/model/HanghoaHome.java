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

import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Hanghoa.
 * @see com.qlbh.model.Hanghoa
 * @author Hibernate Tools
 */
@Stateless
public class HanghoaHome {

	private static final Log log = LogFactory.getLog(HanghoaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Hanghoa transientInstance) {
		log.debug("persisting Hanghoa instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Hanghoa persistentInstance) {
		log.debug("removing Hanghoa instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Hanghoa merge(Hanghoa detachedInstance) {
		log.debug("merging Hanghoa instance");
		try {
			Hanghoa result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Hanghoa findById(Integer id) {
		log.debug("getting Hanghoa instance with id: " + id);
		try {
			Hanghoa instance = entityManager.find(Hanghoa.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Hanghoa> getHangHoaList(){
		Session session = HibernateFactory.openSession();
		List<Hanghoa> hanghoas = null;
		try {
			String hql = "FROM Hanghoa Where activity = 1";
			Query query = session.createQuery(hql);
			hanghoas = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return hanghoas;
	}
}
