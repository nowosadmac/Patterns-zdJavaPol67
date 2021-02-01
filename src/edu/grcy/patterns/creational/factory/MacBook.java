package edu.grcy.patterns.creational.factory;

public abstract class MacBook {

	enum fuelType {GAS, ON, PB}

	public abstract String getMemory();
	public abstract String getDisk();
	public abstract int getScreenSize();

	@Override
	public String toString(){
		return "Name= "+this.getMemory()+", Par1="+this.getDisk()+", Par2="+this.getScreenSize();
	}
}
