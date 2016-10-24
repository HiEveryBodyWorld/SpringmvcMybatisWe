package com.iot.ssm.firstssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.iot.ssm.firstssm.mapper.ItemsMapper;
import com.iot.ssm.firstssm.mapper.ItemsMapperCustom;
import com.iot.ssm.firstssm.po.Items;
import com.iot.ssm.firstssm.po.ItemsCustom;
import com.iot.ssm.firstssm.po.ItemsQueryVo;
import com.iot.ssm.firstssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	public void updateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);

	}

}
