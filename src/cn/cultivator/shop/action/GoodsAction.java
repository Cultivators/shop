package cn.cultivator.shop.action;

import cn.cultivator.shop.pojo.Goods;
import cn.cultivator.shop.pojo.GoodsFile;

public class GoodsAction extends BaseAction<Goods>{
	
	private static final long serialVersionUID = 1L;
	
	private GoodsFile goodsFile;
	public GoodsFile getGoodsFile() {
		return goodsFile;
	}
	public void setGoodsFile(GoodsFile goodsFile) {
		this.goodsFile = goodsFile;
	}
	//文件上传（一般现在的企业不会用Struts做文件上传，因为struts2的文件上传是在上传后验证文件的安全性，会导致上传的文件很混乱）
	public String save(){
		String newName = fileUploadUtil.uploadFile(goodsFile.getImage(), goodsFile.getImageFileName());
		model.setGpic(newName);
		goodsService.save(model);
		return "main";
	}
	public String query(){
		//一般是先查询才有删除操作 所以先把删除所要的参数先存进到session中到时候可以直接拿来用
		//一般情况下是不推荐用session存储数据的
		System.out.println(model.getGname());
		session.put("gname",model.getGname());
		request.put("goodsList",goodsService.queryGoodsByName(model.getGname()));
		return "query";
	}
	public String delete(){
		goodsService.delete(model.getGid());
		request.put("goodsList", goodsService.queryGoodsByName((String) session.get("gname")));
		return "query";
	}
	//更新商品
	public String get(){
		request.put("goods", goodsService.get(model.getGid()));
		return "update";
	}
	//查询详细信息
	public String detail(){
		request.put("goods", goodsService.get(model.getGid()));
		return "detail";
	}
	
	public String update(){
		System.out.println("nimei");
		if(goodsFile==null){
			goodsService.update(model);
		}else{
			fileUploadUtil.delete(model.getGpic());
			String newName = fileUploadUtil.uploadFile(goodsFile.getImage(), goodsFile.getImageFileName());
			model.setGpic(newName);
			goodsService.update(model);
		}
		return "query";
	}
}
