package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Phieunhap;

/**
 * Home object for domain model class Phieunhap.
 * @see com.qlbh.model.Phieunhap
 * @author Hibernate Tools
 */
@Stateless
public class PhieunhapHome {

	private static final Log log = LogFactory.getLog(PhieunhapHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Phieunhap transientInstance) {
		log.debug("persisting Phieunhap instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Phieunhap persistentInstance) {
		log.debug("removing Phieunhap instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Phieunhap merge(Phieunhap detachedInstance) {
		log.debug("merging Phieunhap instance");
		try {
			Phieunhap result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Phieunhap findById(int id) {
		log.debug("getting Phieunhap instance with id: " + id);
		try {
			Phieunhap instance = entityManager.find(Phieunhap.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
