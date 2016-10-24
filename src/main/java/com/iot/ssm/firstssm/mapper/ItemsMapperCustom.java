/**
 * 
 */
package com.iot.ssm.firstssm.mapper;

import java.util.List;

import com.iot.ssm.firstssm.po.ItemsCustom;
import com.iot.ssm.firstssm.po.ItemsQueryVo;

/**
 * @author Darren
 *
 */
public interface ItemsMapperCustom {
	
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

}
