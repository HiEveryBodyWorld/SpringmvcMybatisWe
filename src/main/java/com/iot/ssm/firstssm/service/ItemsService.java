package com.iot.ssm.firstssm.service;

import java.util.List;

import com.iot.ssm.firstssm.po.ItemsCustom;
import com.iot.ssm.firstssm.po.ItemsQueryVo;

public interface ItemsService {

	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	ItemsCustom findItemsById(Integer id) throws Exception;
	
	void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
}
