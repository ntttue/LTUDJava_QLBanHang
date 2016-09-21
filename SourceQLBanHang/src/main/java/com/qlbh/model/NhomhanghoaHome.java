package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Nhomhanghoa;

/**
 * Home object for domain model class Nhomhanghoa.
 * @see com.qlbh.model.Nhomhanghoa
 * @author Hibernate Tools
 */
@Stateless
public class NhomhanghoaHome {

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

	public Nhomhanghoa findById(int id) {
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
}
