package com.rushwash.admin.app.dashboard.vo;

import java.util.Map;

public class DashboardVo {
	
	private Map<String, String> planInfoCount;
	private Map<String, String> itemCategoryCount;
	private Map<String, String> orderStatusCount;
	public Map<String, String> getPlanInfoCount() {
		return planInfoCount;
	}
	public void setPlanInfoCount(Map<String, String> planInfoCount) {
		this.planInfoCount = planInfoCount;
	}
	public Map<String, String> getItemCategoryCount() {
		return itemCategoryCount;
	}
	public void setItemCategoryCount(Map<String, String> itemCategoryCount) {
		this.itemCategoryCount = itemCategoryCount;
	}
	public Map<String, String> getOrderStatusCount() {
		return orderStatusCount;
	}
	public void setOrderStatusCount(Map<String, String> orderStatusCount) {
		this.orderStatusCount = orderStatusCount;
	}
	@Override
	public String toString() {
		return "DashboardVo [planInfoCount=" + planInfoCount + ", itemCategoryCount=" + itemCategoryCount
				+ ", orderStatusCount=" + orderStatusCount + "]";
	}
	
	
	
	
	

}