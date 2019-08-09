package com.cg.service;

import java.util.List;

import com.cg.entity.Mywallet;

public interface AccountService {
	public List<Mywallet> getall();
	public String addAccount(Mywallet p);
	public String update(Mywallet p);
	public String delete(long id);
	public String transfer(long mob1,long mob2,double amt) ;
	public String withdraw(long mob1,double amt);
	public String deposit(long mob1,double amt);
}
