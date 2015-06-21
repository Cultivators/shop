package cn.cultivator.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.cultivator.shop.service.AccountService;
import cn.cultivator.shop.service.CategoryService;
import cn.cultivator.shop.service.ForderService;
import cn.cultivator.shop.service.GoodsService;
import cn.cultivator.shop.service.SorderService;
import cn.cultivator.shop.service.UsersService;
import cn.cultivator.shop.util.FileUploadUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,
RequestAware,SessionAware,ApplicationAware  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected T model = null;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseAction() {
		super();
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			new RuntimeException();
		} 
	}
	//将application session request 封装
	protected Map<String, Object> application = null;
	protected Map<String, Object> session = null;
	protected Map<String, Object> request = null;
	
	protected AccountService accountService = null;
	protected CategoryService categoryService = null;
	protected FileUploadUtil fileUploadUtil = null;
	protected GoodsService goodsService = null;
	protected ForderService forderService = null;
	protected SorderService sorderService = null ;
	protected UsersService usersService = null;
	
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	protected Map<String, Object> jsonMap = new HashMap<String, Object>();
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}
	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public void setFileUploadUtil(FileUploadUtil fileUploadUtil) {
		this.fileUploadUtil = fileUploadUtil;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public T getModel() {
		return model;
	}

}
