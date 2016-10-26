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
import com.qlbh.pojo.Loaihang;
import com.qlbh.pojo.Nhomhanghoa;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Nhomhanghoa.
 * @see com.qlbh.model.Nhomhanghoa
 * @author Hibernate Tools
 */
@Stateless
public class NhomhanghoaHome extends AbstractDao{

	private static final Log log = LogFactory.getLog(NhomhanghoaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Nhomhanghoa transientInstance) {
		log.debug("persisting Nhomhanghoa instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Nhomhanghoa persistentInstance) {
		log.debug("removing Nhomhanghoa instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Nhomhanghoa merge(Nhomhanghoa detachedInstance) {
		log.debug("merging Nhomhanghoa instance");
		try {
			Nhomhanghoa result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Nhomhanghoa findById(Integer id) {
		log.debug("getting Nhomhanghoa instance with id: " + id);
		try {
			Nhomhanghoa instance = entityManager.find(Nhomhanghoa.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Nhomhanghoa> getNhomHangHoaList() {
		Session session = HibernateFactory.openSession();
		List<Nhomhanghoa> loaiHangs = null;
		try {
			String hql = "FROM Nhomhanghoa Where Activity = true";
			Query query = session.createQuery(hql);
			loaiHangs = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return loaiHangs;
	}
}
