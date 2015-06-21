package cn.cultivator.shop.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import cn.cultivator.shop.pojo.Goods;
import cn.cultivator.shop.service.GoodsService;

public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService{
	//通过商品的类别查询商品
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Goods> queryGoodsByCid(final int cid) {
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createQuery("FROM Goods g WHERE g.gcommend = true AND g.gopen=true AND g.category.cid=:cid ORDER BY g.gdate DESC")
						.setInteger("cid", cid)
						.setFirstResult(0)
						.setMaxResults(4)
						.list();
			}
		});
	}
	//通过商品名字查询商品
	@SuppressWarnings("unchecked")
	public List<Goods> queryGoodsByName(String gname) {
		return hibernateTemplate.findByNamedParam("FROM Goods g WHERE g.gname LIKE :gname", "gname", "%" + gname + "%");
	}

}
