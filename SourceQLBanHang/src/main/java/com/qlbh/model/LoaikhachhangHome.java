package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.pojo.Loaikhachhang;

/**
 * Home object for domain model class Loaikhachhang.
 * @see com.qlbh.model.Loaikhachhang
 * @author Hibernate Tools
 */
@Stateless
public class LoaikhachhangHome {

	private static final Log log = LogFactory.getLog(LoaikhachhangHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Loaikhachhang transientInstance) {
		log.debug("persisting Loaikhachhang instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Loaikhachhang persistentInstance) {
		log.debug("removing Loaikhachhang instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Loaikhachhang merge(Loaikhachhang detachedInstance) {
		log.debug("merging Loaikhachhang instance");
		try {
			Loaikhachhang result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Loaikhachhang findById(Integer id) {
		log.debug("getting Loaikhachhang instance with id: " + id);
		try {
			Loaikhachhang instance = entityManager.find(Loaikhachhang.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
