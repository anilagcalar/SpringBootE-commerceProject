package sellhancommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sellhancommerce.model.User;
import sellhancommerce.service.BuyerService;
import sellhancommerce.service.SellerService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/login")
	public String login(Model model)
	{
		User theUser = new User();
		model.addAttribute("theUser", theUser);
		model.addAttribute("isBuyer", buyerService.isBuyer());
		model.addAttribute("isSeller", sellerService.isSeller());
		return "login-form";
	}
}
