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
import com.qlbh.pojo.Loaihang;
import com.qlbh.pojo.Nhacungcap;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Loaihang.
 * 
 * @see com.qlbh.model.Loaihang
 * @author Hibernate Tools
 */
@Stateless
public class LoaihangHome extends AbstractDao {

	private static final Log log = LogFactory.getLog(LoaihangHome.class);

	public List findAll() throws DataAccessLayerException {
		return super.findAll(Loaihang.class);
	}

	public void save(Loaihang lh) {
		super.save(lh);
		super.saveNhatKy("Loại hoàng hóa", "Thêm");
	}

	public void update(Loaihang lh) {
		super.update(lh);
		super.saveNhatKy("Loại hoàng hóa", "Cập nhật");
	}

	public void delete(Loaihang lh) {
		lh.setActivity(false);
		super.update(lh);
		super.saveNhatKy("Loại hoàng hóa", "Xóa");
	}
	
	public List<Loaihang> getLoaiHangList() {
		Session session = HibernateFactory.openSession();
		List<Loaihang> loaiHangs = null;
		try {
			String hql = "FROM Loaihang Where Activity = true";
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
