package com.dao;

import java.util.List;

import com.entity.Item;
import com.entity.Orders;

public interface ItemDao {
	/**
	 * 添加购物车信息
	 * @param item
	 * @return
	 */
	int saveItem(Item item);
	
	/**
	 * 分页查询购物车信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Item> queryByPage(int page,int pageSize);
	
	/**
	 * 查询购物车总记录数
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
