package sellhancommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sellhancommerce.model.Cart;
import sellhancommerce.model.Product;
import sellhancommerce.service.BuyerService;
import sellhancommerce.service.CartService;
import sellhancommerce.service.ProductService;
import sellhancommerce.service.SellerService;

@Controller
@RequestMapping("/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public String getCartProducts(Model model)
	{
		Cart theCart = cartService.getCart();
		model.addAttribute("theCart", theCart);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "cart";
	}
	
	@GetMapping("/add/{productId}")
	public String addProductToCart(@PathVariable("productId") int productId)
	{
		Product theProduct = productService.findByProductId(productId);
		Cart theCart = cartService.getCart();
		theCart.addProductToCart(theProduct);
		cartService.save(theCart);
		return "redirect:/cart";
	}
	
	@GetMapping("/delete/{productId}")
	public String deleteProductFromCart(@PathVariable("productId") int productId)
	{
		Product theProduct = productService.findByProductId(productId);
		Cart theCart = cartService.getCart();
		theCart.removeProductFromCart(theProduct);
		cartService.save(theCart);
		return "redirect:/cart";
	}
}
