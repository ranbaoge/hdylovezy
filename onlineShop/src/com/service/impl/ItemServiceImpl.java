package com.service.impl;

import java.util.List;

import com.dao.ItemDao;
import com.dao.impl.ItemDaoImpl;
import com.entity.Item;
import com.entity.Orders;
import com.service.ItemService;

public class ItemServiceImpl implements ItemService{
	private ItemDao itemDao=new ItemDaoImpl();
	
	@Override
	public int saveItem(Item item) {
		
		return itemDao.saveItem(item);
	}

	@Override
	public List<Item> queryByPage(int page, int pageSize) {
		
		return itemDao.queryByPage(page, pageSize);
	}

	@Override
	public int count() {
		
		return itemDao.count();
	}

	@Override
	public int saveOrders(Orders orders) {
		// TODO Auto-generated method stub
		return itemDao.saveOrders(orders);
	}

	@Override
	public List<Orders> queryByOrder(int page, int pageSize) {
		// TODO Auto-generated method stub
		return itemDao.queryByOrder(page, pageSize);
	}

	@Override
	public int countOrder() {
		// TODO Auto-generated method stub
		return itemDao.countOrder();
	}

	@Override
	public Item queryByIn(int id) {
		// TODO Auto-generated method stub
		return itemDao.queryByIn(id);
	}

}
