package com.Demo.MapStruct.model;

import javax.persistence.Column;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(nullable=false)
	private String Name;
	@Column
	private String Description;
	@Column(nullable=false)
	private int Quantity;
	@Column(nullable=false)
	private long Price;
	@Column(nullable=false)
	private String Itemid;
	//private List<Item> Items;
	
	

}
