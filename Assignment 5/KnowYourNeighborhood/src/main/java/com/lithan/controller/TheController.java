package com.lithan.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.entity.Stores;
import com.lithan.exception.StoreNotFoundException;
import com.lithan.service.StoreService;


@Controller
public class TheController {

	@Autowired
	public StoreService service;
	
	
	@GetMapping("/user")
    public String getUser(Authentication authentication) {
        String username = authentication.getName();
        System.out.println("Hello, " + username+authentication.getAuthorities());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "Hello, " + username+authentication.getAuthorities();
    }
	
	@GetMapping("/")
	public String home(Model model,Authentication authentication) {
		String page= "";
		List<Stores> stores = service.getAllStore();
		model.addAttribute("stores", stores);
		if(authentication.getAuthorities().toString().equals("[ADD_STORE]")) {
			page="storeConfig";
		}else {
			page="storeList";
		}
		return page;
	}

	// Add Store
	@GetMapping("/addStore")
	public String addStore(@ModelAttribute("store")Stores store) {
		return "storeForm";
	}

	@PostMapping("/save")
	public String saveAddStore(@ModelAttribute("store") Stores store) {
		service.save(store);;
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateStore(Model model,@RequestParam(name="id")int id) {
//		code below will get the store based on id and can be accessed in the form
		model.addAttribute("store",service.getStore(id));
		return "storeForm";
	}

	@GetMapping("/search")
	public String search(@RequestParam("search") String search,Model model) throws StoreNotFoundException {
		List<Stores> store = service.search(search);
		System.out.println(store);
		if(store.isEmpty()) {
			throw new StoreNotFoundException("No Store with that name");
		}
		model.addAttribute("stores",store);
		return "search";
	}
	@GetMapping("/delete")
	public String saveEditStore(@RequestParam("id") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
