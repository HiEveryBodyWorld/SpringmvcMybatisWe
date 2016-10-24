package com.iot.ssm.firstssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iot.ssm.firstssm.po.ItemsCustom;
import com.iot.ssm.firstssm.po.ItemsQueryVo;
import com.iot.ssm.firstssm.service.ItemsService;

@Controller
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// 商品查询列表
	@RequestMapping("/queryItem")
	// 实现 对queryItems方法和url进行映射，一个方法对应一个url
	// 一般建议将url和方法写成一样
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {

		// //创建包装对象，设置查询条件
		// ItemsQueryVo userQueryVo = new ItemsQueryVo();
		// UserCustom userCustom = new UserCustom(null);
		// //由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
		// userCustom.setSex("1");
		// userCustom.setUsername("张三");
		// userQueryVo.setUserCustom(userCustom);
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute方法,在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp的路径前缀和后缀，修改为items/itemsList
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 下边的路径配置就可以不在程序中指定jsp路径的前缀和后缀
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	// 商品信息修改页面显示
//	@RequestMapping("/editItems")
	// 限制http请求方法，可以post和get
	 @RequestMapping(value="/editItems",method={RequestMethod.POST,
	 RequestMethod.GET})
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer items_id) throws Exception {
		
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		  //判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户商品信息不存在
        //if(itemsCustom == null){
			//throw new CustomException("修改的商品信息不存在!");
        //}

        //通过形参中的model将model数据传到页面
		// 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        //将商品信息放到model
//        modelAndView.addObject("itemsCustom", itemsCustom);
//
//        //商品修改页面
////        modelAndView.setViewName("items/editItems");
////
////        return modelAndView;
        
        model.addAttribute("items", itemsCustom);

        return "items/editItems";
		
	}
	public ModelAndView editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception{
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
        itemsService.updateItems(id, itemsCustom);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //返回一个成功页面
        modelAndView.setViewName("success");
        return modelAndView;
	}
	
	

}
