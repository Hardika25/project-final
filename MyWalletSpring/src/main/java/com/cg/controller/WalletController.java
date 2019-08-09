package com.cg.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Mywallet;
import com.cg.service.AccountService;

@RestController
@RequestMapping("/MyWallet")
public class WalletController {
	@Autowired AccountService service;
	
	
	@PostMapping(value="/addAccount",consumes={"application/json"})
	public String add(@RequestBody Mywallet account) {
		return service.addAccount(account);
	}
	
	
	@DeleteMapping(value="/delete/{mob}")
	public String delete(@PathVariable Long mob) {
		service.delete(mob);
		return "Account is  Deleted";
	}
	
	
	
	@PutMapping(value="/update",consumes= {"application/json"})
	public String update(@RequestBody Mywallet account) {
		service.update(account);
		return "Account has been Updated";
	}
	
	@GetMapping(produces= {"application/json"})
	public List<Mywallet> getall() {
		return service.getall();
	}
	
	@PutMapping(value="/transfer/{mob1}/{mob2}/{amount}")
	public String transfer(@PathVariable Long mob1, @PathVariable Long mob2, @PathVariable double amount) {
		service.transfer(mob1, mob2, amount);
		return "Amount  is Transfered";
	}
	
	@PutMapping(value="/withdraw/{mob1}/{amount}")
	public String withdraw(@PathVariable Long mob1, @PathVariable double amount) {
		service.withdraw(mob1, amount);
		return "Amount has been withdrawn";
	}
	
	@PutMapping(value="/deposit/{mob1}/{amount}")
	public String deposit(@PathVariable Long mob1, @PathVariable double amount) {
		service.deposit(mob1, amount);
		return "Amount has been  Deposited";
	}
}
