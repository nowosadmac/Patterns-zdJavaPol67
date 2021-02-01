package edu.grcy.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements Cloneable{
	private List<String> shoppingList;

	public ShoppingList(){
		shoppingList = new ArrayList<>();
	}

	public ShoppingList(List<String> list){
		this.shoppingList=list;
	}

	public void loadData(){
		shoppingList.add("ser");
		shoppingList.add("pomidory");
		shoppingList.add("chleb");
	}

	public List<String> getShoppingList() {
		return shoppingList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		List<String> temp = new ArrayList<>();
		for(String s : this.getShoppingList()){
			temp.add(s);
		}
		return new ShoppingList(temp);
	}
}

