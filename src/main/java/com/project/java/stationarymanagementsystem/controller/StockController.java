package com.project.java.stationarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.java.stationarymanagementsystem.entities.Item;
import com.project.java.stationarymanagementsystem.entities.Stock;
import com.project.java.stationarymanagementsystem.service.ItemService;
import com.project.java.stationarymanagementsystem.service.StockService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/stock/{id}")
	public String getStockById(@PathVariable int id, ModelMap stockModel) {
		Stock stock = stockService.getStockById(id);
		stockModel.addAttribute("stock", stock);
		return "stock";
	}

	@GetMapping("/stocks")
	public String getStocks(ModelMap stockModel) {
		List<Stock> stocks = stockService.getStocks();
		stockModel.addAttribute("stocks", stocks);
		return "stocks";
	}

	@GetMapping("addStock")
	public String addPage() {
		return "addStock";
	}

	@PostMapping("/add/stock")
	public String addStock(@RequestParam(value="itemid") String itemid,@RequestParam(value="quantityavailable") String quantityavailable, ModelMap itemModel) {
		Stock stock = new Stock();
		//itemService.getItemById(Integer.parseInt(itemid));
		stock.setItemid(itemService.getItemById(Integer.parseInt(itemid)));
		stock.setQuantityavailable(Integer.parseInt(quantityavailable));
		stockService.addStock(stock);
		itemModel.addAttribute("msg", "Item added successfully");
		List<Stock> stocks = stockService.getStocks();
		itemModel.addAttribute("stocks", stocks);
		return "redirect:/stock/stocks";
	}

	@GetMapping("update/stock/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap stockModel) {
		stockModel.addAttribute("id", id);
		Stock stock = stockService.getStockById(id);
		stockModel.addAttribute("stock", stock);
		return "updateStock";
	}

	@PostMapping("/update/stock")
	public String updateStock(@RequestParam(value="stockid") String stockid, @RequestParam(value="itemid") String itemid, @RequestParam("quantityavailable") String quantityavailable, ModelMap stockModel) {
		Stock stock = new Stock();
		//itemService.getItemById(Integer.parseInt(itemid));
		stock.setStockid(Integer.parseInt(stockid));
		stock.setItemid(itemService.getItemById(Integer.parseInt(itemid)));
		stock.setQuantityavailable(Integer.parseInt(quantityavailable));
		stockService.updateStock(stock);
		List<Stock> stocks = stockService.getStocks();
		stockModel.addAttribute("stocks", stocks);
		stockModel.addAttribute("id", itemid);
		stockModel.addAttribute("msg", "Stock updated successfully");
		return "redirect:/stock/stocks";
	}

	@GetMapping("/delete/stock/{id}")
	public String deleteStock(@PathVariable int id, ModelMap itemModel) {
		stockService.deleteStock(id);
		List<Stock> stocks = stockService.getStocks();
		itemModel.addAttribute("stocks", stocks);
		itemModel.addAttribute("msg", "Stock deleted successfully");
		return "redirect:/stock/stocks";
	}
	
}
