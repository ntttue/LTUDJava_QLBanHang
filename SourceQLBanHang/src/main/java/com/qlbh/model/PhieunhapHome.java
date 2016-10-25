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
public class PhieunhapHome extends AbstractDao {
	public Phieunhap save(Phieunhap phieunhap){
		super.save(phieunhap);
		return phieunhap;
	}
	
	public Phieunhap update(Phieunhap phieunhap){
		super.update(phieunhap);
		return phieunhap;
	}
}
