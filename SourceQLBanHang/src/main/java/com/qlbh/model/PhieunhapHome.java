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
import com.qlbh.pojo.Phieunhap;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Phieunhap.
 * @see com.qlbh.model.Phieunhap
 * @author Hibernate Tools
 */
@Stateless
public class PhieunhapHome extends AbstractDao {
	private static final Logger logger = Logger.getLogger(PhieunhapHome.class);
	private Session session;

	public List findAll() throws DataAccessLayerException {
		 return super.findAll(Phieunhap.class);
	}
	
	public List getDataInPeriodTime(Date beginDay, Date enđDay) throws DataAccessLayerException {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			String hql = "from "+Phieunhap.class.getName()+" where activity = true and (ngaynhap BETWEEN :beginDay AND :enđDay)";
			Query query = session.createQuery(hql);
			query.setDate("beginDay", beginDay);
			query.setDate("enđDay", enđDay);
			List<Phieunhap> ds = query.list();
			return ds;
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findFirst:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return null;
	}

	public void save(Phieunhap phieuNhap) {
		super.save(phieuNhap);
		super.saveNhatKy("Phiếu nhập", "Thêm");
	}

	public void update(Phieunhap phieuNhap) {
		super.update(phieuNhap);
		super.saveNhatKy("Phiếu nhập", "Cập nhật");
	}

	public void deletePermanently(Phieunhap phieuNhap) {
		super.delete(phieuNhap);
		super.saveNhatKy("Phiếu nhập", "Xóa");
	}

	public void delete(Phieunhap phieuNhap) {
		phieuNhap.setActivity(false);
		super.update(phieuNhap);
		super.saveNhatKy("Phiếu nhập", "Xóa");
	}
}
