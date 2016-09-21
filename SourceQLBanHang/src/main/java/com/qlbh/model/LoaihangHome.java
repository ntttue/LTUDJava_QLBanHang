package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Loaihang;

/**
 * Home object for domain model class Loaihang.
 * @see com.qlbh.model.Loaihang
 * @author Hibernate Tools
 */
@Stateless
public class LoaihangHome {

	private static final Log log = LogFactory.getLog(LoaihangHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Loaihang transientInstance) {
		log.debug("persisting Loaihang instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Loaihang persistentInstance) {
		log.debug("removing Loaihang instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Loaihang merge(Loaihang detachedInstance) {
		log.debug("merging Loaihang instance");
		try {
			Loaihang result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Loaihang findById(int id) {
		log.debug("getting Loaihang instance with id: " + id);
		try {
			Loaihang instance = entityManager.find(Loaihang.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
