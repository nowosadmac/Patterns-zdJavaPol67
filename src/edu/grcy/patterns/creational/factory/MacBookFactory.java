package edu.grcy.patterns.creational.factory;

public class MacBookFactory {

	public static MacBook getObject(String type, String name, String value1, int value2){
		if("type1".equalsIgnoreCase(type))
			return new MacBookAir(name, value1, value2);
		else if("type2".equalsIgnoreCase(type))
			return new MacBookPro(name, value1, value2);

		return null;
	}
}

