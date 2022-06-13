package sellhancommerce.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sellhancommerce.model.Product;
import sellhancommerce.model.Seller;
import sellhancommerce.model.Stock;
import sellhancommerce.service.BuyerService;
import sellhancommerce.service.ProductService;
import sellhancommerce.service.SellerService;
import sellhancommerce.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController 
{
	@Autowired
	private StockService stockService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String getStocks(Model model)
	{
		Seller currentSeller = sellerService.getCurrentSeller();
		List<Stock> stocks = currentSeller.getStocks();
		model.addAttribute("stocks", stocks);
		model.addAttribute("isSeller", sellerService.isSeller());
		model.addAttribute("isBuyer", buyerService.isBuyer());
		return "stock-list";
	}
	
	@PostMapping("/save/{productId}")
	public String addStock(@ModelAttribute("theStock") Stock theStock, @PathVariable("productId") int productId)
	{
		Product theProduct = productService.findByProductId(productId);
		theStock.setProduct(theProduct);
		Seller currentSeller = sellerService.getCurrentSeller();
		theStock.setSeller(currentSeller);
		stockService.save(theStock);
		return "redirect:/stock/list";
	}
	
	@GetMapping("/delete/{stockId}")
	public String deleteStock(@PathVariable("stockId") int stockId)
	{
		Stock theStock = stockService.findByStockId(stockId);
		stockService.delete(theStock);
		return "redirect:/stock/list";
	}
	

}
