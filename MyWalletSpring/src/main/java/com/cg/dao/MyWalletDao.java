package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Mywallet;


public interface MyWalletDao extends JpaRepository<Mywallet,Long>{
//	To perform certain applications such as: public List<Product> getall();
//												public String addProduct(Product p);
}

