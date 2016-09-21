package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Congty;

/**
 * Home object for domain model class Congty.
 * @see com.qlbh.model.Congty
 * @author Hibernate Tools
 */
@Stateless
public class CongtyHome {

	private static final Log log = LogFactory.getLog(CongtyHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Congty transientInstance) {
		log.debug("persisting Congty instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Congty persistentInstance) {
		log.debug("removing Congty instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Congty merge(Congty detachedInstance) {
		log.debug("merging Congty instance");
		try {
			Congty result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Congty findById(short id) {
		log.debug("getting Congty instance with id: " + id);
		try {
			Congty instance = entityManager.find(Congty.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
