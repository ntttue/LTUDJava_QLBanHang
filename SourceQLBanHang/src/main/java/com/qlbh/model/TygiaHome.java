package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.pojo.Tygia;
import com.qlbh.util.HibernateUtil;

/**
 * Home object for domain model class Tygia.
 * @see com.qlbh.model.Tygia
 * @author Hibernate Tools
 */
@Stateless
public class TygiaHome {

	private static final Log log = LogFactory.getLog(TygiaHome.class);

	@PersistenceContext
	private EntityManager entityManager;
	Session session = HibernateUtil.getSessionFactory().openSession();

	public void persist(Tygia transientInstance) {
		log.debug("persisting Tygia instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tygia persistentInstance) {
		log.debug("removing Tygia instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tygia merge(Tygia detachedInstance) {
		log.debug("merging Tygia instance");
		try {
			Tygia result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tygia findById(Integer id) {
		log.debug("getting Tygia instance with id: " + id);
		try {
			Tygia instance = entityManager.find(Tygia.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Get List TyGia
	 * @return
	 */
	public List<Tygia> getTygias() {
		String hql = "from Tygia";
		Query query = session.createQuery(hql);
		List<Tygia> tygias = query.list();
		if (!tygias.isEmpty()) {
			return tygias;
		}
		return null;
	}
}
