package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Phieunhap;
import com.qlbh.pojo.Phieuxuat;

/**
 * Home object for domain model class Phieuxuat.
 * @see com.qlbh.model.Phieuxuat
 * @author Hibernate Tools
 */
@Stateless
public class PhieuxuatHome extends AbstractDao{

	private static final Log log = LogFactory.getLog(PhieuxuatHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Phieuxuat transientInstance) {
		log.debug("persisting Phieuxuat instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Phieuxuat persistentInstance) {
		log.debug("removing Phieuxuat instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Phieuxuat merge(Phieuxuat detachedInstance) {
		log.debug("merging Phieuxuat instance");
		try {
			Phieuxuat result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Phieuxuat findById(Integer id) {
		log.debug("getting Phieuxuat instance with id: " + id);
		try {
			Phieuxuat instance = entityManager.find(Phieuxuat.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Phieuxuat save(Phieuxuat phieuxuat){
		super.save(phieuxuat);
		return phieuxuat;
	}
	
	public Phieuxuat update(Phieuxuat phieuxuat){
		super.update(phieuxuat);
		return phieuxuat;
	}
}
