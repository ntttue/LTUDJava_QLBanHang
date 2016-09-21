package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Donvitinh;

/**
 * Home object for domain model class Donvitinh.
 * @see com.qlbh.model.Donvitinh
 * @author Hibernate Tools
 */
@Stateless
public class DonvitinhHome {

	private static final Log log = LogFactory.getLog(DonvitinhHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Donvitinh transientInstance) {
		log.debug("persisting Donvitinh instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Donvitinh persistentInstance) {
		log.debug("removing Donvitinh instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Donvitinh merge(Donvitinh detachedInstance) {
		log.debug("merging Donvitinh instance");
		try {
			Donvitinh result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Donvitinh findById(int id) {
		log.debug("getting Donvitinh instance with id: " + id);
		try {
			Donvitinh instance = entityManager.find(Donvitinh.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
