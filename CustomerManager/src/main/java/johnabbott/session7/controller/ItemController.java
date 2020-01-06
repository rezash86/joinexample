package johnabbott.session7.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import johnabbott.session7.model.Cart;
import johnabbott.session7.model.Item;
import johnabbott.session7.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	
	@RequestMapping(value = "/save_cart", method = RequestMethod.GET)
	public String saveCart() {
		Cart cart = new Cart();
		Item item1 = new Item("book");
		Item item2 = new Item("bike");
		Set<Item> items = new HashSet<Item>();
		items.add(item1);
		items.add(item2);
		cart.setItems(items);
		service.saveCart(cart);
		return "redirect:/customers/customer";
	}
}
