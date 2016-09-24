package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Khuvuc;

/**
 * Home object for domain model class Khuvuc.
 * @see com.qlbh.model.Khuvuc
 * @author Hibernate Tools
 */
@Stateless
public class KhuvucHome {

	private static final Log log = LogFactory.getLog(KhuvucHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Khuvuc transientInstance) {
		log.debug("persisting Khuvuc instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Khuvuc persistentInstance) {
		log.debug("removing Khuvuc instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Khuvuc merge(Khuvuc detachedInstance) {
		log.debug("merging Khuvuc instance");
		try {
			Khuvuc result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Khuvuc findById(Integer id) {
		log.debug("getting Khuvuc instance with id: " + id);
		try {
			Khuvuc instance = entityManager.find(Khuvuc.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
