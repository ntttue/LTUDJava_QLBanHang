package com.qlbh.render.combobox;

import com.qlbh.pojo.Nhacungcap;

import javafx.scene.control.ListCell;

public class MaNhaCungCapListCell extends ListCell<Nhacungcap>{

	@Override
	protected void updateItem(Nhacungcap arg0, boolean arg1) {
		// TODO Auto-generated method stub
		super.updateItem(arg0, arg1);
		if(arg0 != null){
			setText(arg0.getMa());
		}
	}
	
}
