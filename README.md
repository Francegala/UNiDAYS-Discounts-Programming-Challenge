# UNiDAYS Discounts Programming Challenge

My solution for the UNiDAYS software engineer placement challenge.

## How to run my code: Java

### Why Java?
I decided to use Java as programming language since Java is one of the most popular programming languages and is often required for a job placement. It is so versatile - you can create programs and apps for mobile or for the web.

IDE used: Eclipse

### Using the program
 I developed classes that could be used for the development of an application, so there is no main method to run.
  I also developed an User Interface through the method _ *userInterface()* _ to allow the user to run tests and use the system.
 
 ```
Please select from one of the following options: [0-6]
0 - Use the user interface, enter in shopping mode
1 - Add elements to the cart
2 - Know item price
3 - Calculate the delivery costs
4 - Calculate the total cost
5 - Clear the entire basket
6 - Exit System
```
Using the command line interface, the user can:
* 0 use a guided interface to add items to the cart and know all the expenses
* 1 Add items to the cart without knowing the costs
* 2 The item price is displayed
* 3 The delivery costs are displayed
* 4 The sum of all the items costs are displayed
* 5 Empty the cart
* 6 Close the program

## Implementation
Since I am aiming to create a general purpose system, I decided to use a text file as "pricing rules" so the administrator can add products and even set new discounts up.

| Item | Price  | Discount |
| ---- | ------ | -------- |
| A    | £8.00  | None |
| B    | £12.00 | 2 for £20.00 |
| C    | £4.00  | 3 for £10.00 |
| D    | £7.00  | Buy 1 get 1 free |
| E    | £5.00  | 3 for the price of 2 |

```
A, 8, 0, 0
B, 12, 8, 2
C, 4, 2, 3
D, 7, 0, 2
E, 5, 0, 3
```

The first column of the file is the actual list of all the products names, the second is the price of every single items and the other two lines are used to identify the discount: third row identrify the price of the discounted element and the last row after how many product apply the discount.
* For the product called "A" the price is 8 and there is no discount (0, 0);
* For the product called "B" the price is 12, the discounted item price is 8 and the discount is applied to the second product having the same name purchased ("2")
* For the product called "C" the price is 4, the discounted item price is 2 and the discount is applied every 3 items (the number 3)
* For the product called "D" the price is 7, the discounted item price is 0, so it's free and the discount is applied to the second item with the same name
* For the product called "E" the price is 5, the discounted item price is 0, so it's free and is applied at the third product purchased (number 3 in the last column)

Then this list is passed as parameter to the main class.
My _ *UnidaysDiscountChallenge(String pricingRules)* _ method reads the source text file containing the list of all the products the shop has with their prices,
```
	public UnidaysDiscountChallenge(String pricingRules) throws FileNotFoundException{
		FileReader from = new FileReader(pricingRules);
		source = new Scanner (from);
		source.useDelimiter(", |\r\n");
		
		while(source.hasNextLine()){
			
			this.ITEMS.put(source.next(),new String[] {source.next(),source.next(),source.next()} );
			
			}
		
	}
```
and converts it to a ready to use Map.
```
	private final Map<String, String[]> ITEMS = new HashMap<String, String[]>();
```
If the users desire to add products to their cart, the _ * addToBasket(String inputItem)* _ method is called and it read a text parameter (String) and if it is the name of one of the items present in the inventory, the method adds it to a shopping chart.
The total variable is increased to based on the price of the product and it's relative discount.
```
	public void addToBasket(String inputItem) throws MyException{
		String item = inputItem.toUpperCase(); **case insensitivity**
		if(this.ITEMS.containsKey(item)){ **if it is an existing product, add it to the shopping list **
			this.shoppingList.add(item);
			if (this.cart.containsKey(item)){ **if it is already present in the cart increase the counter of the number of same products, otherwise add it to the cart**
				this.cart.put(item, this.cart.get(item) + 1);
				if(Integer.parseInt(this.ITEMS.get(item)[2])!=0){
					if(this.cart.get(item)%Integer.parseInt(this.ITEMS.get(item)[2])==0){this.total+=Integer.parseInt(this.ITEMS.get(item)[1]);} **calculate the price**
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
```
** How the price is calculated **
Since my main focus is on give to create a program to be used in a real context so with the possibility to be edited easily without changing the code, I saved all the products information in a text file outside the Java code.
Prices are calcualted in this way:
if the element added has a discount so value of its third column is not equal to zero check if the discount applies otherwise add normal price
if the user has not already added this product to the cart, add the price of the single product to the total
otherwise use the modulo operator to know when to apply the discount so if the quantity of elements divided by the element of the third column in the text file has not remainder, the discount is applied (e.g the discount applies every 3 elements and there are 3 elements in the cart = 3%3=0, apply the discount.)
					
```
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

```
These two methods return the total price of the items contained within the cart and the price of delivery, so if the total cost is greater than 50, the deliveries would be free.




## Approach to the program
My approach was to create a general piece of software aimed at the commercial sector, in which a list of items is read from a text file and is displayed alongside their individual prices, and any discounts which may apply to them. This was based on a simple algorithm which would automatically handle discounts, by using a text file which lists the number of products required to be purchased by the user for a discount to be applied. Records in this file were created using the item name, a white space, then the single item price followed by the price of supplementary items following any discount, and then the ordinal number of the product (i.e. the second -> 2, the third -> 3).

I decided on a simplistic approach which would not involve using many classes as objects as I did not deem this necessary for the project - my only object is the UnidaysDiscountChallenge. This would only allow the use of one single basket per customer; however, it would be possible to instantiate the object multiple times which would, in essence, allow for the application of alternate discount rules per object.


## Tests
I wrote three test cases to test my program.
* **UnidaysDiscountChallengeTest** tests all the examples shown in the specification.

| Items          | Total  | Delivery Charge |
| -------------- | ------ | --------------- |
| _None_         | £0.00  | £0.00 |
| A              | £8.00  | £7.00 |
| B              | £12.00 | £7.00 |
| C              | £4.00  | £7.00 |
| D              | £7.00  | £7.00 |
| E              | £5.00  | £7.00 |
| BB             | £20.00 | £7.00 |
| BBB            | £32.00 | £7.00 |
| BBBB           | £40.00 | £7.00 |
| CCC            | £10.00 | £7.00 |
| CCCC           | £14.00 | £7.00 |
| DD             | £7.00  | £7.00 |
| DDD            | £14.00 | £7.00 |
| EE             | £10.00 | £7.00 |
| EEE            | £10.00 | £7.00 |
| EEEE           | £15.00 | £7.00 |
| DDDDDDDDDDDDDD | £49.00 | £7.00 |
| BBBBCCC        | £50.00 | £0.00 |
| ABBCCCDDEE     | £55.00 | £0.00 |
| EDCBAEDCBC     | £55.00 | £0.00 |

* **UnidaysDiscountChallengeTestUI** allows for the testing and the usage of the interface as the system is created as an implementation of an application and as such, there is no main to execute.

* **UnidaysDiscountChallengeTestBoundsandErrors** tests boundaries such as file not found or items not found.
