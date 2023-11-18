package com.project.java.stationarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.java.stationarymanagementsystem.entities.Item;
import com.project.java.stationarymanagementsystem.service.ItemService;

@Controller
@RequestMapping("/item/")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item/{id}")
	public String getItemById(@PathVariable int id, ModelMap itemModel) {
		Item item = itemService.getItemById(id);
		itemModel.addAttribute("item", item);
		return "item";
	}

	@GetMapping("/items")
	public String getItems(ModelMap itemModel) {
		List<Item> items = itemService.getItems();
		itemModel.addAttribute("items", items);
		return "items";
	}

	@GetMapping("addItem")
	public String addPage() {
		return "add";
	}

	@PostMapping("/add/item")
	public String addItem(@RequestParam(value="name") String name,@RequestParam("manufacturer") String manufacturer, @RequestParam("price") Integer price,ModelMap itemModel) {
		Item item = new Item();
		item.setItemname(name);
		item.setManufacturer(manufacturer);
		item.setPrice(price);
		itemService.addItem(item);
		itemModel.addAttribute("msg", "Item added successfully");
		List<Item> items = itemService.getItems();
		itemModel.addAttribute("items", items);
		return "redirect:/item/items";
	}

	@GetMapping("update/item/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap itemModel) {
		itemModel.addAttribute("id", id);
		Item item = itemService.getItemById(id);
		itemModel.addAttribute("item", item);
		return "update";
	}

	@PostMapping("/update/item")
	public String updateItem(@RequestParam("itemid") int id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "manufacturer", required = true) String manufacturer, @RequestParam("price") Integer price,ModelMap itemModel) {
		Item item = new Item();
		item.setItemid(id);
		item.setItemname(name);
		item.setManufacturer(manufacturer);
		item.setPrice(price);
		itemService.updateItem(item);
		List<Item> items = itemService.getItems();
		itemModel.addAttribute("items", items);
		itemModel.addAttribute("id", id);
		itemModel.addAttribute("msg", "Item updated successfully");
		return "redirect:/items";
	}

	@GetMapping("/delete/item/{id}")
	public String deleteItem(@PathVariable int id, ModelMap itemModel) {
		itemService.deleteItem(id);
		List<Item> items = itemService.getItems();
		itemModel.addAttribute("items", items);
		itemModel.addAttribute("msg", "Item deleted successfully");
		return "redirect:/items";
	}
}
