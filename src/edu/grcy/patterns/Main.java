package edu.grcy.patterns;

import edu.grcy.patterns.behavioral.chainOfResponsibility.*;
import edu.grcy.patterns.behavioral.command.CreateFileOperation;
import edu.grcy.patterns.behavioral.command.FileOperationPerformer;
import edu.grcy.patterns.behavioral.command.MyFile;
import edu.grcy.patterns.behavioral.command.UpdateFileOperation;
import edu.grcy.patterns.behavioral.iterator.MyIterator;
import edu.grcy.patterns.behavioral.iterator.Payment;
import edu.grcy.patterns.behavioral.iterator.PaymentList;
import edu.grcy.patterns.behavioral.mediator.AllegroCustomer;
import edu.grcy.patterns.behavioral.mediator.AllegroMediator;
import edu.grcy.patterns.behavioral.mediator.Customer;
import edu.grcy.patterns.behavioral.mediator.Mediator;
import edu.grcy.patterns.behavioral.memento.GameState;
import edu.grcy.patterns.behavioral.memento.GameStateMemento;
import edu.grcy.patterns.behavioral.state.Flight;
import edu.grcy.patterns.behavioral.strategy.CarStrategy;
import edu.grcy.patterns.behavioral.strategy.Travel;
import edu.grcy.patterns.behavioral.strategy.WalkStrategy;
import edu.grcy.patterns.behavioral.visitor.*;
import edu.grcy.patterns.creational.abstractFactory.Object1Factory;
import edu.grcy.patterns.creational.abstractFactory.ObjectFactory;
import edu.grcy.patterns.creational.prototype.ShoppingList;
import edu.grcy.patterns.creational.singleton.EagerSingleton;
import edu.grcy.patterns.creational.singleton.LazySingleton;
import edu.grcy.patterns.structural.decorator.BasicItem;
import edu.grcy.patterns.structural.decorator.Item;
import edu.grcy.patterns.structural.decorator.SpecialItem1;
import edu.grcy.patterns.structural.decorator.SpecialItem2;
import edu.grcy.patterns.structural.flyweight.FordMustang;
import edu.grcy.patterns.structural.proxy.CompanyEmployees;
import edu.grcy.patterns.structural.proxy.CompanyInternetNetwork;
import edu.grcy.patterns.structural.proxy.ProxyCompanyInternetAccess;

import java.util.Arrays;
import java.util.List;

//import grcy.sda.patterns.creational.factory.ObjectFactory;
//import grcy.sda.patterns.creational.factory.ObjectType;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {


		//Shape cir = new Circle();

//		Drawing drawing = new Drawing();
		//drawing.add(cir);
//		drawing.draw("gwiazdki");
		//drawing.clear();
		//drawing.add(tri);
		//drawing.add(cir);
		//drawing.draw("Green");
//		testDecorator();
//		try {
//			testPrototype();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}
//		testProxy();
//		testFlyweight();
//		testChain();
//		testCommand();
//		testIterator();
//		testMediator();
		testMemento();
//		testState();
//		testStrategy();

	}
	//EagerSingletonTest();

	//LazySingletonTest();

	//testFactory();

	//testBuilder();

	//testDecorator();
	private static void testDecorator() {
		Item sportsCar = new SpecialItem1(new BasicItem(), false);
		sportsCar.assemble();
		System.out.println("\n*****");

		Item sportsLuxuryCar = new SpecialItem1(new SpecialItem2(new BasicItem()), false);
		sportsLuxuryCar.assemble();
		System.out.println("\n*****");

		Item sportsLuxuryCar2 = new SpecialItem1(new SpecialItem2(new BasicItem()), true);
		sportsLuxuryCar2.assemble();
	}

	private static void EagerSingletonTest() {
		EagerSingleton.getInstance();

		EagerSingleton.getInstance().toString();

	}

	private static void LazySingletonTest() {
		LazySingleton.getInstance();

		LazySingleton.getInstance();
	}
/*
	private static void testFactory(){
		ObjectType object1 = ObjectFactory.getObject("type1", "Object1", "Value1", 1);

		System.out.println(object1.toString());
	}

*/
	private static void testAbstractFactory(){
		edu.grcy.patterns.creational.abstractFactory.ObjectType
				object1 =  ObjectFactory.getObject(
						new Object1Factory("Object1", "Value1", 1)) ;

		edu.grcy.patterns.creational.abstractFactory.ObjectType object2 =  ObjectFactory.getObject(new Object1Factory("Object2", "Value2", 2)) ;

		System.out.println(object1.toString());
		System.out.println(object2.toString());
	}

	private static void testBuilder(){

		edu.grcy.patterns.creational.builder.Object object =
				new edu.grcy.patterns.creational.builder.Object.ObjectBuilder
						("Object1", "Value1", 1).setPar3(true).build();
		System.out.println(object.getName());
	}

	private static void testPrototype() throws CloneNotSupportedException{
		ShoppingList shoppingList = new ShoppingList();
		shoppingList.loadData();

		//Use the clone method to get the Employee object
		ShoppingList shoppingListNew = (ShoppingList) shoppingList.clone();
		ShoppingList shoppingListNew1 = (ShoppingList) shoppingList.clone();
		List<String> list = shoppingListNew.getShoppingList();
		list.add("kiełbasa");
		List<String> list1 = shoppingListNew1.getShoppingList();
		list1.remove("ser");

		System.out.println("shoppingList List: "+shoppingList.getShoppingList());
		System.out.println("shoppingList new List: "+list);
		System.out.println("shoppingList new2 List: "+list1);
	}

	private static void testProxy() {
		CompanyEmployees employees = new CompanyEmployees();
		List<String> employeeList = Arrays.asList("Anna", "Maria", "Jan", "Waldemar") ;
		employees.setUsers(employeeList);
		CompanyInternetNetwork internetNetwork = new ProxyCompanyInternetAccess();
		internetNetwork.getAccess("Anna");
		internetNetwork.getAccess("Robert");
		

	}

	private static void testFlyweight() {
		FordMustang fordMustang1 = new FordMustang("midnight sky", "winter", "Sony1");
		FordMustang fordMustang2 = new FordMustang("black panther", "sport", "No radio");
		FordMustang fordMustang3 = new FordMustang("midnight sky", "winter", "No radio");

	}

	private static void testChain() {
		Employees employees = new Employees();
		employees.addEmployee("Jan Kowalski", 10);
		employees.addEmployee("Marian Nowak", 5);
		employees.addEmployee("Maria Rajska", 12);

		AccessCheck accessCheck = new CompanyInsiderCheck();
		accessCheck.addChainElement(new EmployeeSeniorityCheck());


		XCompany company = new XCompany();
		company.setCheck(accessCheck);

		company.enterRoom("Adam Baj");
		System.out.println("++++++++++++++++++");
		company.enterRoom("Marian Nowak");
		System.out.println("++++++++++++++++++");
		company.enterRoom("Maria Rajska");
	}

	private static void testCommand() {
		MyFile myFile = new MyFile("file1.txt");
		FileOperationPerformer fileOperationPerformer
				= new FileOperationPerformer();

		fileOperationPerformer.executeOperation(
				new CreateFileOperation(myFile), "pierwszy wpis");
		fileOperationPerformer.executeOperation(
				new UpdateFileOperation(myFile), " dodatek");

		System.out.println(myFile.getContent());
	}

	private static void testIterator() {
		Payment[] payments = {new Payment("Woda"), new Payment("Prąd"), new Payment("Gaz"), new Payment("Przedszkole")};
		PaymentList paymentList = new PaymentList(payments);
		MyIterator<Payment> paymentIterator = paymentList.iterator();
		System.out.println("Iterator demo:");
		while(paymentIterator.hasNext()) {
			Payment currentPayment = paymentIterator.next();
			System.out.println(currentPayment.getName());
		}
	}

	private static void testMediator() {
		Mediator mediator = new AllegroMediator();
		Customer customer1 = new AllegroCustomer(mediator, "Jasiu");
		Customer customer2 = new AllegroCustomer(mediator, "Krzysiu");
		Customer customer3 = new AllegroCustomer(mediator, "Maja");

		mediator.addBuyer(customer1);
		mediator.addBuyer(customer2);
		mediator.addBuyer(customer3);

		customer1.bid(300);
		customer2.bid(500);
		customer3.bid(400);
		System.out.println("===========MEDIATOR===========");
		System.out.println("Start auction");
		mediator.findHighestBidder();

		customer2.cancelTheBid();
		mediator.findHighestBidder();
	}

	private static void testMemento() {
		System.out.println("========MEMENTO========");
		GameState gameState = new GameState(1, "Etap 1");
		System.out.println(gameState);
		GameStateMemento memento1 = gameState.saveGame();
		System.out.println(gameState);
		gameState.changeGameState(2, "Etap 2");
		System.out.println(gameState);
		gameState.restore(memento1);
		System.out.println(gameState);

	}

	private static void testVisitor(){
		ItemElement[] items = new ItemElement[]{
				new Item1(20, 5, ""),
				new Item2(10, 2, "Banana"),
				new Item2(5, 5, "Apple")};

		int total = calculatePrice(items);
		System.out.println("Total Cost = "+total);
	}

	private static void testState() {
		System.out.println("=============STATE============");
		Flight flight = new Flight();
		flight.update();
		flight.update();
		flight.update();
		flight.update();
		flight.update();
		flight.update();
		flight.update();
		flight.update();
		flight.update();

	}

	private static void testStrategy() {
		System.out.println("=======STRATEGY======");
		Travel travel1 = new Travel("Rzeszów", "Kraków");
		travel1.setTravelPlan(new WalkStrategy(true));

		travel1.setTravelPlan(new CarStrategy(true, false));
		travel1.setTravelPlan(new CarStrategy(true, true));
	}

	private static int calculatePrice(ItemElement[] items) {
		ItemVisitor visitor = new ItemVisitorImpl();
		int sum=0;
		for(ItemElement item : items){
			sum = sum + item.accept(visitor);
		}
		return sum;
	}
}
