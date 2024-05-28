package com.Demo.MapStruct.dto;

//import java.util.List;

import javax.persistence.Id;

//import com.Demo.MapStruct.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	
	@Id
	private int Id;
	private String Name;
	private String Description;
	private String Quantity;
	private long Price;
	private String Itemid;
	//private List<Item> ItemsList;

}
