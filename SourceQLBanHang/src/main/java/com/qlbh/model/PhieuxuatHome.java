package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Phieuxuat;

/**
 * Home object for domain model class Phieuxuat.
 * @see com.qlbh.model.Phieuxuat
 * @author Hibernate Tools
 */
@Stateless
public class PhieuxuatHome {

	private static final Log log = LogFactory.getLog(PhieuxuatHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Phieuxuat transientInstance) {
		log.debug("persisting Phieuxuat instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Phieuxuat persistentInstance) {
		log.debug("removing Phieuxuat instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Phieuxuat merge(Phieuxuat detachedInstance) {
		log.debug("merging Phieuxuat instance");
		try {
			Phieuxuat result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Phieuxuat findById(int id) {
		log.debug("getting Phieuxuat instance with id: " + id);
		try {
			Phieuxuat instance = entityManager.find(Phieuxuat.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
