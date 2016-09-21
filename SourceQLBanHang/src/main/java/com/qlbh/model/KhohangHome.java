package com.qlbh.model;
// Generated 21/09/2016 5:08:23 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Khohang;

/**
 * Home object for domain model class Khohang.
 * @see com.qlbh.model.Khohang
 * @author Hibernate Tools
 */
@Stateless
public class KhohangHome {

	private static final Log log = LogFactory.getLog(KhohangHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Khohang transientInstance) {
		log.debug("persisting Khohang instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Khohang persistentInstance) {
		log.debug("removing Khohang instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Khohang merge(Khohang detachedInstance) {
		log.debug("merging Khohang instance");
		try {
			Khohang result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Khohang findById(int id) {
		log.debug("getting Khohang instance with id: " + id);
		try {
			Khohang instance = entityManager.find(Khohang.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
