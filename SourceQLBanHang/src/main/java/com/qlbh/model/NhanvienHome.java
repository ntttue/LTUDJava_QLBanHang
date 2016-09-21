package com.qlbh.model;
// Generated 21/09/2016 7:13:01 PM by Hibernate Tools 4.3.5.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Nhanvien;

/**
 * Home object for domain model class Nhanvien.
 * @see com.qlbh.model.Nhanvien
 * @author Hibernate Tools
 */
@Stateless
public class NhanvienHome {

	private static final Log log = LogFactory.getLog(NhanvienHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Nhanvien transientInstance) {
		log.debug("persisting Nhanvien instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Nhanvien persistentInstance) {
		log.debug("removing Nhanvien instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Nhanvien merge(Nhanvien detachedInstance) {
		log.debug("merging Nhanvien instance");
		try {
			Nhanvien result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Nhanvien findById(int id) {
		log.debug("getting Nhanvien instance with id: " + id);
		try {
			Nhanvien instance = entityManager.find(Nhanvien.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
