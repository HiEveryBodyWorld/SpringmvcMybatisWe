package com.iot.ssm.firstssm.po;

import java.util.List;

public class UserOrders  extends User {
	
	
	private List<Orders> userOrders;

	public List<Orders> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<Orders> userOrders) {
		this.userOrders = userOrders;
	}
	

}
