package com.lithan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
	@Autowired
	public StoreService service;
	
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String addStore(Model model) {
//		this will be used in the form
		model.addAttribute("store",new Store());
		return "addStore";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveStore(Store store) {
//		using service method to add the data
		service.addStore(store);
		
//		change the view to store list
		return "redirect:storeList";
	}
	
	@RequestMapping(value="/storeList", method=RequestMethod.GET)
	public String storeList(Model model) {
//		get all the store and save the to the variable, so it can added to new attribute
		List<Store> allStores = service.getAllStore();
//		create an attribute so the view can use it
		model.addAttribute("stores", allStores);
		return"storeList";
	}
	@GetMapping("/home")
	public String homePage() {
		return "redirect:/";
	}
}
