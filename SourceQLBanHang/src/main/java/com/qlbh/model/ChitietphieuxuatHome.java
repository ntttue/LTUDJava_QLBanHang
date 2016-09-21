package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Chitietphieuxuat;

/**
 * Home object for domain model class Chitietphieuxuat.
 * @see com.qlbh.model.Chitietphieuxuat
 * @author Hibernate Tools
 */
@Stateless
public class ChitietphieuxuatHome {

	private static final Log log = LogFactory.getLog(ChitietphieuxuatHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Chitietphieuxuat transientInstance) {
		log.debug("persisting Chitietphieuxuat instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Chitietphieuxuat persistentInstance) {
		log.debug("removing Chitietphieuxuat instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Chitietphieuxuat merge(Chitietphieuxuat detachedInstance) {
		log.debug("merging Chitietphieuxuat instance");
		try {
			Chitietphieuxuat result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Chitietphieuxuat findById(int id) {
		log.debug("getting Chitietphieuxuat instance with id: " + id);
		try {
			Chitietphieuxuat instance = entityManager.find(Chitietphieuxuat.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
