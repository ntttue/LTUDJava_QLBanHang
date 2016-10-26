package com.qlbh.model;
// Generated 24/09/2016 3:27:00 PM by Hibernate Tools 5.2.0.Beta1

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.qlbh.model.common.AbstractDao;
import com.qlbh.pojo.Phieunhap;
import com.qlbh.pojo.Keeplogged;
import com.qlbh.pojo.Phieuxuat;
import com.qlbh.util.DataAccessLayerException;
import com.qlbh.util.HibernateFactory;

/**
 * Home object for domain model class Phieuxuat.
 * 
 * @see com.qlbh.model.Phieuxuat
 * @author Hibernate Tools
 */
@Stateless
public class PhieuxuatHome extends AbstractDao{
	private static final Logger logger = Logger.getLogger(PhieuxuatHome.class);
	private Session session;

	public List findAll() throws DataAccessLayerException {
		 return super.findAll(Phieuxuat.class);
	}
	
	public List getDataInPeriodTime(Date beginDay, Date enđDay) throws DataAccessLayerException {
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			String hql = "from "+Phieuxuat.class.getName()+" where activity = true and (ngaylap BETWEEN :beginDay AND :enđDay)";
			Query query = session.createQuery(hql);
			query.setDate("beginDay", beginDay);
			query.setDate("enđDay", enđDay);
			List<Phieuxuat> ds = query.list();
			return ds;
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findFirst:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return null;
	}

	public void save(Phieuxuat phieuXuat) {
		super.save(phieuXuat);
		super.saveNhatKy("Phiếu xuất", "Thêm");
	}

	public void update(Phieuxuat phieuXuat) {
		super.update(phieuXuat);
		super.saveNhatKy("Phiếu xuất", "Cập nhật");
	}

	public void deletePermanently(Phieuxuat phieuXuat) {
		super.delete(phieuXuat);
		super.saveNhatKy("Phiếu xuất", "Xóa");
	}

	public void delete(Phieuxuat phieuXuat) {
		phieuXuat.setActivity(false);
		super.update(phieuXuat);
		super.saveNhatKy("Phiếu xuất", "Xóa");
	}
	
	public String getMaPhieu() {
		Session session = HibernateFactory.openSession();
		List<Phieuxuat> phieuNhaps;
		try {
			String hql = "FROM Phieuxuat";
			Query query = session.createQuery(hql);
			phieuNhaps = query.list();
			if (phieuNhaps == null || phieuNhaps.isEmpty()) {
				return "PX0000001";
			} else {
				phieuNhaps.sort(new Comparator<Phieuxuat>() {
					@Override
					public int compare(Phieuxuat o1, Phieuxuat o2) {
						return o2.getMa().compareTo(o1.getMa());
					}
				});
				Phieuxuat phieunhap = phieuNhaps.get(0); 
				String str = phieunhap.getMa().substring(2, phieunhap.getMa().length());
				int index = Integer.parseInt(str.trim()) + 1;
				if(index/100 > 0){
					return "PX0000" + index;
				}else if(index / 10 > 0){
					return "PX00000" + index;
				}else{
					return "PX000000" + index;
				}
			}
		} catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return "PX0000001";
	}
	
	public ArrayList<Integer> getPhieuXuatIdListByDate(int khoId, Date dateFrom, Date dateTo){
		ArrayList<Integer> idList  = new ArrayList<>();
		try {
			session = HibernateFactory.getSessionFactory().openSession();
			String hql = "from "+Phieuxuat.class.getName()+" where activity = true and khoid = :khoid and (ngaylap BETWEEN :beginDay AND :enđDay)";
			Query query = session.createQuery(hql);
			query.setParameter("khoid", khoId);
			query.setDate("beginDay", dateFrom);
			query.setDate("enđDay", dateTo);
			List<Phieuxuat> ds = query.list();
			for(Phieuxuat phieuxuat : ds){
				idList.add(phieuxuat.getId());
			}
		} catch (HibernateException e) {
			handleException(e);
			logger.error("error in findFirst:  \n" + e.getMessage());
		} finally {
			HibernateFactory.close(session);
		}
		return idList;
	}
}
