package sellhancommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import sellhancommerce.dao.StockDAO;
import sellhancommerce.model.Stock;

@Service
public class StockService 
{
	@Autowired
	private StockDAO stockDAO;
	
	public void save(Stock stock) {
		stockDAO.save(stock);
	}
	
	public Stock findByStockId(int stockId) {
		return stockDAO.findByStockId(stockId);
	}
	
	public void delete(Stock theStock) {
		stockDAO.delete(theStock);
	}
	

}
