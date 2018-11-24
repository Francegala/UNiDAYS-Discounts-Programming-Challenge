package unidayschallenge.galassi.francesco;

/**
 * This basic discount system applies discounts to an online shopping order and calculates the total price based on a set of pricing rules.
 * 
 * @author Francesco Galassi
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UnidaysDiscountChallenge {

	//final map handling the items from the text file
	private final Map<String, String[]> ITEMS = new HashMap<String, String[]>();

	//variables to store expenses
	private int total;
	private int deliveryCharge=0; 

	//lists to store the items added to the cart
	private Map<String, Integer> cart = new HashMap<String, Integer>();
	public List<String> shoppingList = new ArrayList<String>();

	private Scanner source;
	private Scanner keyboard;


	//this constructor reads in all the items from the file and their prices and discounts and converts them into a map
	public UnidaysDiscountChallenge(String pricingRules) throws FileNotFoundException{
		FileReader from = new FileReader(pricingRules);
		source = new Scanner (from);
		source.useDelimiter(", |\r\n");

		while(source.hasNextLine()){

			this.ITEMS.put(source.next(),new String[] {source.next(),source.next(),source.next()} );

		}

	}


	//this methods adds items to the basket and then using the discount rules it add item costs to the total 
	public void addToBasket(String inputItem) throws MyException{
		String item = inputItem.toUpperCase();
		if(this.ITEMS.containsKey(item)){
			this.shoppingList.add(item);
			if (this.cart.containsKey(item)){
				this.cart.put(item, this.cart.get(item) + 1);
				if(Integer.parseInt(this.ITEMS.get(item)[2])!=0){
					if(this.cart.get(item)%Integer.parseInt(this.ITEMS.get(item)[2])==0){this.total+=Integer.parseInt(this.ITEMS.get(item)[1]);}
					else{this.total+=Integer.parseInt(this.ITEMS.get(item)[0]);}
				}else{this.total+=Integer.parseInt(this.ITEMS.get(item)[0]);}
			}else{
				this.cart.put(item,1);
				if(Integer.parseInt(this.ITEMS.get(item)[2])!=0){
					if(this.cart.get(item)%Integer.parseInt(this.ITEMS.get(item)[2])==0){this.total+=Integer.parseInt(this.ITEMS.get(item)[1]);}
					else{this.total+=Integer.parseInt(this.ITEMS.get(item)[0]);}
				}else{this.total+=Integer.parseInt(this.ITEMS.get(item)[0]);}

			}
		}
		else{//error thrown if an unknown item is added
			throw new MyException("Incorrect Item, please check that you enter a correct Name");

		}




	}

	//this method return the total price based on the items added
	public int calculateTotalPrice(){
		return this.total;		
	}

	//this method calculates and return the delivery expenses based on the total price 
	public int calculateDeliveryPrice(){
		deliveryCharge=0;
		if(this.total<50 && this.total>0){
			this.deliveryCharge += 7;
		}

		return this.deliveryCharge;		
	}


	//this user interface allow the user to have a proper shopping experience by adding or deleting items calculating prices or simply knowing items price
	public void userInterface() throws MyException, FileNotFoundException{
		keyboard = new Scanner(System.in);
		String inputItems;
		String shoppingListLinear;
		System.out.println();
		System.out.println("Please select from one of the following options: [0-6]");
		System.out.println("0 - Use the user interface, enter in shopping mode");
		System.out.println("1 - Add elements to the cart");
		System.out.println("2 - Know item price");
		System.out.println("3 - Calculate the delivery costs");
		System.out.println("4 - Calculate the total cost");
		System.out.println("5 - Clear the entire basket");
		System.out.println("6 - Exit System");


		int choice = keyboard.nextInt();
		while(choice>=0){
			switch (choice) {
			case 0:
				keyboard = new Scanner(System.in);
				System.out.println("Please add Items (e.g. AB CA A) or press enter/null/none for an empty cart: ");

				inputItems= keyboard.nextLine().toLowerCase();
				shoppingListLinear = null;
				if(!inputItems.contains("null") && !inputItems.contains("none")){
					char[] splitItems = inputItems.trim().replaceAll("\\s+","").toCharArray();
					for (int i = 0; i < splitItems.length; i++){
						this.addToBasket(String.valueOf(splitItems[i]));
					}
				}
				if(shoppingList.size()==0){shoppingListLinear = "_None_";}else{
					for (int j =0;j<shoppingList.size();j++) {
						if(shoppingListLinear==null){shoppingListLinear = shoppingList.get(j);}
						else{shoppingListLinear = shoppingListLinear + shoppingList.get(j);}
					}
				}
				System.out.printf("%-15s%-10s%-1s\n", "Items", "Total", "Delivery Charge");
				System.out.printf("%-15s%-10s%-1s\n",shoppingListLinear, calculateTotalPrice(),calculateDeliveryPrice());
				userInterface();

			case 1:
				keyboard = new Scanner(System.in);
				System.out.println("Please add Items divided by a space (e.g. A B C) or press enter for an empty cart: ");

				inputItems = keyboard.nextLine().toLowerCase();
				shoppingListLinear = null;
				if(!inputItems.contains("null") && !inputItems.contains("none")){
					char[] splitItems = inputItems.trim().replaceAll("\\s+","").toCharArray();
					for (int i = 0; i < splitItems.length; i++){
						this.addToBasket(String.valueOf(splitItems[i]));
						System.out.println("Item \""+ String.valueOf(splitItems[i]).toUpperCase() +"\" added");

					}
				}
				if(shoppingList.size()==0){shoppingListLinear = "_None_";}else{
					for (int j =0;j<shoppingList.size();j++) {
						if(shoppingListLinear==null){shoppingListLinear = shoppingList.get(j);}
						else{shoppingListLinear = shoppingListLinear + shoppingList.get(j);}
					}
				}
				userInterface();

			case 2:
				keyboard = new Scanner(System.in);
				System.out.println("Please write the item name to know the price: ");
				inputItems = keyboard.next().toUpperCase();
				System.out.println("Item \""+inputItems+"\" price is: " +this.ITEMS.get(inputItems)[0]);
				userInterface();

			case 3:
				System.out.println("Delivery costs: "+calculateDeliveryPrice());
				userInterface();
			case 4:
				System.out.println("Total costs: "+calculateTotalPrice());
				userInterface();
			case 5:
				deliveryCharge=0;
				total=0;
				shoppingList.clear();
				cart.clear();
				System.out.println("Cart cleared");
				userInterface();
			case 6:
				System.exit(0);
				break;
			default:
				break;
			}
		}


	}

}
