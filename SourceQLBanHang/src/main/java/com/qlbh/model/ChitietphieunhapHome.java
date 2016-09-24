package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Chitietphieunhap;

/**
 * Home object for domain model class Chitietphieunhap.
 * @see com.qlbh.model.Chitietphieunhap
 * @author Hibernate Tools
 */
@Stateless
public class ChitietphieunhapHome {

	private static final Log log = LogFactory.getLog(ChitietphieunhapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Chitietphieunhap transientInstance) {
		log.debug("persisting Chitietphieunhap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Chitietphieunhap persistentInstance) {
		log.debug("removing Chitietphieunhap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Chitietphieunhap merge(Chitietphieunhap detachedInstance) {
		log.debug("merging Chitietphieunhap instance");
		try {
			Chitietphieunhap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Chitietphieunhap findById(Integer id) {
		log.debug("getting Chitietphieunhap instance with id: " + id);
		try {
			Chitietphieunhap instance = entityManager.find(Chitietphieunhap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
