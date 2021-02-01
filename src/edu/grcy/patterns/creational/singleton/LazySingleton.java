package edu.grcy.patterns.creational.singleton;

public class LazySingleton {
private static LazySingleton instance;

	private LazySingleton(){
		System.out.println("Lazy Singleton initialization");
	}

	public static LazySingleton getInstance(){
		if (instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}

}
