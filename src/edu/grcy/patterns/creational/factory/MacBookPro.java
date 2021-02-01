package edu.grcy.patterns.creational.factory;

public class MacBookPro extends MacBook {

	private String name;
	private String par1;
	private int par2;

	public MacBookPro(String name, String par1, int par2) {
		this.name = name;
		this.par1 = par1;
		this.par2 = par2;
	}

	@Override
	public String getMemory() {
		return name;
	}

	@Override
	public String getDisk() {
		return par1;
	}

	@Override
	public int getScreenSize() {
		return par2;
	}
}
