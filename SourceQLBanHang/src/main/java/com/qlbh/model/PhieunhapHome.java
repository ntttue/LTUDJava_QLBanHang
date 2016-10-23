package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Phieunhap;

/**
 * Home object for domain model class Phieunhap.
 * @see com.qlbh.model.Phieunhap
 * @author Hibernate Tools
 */
@Stateless
public class PhieunhapHome extends AbstractDao{

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

	public Phieunhap findById(Integer id) {
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
	
	public int save(Phieunhap phieunhap){
		super.save(phieunhap);
		return phieunhap.getId();
	}
}
