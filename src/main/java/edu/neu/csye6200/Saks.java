package edu.neu.csye6200;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
/**
 * 100 TOTAL POINTS
 * 
 * Saks model simulates 3 customers shopping for Items, 
 * show their TOTAL on itemized receipt, 
 * MUST SORT 3-ways: by Item ID, by Item Price, by Size)
 *  
 * using ONLY this class (partially coded) with the supplied partial demo() and inner interfaces, 
 * 
 * 	ItemAPI, ItemFactoryAPI, OrderAPI, PersonAPI, CustomerAPI
 * 
 * 
 * 25 POINTS
 * Complete the partial code in this class (including the demo() method) 
 * and design the following inner classes:
 * 
 * 	Item derived from ItemAPI
 * 	Order derived from OrderAPI
 *  Person derived from PersonAPI
 *  Customer derived from Person and CustomerAPI
 *  
 *  Customer with the following attributes:
 *  
 *  ID	First 	Last	Shopping Items
 *  
 *  102	Jane	Jones	JewleryItems
 *  103	John	Wayne	ClothingItems
 *  104	Amy		Smith	ShoeItems
 *  
 *  
 * 25 POINTS
 *  JewelryItem derived from Item with the following attributes:
 *  
 * 	ID   PRICE  NAME      	SIZE DESCRIPTION
 * 
 * 	1013 249.99 Jewelry		 7	14 carat gold ring
 * 	1011  49.99 Jewelry		 9  leather ring
 * 	1012 349.99	Necklace	18  18 carat rope chain
 * 	1010   9.99 Jewelry		 8	costume jewelry
 *  
 *  Factories for JewelryItem objects:
 *  
 *  JewelryItemFactory implements ItemFactoryAPI
 *  Enum Singleton	JewelryItemFactoryEnumSingleton
 *	Lazy Singleton	JewelryItemFactoryLazySingleton
 *	Eager Singleton	JewelryItemFactoryEagerSingleton
 *
 *  CSV Strings to use with factories to create JewelryItem objects:
 *  
 * "1013,249.99,Jewelry,7,14,14 carat gold ring"			
 * "1011,49.99,Jewelry,9,0,leather ring"					
 * "1012,349.99,Necklace,18,24,18 carat gold rope chain"	
 * 
 *  SORT ALL JewelryItem objects by ID, PRICE and SIZE
 *  NOTE: MUST USE ItemAPI to sort
 *  
 *  
 * 25 POINTS
 *  ClothingItem derived from Item with the following attributes:
 *  
 * 	ID   PRICE  NAME      	SIZE DESCRIPTION
 * 
 * 	1013 249.99 Clothing	 7	gold sequin formal gown
 * 	1011  49.99 Clothing	 9  red faux leather jacket
 * 	1012 349.99	Suit		38  blue wool pinstripped suit
 * 	1010  39.99 Clothing	 8	black casual clothing
 *  
 *  Factories for ClothingItem objects:
 *  
 *  ClothingItemFactory implements ItemFactoryAPI
 *  Enum Singleton	ClothingItemFactoryEnumSingleton
 *	Lazy Singleton	ClothingItemFactoryLazySingleton
 *	Eager Singleton	ClothingItemFactoryEagerSingleton
 *
 *  CSV Strings to use with factories to create ClothingItem objects:
 *  
 * "1023,249.99,Clothing,7,gold,sequin formal gown";
 * "1021,49.99,Clothing,9,red,faux leather jacket";
 * "1022,349.99,Suit,38,blue,wool pinstriped suit";
 * 
 *  SORT ALL ClothingItem objects by ID, PRICE and SIZE
 *  NOTE: MUST USE ItemAPI to sort
 *  
 *  
 * 25 POINTS
 *  ShoeItem derived from Item with the following attributes:
 *  
 * 	ID   PRICE  NAME      	SIZE DESCRIPTION
 * 
 * 	1013 249.99 Shoe	 7	gold gold trimmed sneaker
 * 	1011  49.99 Shoe	 9  red sandals
 * 	1012 349.99	Boot	12  blue suede designer boots
 * 	1010  39.99 Shoe	 8	black flipflops
 *  
 *  Factories for ShoeItem objects:
 *  
 *  ShoeItemFactory implements ItemFactoryAPI
 *  Enum Singleton	ShoeItemFactoryEnumSingleton
 *	Lazy Singleton	ShoeItemFactoryLazySingleton
 *	Eager Singleton	ShoeItemFactoryEagerSingleton
 *
 *  CSV Strings to use with factories to create ShoeItem objects:
 *  
 * "1033,249.99,Shoe,7,gold,gold trimmed sneaker";
 * "1031,49.99,Shoe,9,red,sandals";
 * "1032,349.99,Boots,12,blue,suede designer boots";
 * 
 *  SORT ALL ShoeItem objects by ID, PRICE and SIZE
 *  NOTE: MUST USE ItemAPI to sort
 *  
 * @author dpeters
 *
 */
public class Saks {


	/**
	 * add a Saks customer order
	 * 
	 * @param customerOrder
	 */
	public void add(OrderAPI customerOrder) {
		// STUDENT MUST COMPLETE
		
	}
	/**
	 * sort all Saks customer order
	 * @param c
	 */
	public void sort(Comparator<ItemAPI> c) {
		// STUDENT MUST COMPLETE
		
	}
	
	
	/**
	 * ItemAPI implemented by all Item objects for sale
	 *
	 * @author dpeters
	 */
	private interface ItemAPI extends Comparable<ItemAPI>  {
		NumberFormat f = new DecimalFormat("##.##");
		int getId();
		void setId(int id);
		double getPrice();
		void setPrice(double price);
		String getName();
		void setName(String name);
	}
	/**
	 * OrderAPI implemented by all Order objects representing a customer's purchase order
	 *
	 * @author dpeters
	 */
	private interface OrderAPI {
		int getOrderId();
		double getTotal();
		String getName();
		String getDescription();
		List<ItemAPI> getItems();
	}
	/**
	 * PersonAPI
	 */
	private interface PersonAPI {
		int getId();
		String getFirstName();
		String getLastName();
	}
	/**
	 * CustomerAPI implemented by all Customer objects
	 */
	private interface CustomerAPI extends PersonAPI {
		List<ItemAPI> add(ItemAPI item);
		List<ItemAPI> remove(ItemAPI item);
		List<ItemAPI> getList();
	}
	/**
	 * ItemFactoryAPI for Factory method design pattern
	 * @author dpeters
	 *
	 */
	private interface ItemFactoryAPI {
		ItemAPI getObject();
		ItemAPI getObject(String csvData);
	}
	

	
	/**
	 * STUDENT MUST COMPLETE
	 * demonstrate the use of this Saks class
	 * 
	 */
	public static void demo() {
		System.out.println("\n\t" + Saks.class.getName() + ".demo()...");
		
		Saks obj = new Saks();
		
		
		/**
		 * STUDENT MUST COMPLETE
		 * 
		 * Make Customer Objects
		 */
		// STUDENT MUST COMPLETE
		
		
		
		
		System.out.println("SORT BY ID...");
		// STUDENT MUST COMPLETE
		
		System.out.println(obj);
		
		System.out.println("SORT BY PRICE...");
		// STUDENT MUST COMPLETE
		
		System.out.println(obj);
		
		System.out.println("SORT BY SIZE...");
		// STUDENT MUST COMPLETE
		
		System.out.println(obj);	
		
		System.out.println("\n\t" + Saks.class.getName() + ".demo()... done!");
	}
}
