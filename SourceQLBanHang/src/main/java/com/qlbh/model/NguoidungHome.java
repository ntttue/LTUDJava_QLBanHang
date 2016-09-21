package com.qlbh.model;
// Generated 21/09/2016 5:08:23 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Nguoidung;

/**
 * Home object for domain model class Nguoidung.
 * @see com.qlbh.model.Nguoidung
 * @author Hibernate Tools
 */
@Stateless
public class NguoidungHome {

	private static final Log log = LogFactory.getLog(NguoidungHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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

	public Nguoidung findById(String id) {
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
}
