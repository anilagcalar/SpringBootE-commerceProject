package sellhancommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import sellhancommerce.dao.OrderDAO;
import sellhancommerce.model.Orders;

@Service
public class OrderService 
{
	@Autowired
	private OrderDAO orderDAO;
	
	public void save(Orders theOrder)
	{
		orderDAO.save(theOrder);
	}
}
