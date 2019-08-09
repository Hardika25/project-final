package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.MyWalletDao;
import com.cg.entity.Mywallet;
import com.cg.exception.Exception;

@Service                                                        
@Transactional
public class AccountServiceImpl implements AccountService{
@Autowired MyWalletDao dao;


@Transactional(readOnly=true)
public List<Mywallet> getall() {
	if(dao.findAll().isEmpty()) {
		throw new Exception("No Account Exists");
	}
	return dao.findAll();
}


@Transactional
public String addAccount(Mywallet p) {
	if(dao.existsById(p.getMobile())) {
		throw new Exception("Account Already Present");
	}
	else {
		dao.save(p);
		return "Account Added";
	}
}

@Transactional
public String update(Mywallet p) {
	Long mob=p.getMobile();
	this.delete(mob);
	this.addAccount(p);
	return "Account Updated";
}


@Transactional
public String delete(long mob) {
dao.deleteById(mob);
	 return "Account Deleted";	
}
	/*@Transactional
	public String transfer(long mob1,long mob2,double amt) {
		List<Mywallet> transfer=dao.findById(mob1);
		
		return "Successfully Transfered";
	}*/


@Transactional
public String transfer(long mob1, long mob2, double amt) {
	// TODO Auto-generated method stub
	Optional<Mywallet> _wallet=dao.findById(mob1);
	if(_wallet.isPresent()) {
		Mywallet wallet=_wallet.get();
		wallet.setBalance(wallet.getBalance()-amt);
		dao.save(wallet);
	}
	Optional<Mywallet> _wallet1=dao.findById(mob2);
	if(_wallet1.isPresent()) {
		Mywallet wallet=_wallet1.get();
		wallet.setBalance(wallet.getBalance()+amt);
		dao.save(wallet);
	}
	
	
	return "Amount transfered";
}


@Transactional
public String withdraw(long mob1, double amt) {
	// TODO Auto-generated method stub
	Optional<Mywallet> _wallet=dao.findById(mob1);
	if(_wallet.isPresent()) {
		Mywallet wallet=_wallet.get();
	//	if(wallet.getBalance()-amt<1000)
		//	System.out.println("The amount after deposit is getting below 1000 Please enter amount less than"
		//			+ "");
		wallet.setBalance(wallet.getBalance()-amt);
		dao.save(wallet);
	}
	return "Amount Withdraw";
}


@Transactional
public String deposit(long mob1, double amt) {
	// TODO Auto-generated method stub
	Optional<Mywallet> _wallet=dao.findById(mob1);
	if(_wallet.isPresent()) {
		Mywallet wallet=_wallet.get();
		wallet.setBalance(wallet.getBalance()+amt);
		dao.save(wallet);
	}
	return "Amount Deposited";
	}
	
	
}
