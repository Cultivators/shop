package cn.cultivator.shop.action;


import cn.cultivator.shop.service.impl.CatagoryServiceImpl;

public class TestAction {
	private CatagoryServiceImpl catagoryServiceImpl = null;
	public void setCatagoryServiceImpl(CatagoryServiceImpl catagoryServiceImpl) {
		this.catagoryServiceImpl = catagoryServiceImpl;
	}
	public String testssh(){
		System.out.println(catagoryServiceImpl);
		return "success";
	}
}
