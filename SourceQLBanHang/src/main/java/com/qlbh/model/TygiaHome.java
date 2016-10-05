package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger.getLogger(TygiaHome.class);
	Session session = HibernateUtil.getSessionFactory().openSession();

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
