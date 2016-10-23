package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.qlbh.model.common.AbstractDao;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;
import com.qlbh.pojo.Bophan;
import java.util.List;

/**
 * Home object for domain model class Bophan.
 * 
 * @see com.qlbh.model.Bophan
 * @author Hibernate Tools
 */
@Stateless
public class BophanHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(BophanHome.class);
	private Session session;

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Bophan.class);
	}

	// public void save(Bophan obj) {
	// super.save(obj);
	// }
	public Boolean saveReturnObj(Bophan obj) {
		Integer result = super.saveReturnID(obj);
		System.out.println(result);
		if (result != null) {
			return true;
		}
		return false;
	}

	public void update(Bophan obj) {
		super.update(obj);
	}

	public void deletePermanently(Bophan obj) {
		super.delete(obj);
	}

	public void delete(Bophan obj) {
		obj.setActivity(false);
		super.update(obj);
	}

	public Bophan findByMa(String ma) {
		Bophan bp = null;
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			// startOperation();
			String hql = "from Bophan bp where bp.ma = :ma and activity = true";
			Query query = session.createQuery(hql);
			query.setParameter("ma", ma);
			List<Bophan> ds = query.list();
			if (!ds.isEmpty()) {
				bp = new Bophan();
				bp = ds.get(0);
				System.out.println(bp.getTen());
			}
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findByMa:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return bp;
	}
}
