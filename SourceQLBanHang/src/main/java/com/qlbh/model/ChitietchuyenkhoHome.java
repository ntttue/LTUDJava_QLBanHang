package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Chitietchuyenkho;
import com.qlbh.pojo.Chuyenkho;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class ChitietchuyenkhoHome.
 * @see com.qlbh.model.Chitietchuyenkho
 * @author Hibernate Tools
 */
@Stateless
public class ChitietchuyenkhoHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(ChitietchuyenkhoHome.class);
	private Session session;
	public List findAll() throws DataAccessLayerException {
		return super.findAll(Chitietchuyenkho.class);
	}

	public void save(Chitietchuyenkho ctck) {
		super.save(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Thêm");
	}
	public List getCTCKByCKId(Integer chuyenkhoid) throws DataAccessLayerException {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			String hql = "from "+Chitietchuyenkho.class.getName()+" where activity = true and chuyenkhoid";
			Query query = session.createQuery(hql);
			query.setInteger("chuyenkhoid", chuyenkhoid);
			List<Chitietchuyenkho> ds = query.list();
			return ds;
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findFirst:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return null;
	}
	public void update(Chitietchuyenkho ctck) {
		super.update(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Cập nhật");
	}

	public void deletePermanently(Chitietchuyenkho ctck) {
		super.delete(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Xóa");
	}

	public void delete(Chitietchuyenkho ctck) {
		ctck.setActivity(false);
		super.update(ctck);
		super.saveNhatKy("Chi tiết chuyển kho", "Xóa");
	}
}
