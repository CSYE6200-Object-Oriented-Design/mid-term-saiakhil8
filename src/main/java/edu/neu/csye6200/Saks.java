package edu.neu.csye6200;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

	private List<OrderAPI> orders;

	{
		this.orders = new ArrayList<>();
	}


	/**
	 * add a Saks customer order
	 * 
	 * @param customerOrder
	 */
	public void add(OrderAPI customerOrder) {
		// STUDENT MUST COMPLETE
		this.orders.add(customerOrder);
		
	}
	/**
	 * sort all Saks customer order
	 * @param c
	 */
	public void sort(Comparator<ItemAPI> c) {
		// STUDENT MUST COMPLETE
		this.orders.forEach(order->{
			order.getItems().sort(c);
		});
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

	public static class Item implements ItemAPI{

		private int size;
		private int id;
		private double price;
		private String description;
		private String name;

		public Item(String csv) {
			this(csv.split(","));
		}

		private Item(String[] params){
			this.size = stringToInt(params[3]);
			this.id = this.stringToInt(params[0]);
			this.price = this.stringToDouble(params[1]);
			this.description = params[4];
			this.name = params[2];
		}

		public Item() {
		}

		private int stringToInt(String s){
			try {
				return Integer.parseInt(s);
			}catch (NumberFormatException e){
				return 0;
			}
		}

		private double stringToDouble(String s){
			try {
				return Double.parseDouble(s);
			}catch (NumberFormatException e){
				return 0;
			}
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		@Override
		public int getId() {
			return this.id;
		}

		@Override
		public void setId(int id) {
			this.id = id;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(ItemAPI o) {
			return Integer.compare(this.getSize(),((Item)o).getSize());
		}

		@Override
		public String toString() {
			return "Item{" +
					"size=" + size +
					", id=" + id +
					", price=" + price +
					", description='" + description + '\'' +
					", name='" + name + '\'' +
					'}';
		}
	}

	public static class JewelryItem extends Item{
		public static List<String> csvLines = Arrays.asList("1013,249.99,Jewelry,7,14,14 carat gold ring",
				"1011,49.99,Jewelry,9,0,leather ring",
				"1012,349.99,Necklace,18,24,18 carat gold rope chain",
				"1010,9.99,Jewelry,8,costume jewelry"
				);

		public JewelryItem(String csv) {
			super(csv);
		}

		@Override
		public String toString() {
			return "JEWELRY{"+super.toString()+"}";
		}

		public JewelryItem() {

		}
	}

	public static class ClothingItem extends Item{

		public static List<String> csvLines = Arrays.asList("1023,249.99,Clothing,7,gold,sequin formal gown",
				"1021,49.99,Clothing,9,red,faux leather jacket",
				"1022,349.99,Suit,38,blue,wool pinstriped suit",
				"1010,39.99,Clothing,8,black casual clothing"
		);

		public ClothingItem(String csv) {
			super(csv);
		}

		public ClothingItem(){
			super();
		}
		@Override
		public String toString() {
			return "ClothingItem{"+super.toString()+"}";
		}
	}

	public static class ShoeItem extends Item{

		public static List<String> csvLines = Arrays.asList("1033,249.99,Shoe,7,gold,gold trimmed sneaker",
				"1031,49.99,Shoe,9,red,sandals",
				"1032,349.99,Boots,12,blue,suede designer boots",
				"1010,39.99,Shoe,8,black flipflops"
		);

		public ShoeItem(String csv) {
			super(csv);
		}

		public ShoeItem() {

		}

		@Override
		public String toString() {
			return "ShoeItem{"+super.toString()+"}";
		}
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

	public static class Order implements OrderAPI{

		private int orderId;
		private double totalAmount;
		private String name;
		private String description;
		private CustomerAPI customer;

		public Order(int orderId,String name, String description, CustomerAPI customer) {
			this.orderId = orderId;
			this.totalAmount = 0;
			this.name = name;
			this.description = description;
			this.customer = customer;
		}

		@Override
		public int getOrderId() {
			return this.orderId;
		}

		@Override
		public double getTotal() {
			int total  = 0;
			for (ItemAPI item : this.getItems()) {
				total+=item.getPrice();
			}
			return total;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public String getDescription() {
			return this.description;
		}

		@Override
		public List<ItemAPI> getItems() {
			return customer.getList();
		}

		@Override
		public String toString() {
			return "Order{" +
					"orderId=" + orderId +
					", totalAmount=" + totalAmount +
					", name='" + name + '\'' +
					", description='" + description + '\'' +
					", customer=" + customer +
					'}';
		}
	}
	/**
	 * PersonAPI
	 */
	private interface PersonAPI {
		int getId();
		String getFirstName();
		String getLastName();
	}

	public static class Person implements PersonAPI{

		private int id;
		private String firstName;
		private String lastName;

		public Person(int id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public int getId() {
			return this.id;
		}

		@Override
		public String getFirstName() {
			return this.firstName;
		}

		@Override
		public String getLastName() {
			return this.lastName;
		}
	}

	public static class Customer extends Person implements CustomerAPI{
		private List<ItemAPI> list;
		public Customer(int id, String firstName, String lastName) {
			super(id, firstName, lastName);
			this.list = new ArrayList<>();
		}

		@Override
		public List<ItemAPI> add(ItemAPI item) {
			this.list.add(item);
			return this.list;
		}

		@Override
		public List<ItemAPI> remove(ItemAPI item) {
			this.list.remove(item);
			return this.list;
		}

		@Override
		public List<ItemAPI> getList() {
			return this.list;
		}

		@Override
		public String toString() {
			return "Customer{" +
					"Items List=" + list +
					", id=" + this.getId() +
					", firstName='" + this.getFirstName() + '\'' +
					", lastName='" + this.getFirstName() + '\'' +
					'}';
		}
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

	public static class ClothingItemFactory implements ItemFactoryAPI{

		@Override
		public ItemAPI getObject() {
			return new ClothingItem();
		}

		@Override
		public ItemAPI getObject(String csvData) {
			return new ClothingItem(csvData);
		}
	}

	public enum ClothingItemFactoryEnumSingleton{

		INSTANCE;
		private ItemFactoryAPI instance = null;

		private ClothingItemFactoryEnumSingleton () {
			this.instance = new ClothingItemFactory();
		}
		public ItemFactoryAPI getInstance() {
			return this.instance;
		}
	}

	private static class ClothingItemFactoryEagerSingleton {
		private static ItemFactoryAPI instance = new ClothingItemFactory();

		private ClothingItemFactoryEagerSingleton () {
		}
		public static ItemFactoryAPI getInstance() {
			return ClothingItemFactoryEagerSingleton.instance;
		}
	}

	private static class ClothingItemFactoryLazySingleton {
		private static volatile ItemFactoryAPI instance;

		private ClothingItemFactoryLazySingleton () {
			ClothingItemFactoryLazySingleton.instance = null;
		}
		public static synchronized ItemFactoryAPI getInstance() {
			if (null == ClothingItemFactoryLazySingleton.instance) {
					ClothingItemFactoryLazySingleton.instance = new ClothingItemFactory();
			}
			return ClothingItemFactoryLazySingleton.instance;
		}
	}

	private static class ShoeItemFactory implements ItemFactoryAPI {
		@Override
		public ItemAPI getObject() {
			return new ShoeItem();
		}

		@Override
		public ItemAPI getObject(String csvData) {
			return new ShoeItem(csvData);
		}
	}

	private enum ShoeItemFactoryEnumSingleton {
		INSTANCE;
		private ItemFactoryAPI instance = null;

		private ShoeItemFactoryEnumSingleton () {
			this.instance = new ShoeItemFactory();
		}
		public ItemFactoryAPI get() {
			return this.instance;
		}
	}

	private static class ShoeItemFactoryEagerSingleton {
		private static ItemFactoryAPI instance = new ShoeItemFactory();

		private ShoeItemFactoryEagerSingleton () {
		}
		public static ItemFactoryAPI getInstance() {
			return ShoeItemFactoryEagerSingleton.instance;
		}
	}

	private static class ShoeItemFactoryLazySingleton {
		private static ItemFactoryAPI instance;

		private ShoeItemFactoryLazySingleton () {
			ShoeItemFactoryLazySingleton.instance = null;
		}
		public static synchronized ItemFactoryAPI getInstance() {
			if (ShoeItemFactoryLazySingleton.instance == null) {
				ShoeItemFactoryLazySingleton.instance = new ShoeItemFactory();
			}
			return ShoeItemFactoryLazySingleton.instance;
		}
	}

	private static class JewelryItemFactory implements ItemFactoryAPI {
		@Override
		public ItemAPI getObject() {
			return new JewelryItem();
		}

		@Override
		public ItemAPI getObject(String csvData) {
			return new JewelryItem(csvData);
		}
	}

	private enum JewelryItemFactoryEnumSingleton {
		INSTANCE;
		private ItemFactoryAPI instance = null;

		private JewelryItemFactoryEnumSingleton () {
			this.instance = new JewelryItemFactory();
		}
		public ItemFactoryAPI get() {
			return this.instance;
		}
	}


	private static class JewelryItemFactoryEagerSingleton {
		private static ItemFactoryAPI instance = new JewelryItemFactory();

		private JewelryItemFactoryEagerSingleton () {
		}
		public static ItemFactoryAPI getInstance() {
			return JewelryItemFactoryEagerSingleton.instance;
		}
	}

	private static class JewelryItemFactoryLazySingleton {
		private static ItemFactoryAPI instance;

		private JewelryItemFactoryLazySingleton () {
			JewelryItemFactoryLazySingleton.instance = null;
		}
		public static synchronized ItemFactoryAPI getInstance() {
			if (JewelryItemFactoryLazySingleton.instance == null) {
				JewelryItemFactoryLazySingleton.instance = new JewelryItemFactory();
			}
			return JewelryItemFactoryLazySingleton.instance;
		}
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
		CustomerAPI customer1 = new Customer(102,"Jane","Jones");
		customer1.add(new JewelryItemFactory().getObject(JewelryItem.csvLines.get(0)));
		customer1.add(JewelryItemFactoryEnumSingleton.INSTANCE.get().getObject(JewelryItem.csvLines.get(1)));
		customer1.add(JewelryItemFactoryEagerSingleton.getInstance().getObject(JewelryItem.csvLines.get(2)));
		customer1.add(JewelryItemFactoryLazySingleton.getInstance().getObject(JewelryItem.csvLines.get(2)));

		obj.add(new Order(1,"Order 1","D1",customer1));

		CustomerAPI customer2 = new Customer(103,"John","Wayne");
		customer2.add(new ClothingItemFactory().getObject(ClothingItem.csvLines.get(0)));
		customer2.add(ClothingItemFactoryEnumSingleton.INSTANCE.getInstance().getObject(ClothingItem.csvLines.get(1)));
		customer2.add(ClothingItemFactoryEagerSingleton.getInstance().getObject(ClothingItem.csvLines.get(2)));
		customer2.add(ClothingItemFactoryLazySingleton.getInstance().getObject(ClothingItem.csvLines.get(2)));

		obj.add(new Order(2,"Order 2","D2",customer2));

		CustomerAPI customer3 = new Customer(104,"Amy","Smith");
		customer3.add(new ShoeItemFactory().getObject(ShoeItem.csvLines.get(0)));
		customer3.add(ShoeItemFactoryEnumSingleton.INSTANCE.get().getObject(ShoeItem.csvLines.get(1)));
		customer3.add(ShoeItemFactoryEagerSingleton.getInstance().getObject(ShoeItem.csvLines.get(2)));
		customer3.add(ShoeItemFactoryLazySingleton.getInstance().getObject(ShoeItem.csvLines.get(2)));

		obj.add(new Order(3,"Order 3","D3",customer3));
		
		
		
		
		System.out.println("SORT BY ID...");
		// STUDENT MUST COMPLETE
		obj.sort(Comparator.comparing(ItemAPI::getId));
		
		System.out.println(obj);
		
		System.out.println("SORT BY PRICE...");
		// STUDENT MUST COMPLETE
		obj.sort(Comparator.comparing(ItemAPI::getPrice));
		System.out.println(obj);
		
		System.out.println("SORT BY SIZE...");
		// STUDENT MUST COMPLETE
		obj.sort(null);
		
		System.out.println(obj);	
		
		System.out.println("\n\t" + Saks.class.getName() + ".demo()... done!");
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		int[] counter = new int[1];
		this.orders.forEach(order -> {
			stringBuilder.append("Order "+ ++counter[0]+":");
			stringBuilder.append("Details = ").append(order).append("\n");
		});
		return stringBuilder.toString();
	}
}
