package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Nhacungcap;

/**
 * Home object for domain model class Nhacungcap.
 * @see com.qlbh.model.Nhacungcap
 * @author Hibernate Tools
 */
@Stateless
public class NhacungcapHome {

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

	public Nhacungcap findById(int id) {
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
}
