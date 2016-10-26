package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Nhomhanghoa;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Nhomhanghoa.
 * 
 * @see com.qlbh.model.Nhomhanghoa
 * @author Hibernate Tools
 */
@Stateless
public class NhomhanghoaHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(NhomhanghoaHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Nhomhanghoa.class);
	}

	public void save(Nhomhanghoa nhh) {
		super.save(nhh);
		super.saveNhatKy("Nhóm hàng hóa", "Thêm");
	}

	public void update(Nhomhanghoa nhh) {
		super.update(nhh);
		super.saveNhatKy("Nhóm hàng hóa", "Cập nhật");
	}

	public void delete(Nhomhanghoa nhh) {
		nhh.setActivity(false);
		super.update(nhh);
		super.saveNhatKy("Nhóm hàng hóa", "Xóa");
	}

	public List<Nhomhanghoa> getNhomHangHoaList() {
		Session session = HibernateFactory.openSession();
		List<Nhomhanghoa> loaiHangs = null;
		try {
			String hql = "FROM Nhomhanghoa Where Activity = true";
			Query query = session.createQuery(hql);
			loaiHangs = query.list();
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return loaiHangs;
	}
}
