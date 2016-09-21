package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Vaitro;

/**
 * Home object for domain model class Vaitro.
 * @see com.qlbh.model.Vaitro
 * @author Hibernate Tools
 */
@Stateless
public class VaitroHome {

	private static final Log log = LogFactory.getLog(VaitroHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Vaitro transientInstance) {
		log.debug("persisting Vaitro instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Vaitro persistentInstance) {
		log.debug("removing Vaitro instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Vaitro merge(Vaitro detachedInstance) {
		log.debug("merging Vaitro instance");
		try {
			Vaitro result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vaitro findById(int id) {
		log.debug("getting Vaitro instance with id: " + id);
		try {
			Vaitro instance = entityManager.find(Vaitro.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
