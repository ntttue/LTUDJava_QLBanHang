package com.qlbh.render.combobox;

import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Nhacungcap;

import javafx.scene.control.ListCell;

public class TenKhachHangListCell extends ListCell<Khachhang>{

	@Override
	protected void updateItem(Khachhang arg0, boolean arg1) {
		// TODO Auto-generated method stub
		super.updateItem(arg0, arg1);
		if(arg0 != null){
			setText(arg0.getTen());
		}
	}
	
}
