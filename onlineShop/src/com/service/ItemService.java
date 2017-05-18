package com.service;

import java.util.List;

import com.entity.Item;
import com.entity.Orders;

public interface ItemService {
	/**
	 * 添加订单
	 * @param item
	 * @return
	 */
	int saveItem(Item item);
	
	/**
	 * 分页查询订单
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Item> queryByPage(int page,int pageSize);
	
	/**
	 * 查询订单总记录数
	 * @return
	 */
	int count();
	
	/**
	 * 保存订单信息
	 * @param orders
	 * @return
	 */
	int saveOrders(Orders orders);
	
	/**
	 * 分页查询订单信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Orders> queryByOrder(int page,int pageSize);
	/**
	 * 查询订单信息的总记录数
	 * @return
	 */
	int countOrder();
	
	/**
	 * 将添加到购物车的信息查询出来
	 * @param idList
	 * @return
	 */
	Item queryByIn(int id);
}
