import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Checkout shop system that sells apples and oranges
 * 
 * The system request the consumer to input the products (apples and oranges) in 
 * the console panel after the pertinent message. The elements must be split
 * by a ",".
 * 
 * At the end, the tilt shows the total amount for the shopping. 
 * 
 ** General assumptions:
 *  - The elements are always split by a ",". Example(Apple, Orange, Apple, Apple).
 *  - The program is no case sensitive. Orange, orange or ORANge are the same valid product.
 *  - Only oranges and apples will be process to calculate the total amount. Example:
 *  	Orange, 5, Lemon, APPLE, %%%+++7777??, Strawberry
 *  	From the above line only Orange and APPLE will be process.
 *  
 * */

public class CheckoutSystem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String str = "";
		
		//Getting the line written by the consumer through console panel.
		System.out.println("Please, introduce the list of products you want to buy. Example (Orange, apple, apple):");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		str = reader.readLine();
		
		//Please, comment the line above and pick one of the lines below to execute the provided tests, instead of using the elements inserted through the console.
		/*
		 * test 1: 
		 * str = "Apple, Orange, Apple, Apple";
		 * 
		 * test 2: 
		 * str = "apple, APPLE, orange, ORANGe, ApPLe, AppLE, ORANge";
		 * 
		 * test 3:
		 * str = "apple,APPLE,orange,ORANGe,ApPLe,AppLE,ORANge"; 
		 * 
		 * test 4: 
		 * str = "Orange, 5, Lemon, APPLE, %%%+++7777??, Strawberry";
		 * 
		 * test 5: 
		 * str = "Apple, Orange, banana, melon, Apple, Apple, strawberry";
		 * 
		 * test 6: 
		 * str = "1, Orange, 5, melon, ####&&££, Apple, strawberry, !!!546&^%£";
		 *  
		 * */
		//Pass the elements to a List<String> to let us process the elements
		List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
		
		//Calculate the total amount of the shopping
		double totalAmount = 0.0;
		for(String prod : list){
			if(prod.trim().equalsIgnoreCase("apple")){
				totalAmount += 0.60;
			}
			else if(prod.trim().equalsIgnoreCase("orange")){
				totalAmount += 0.25;
			}
		}
		
		//Print the total amount to be paid 
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("Total to pay: "+ currency.format(totalAmount));
	}

}
