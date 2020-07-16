package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		
		Client c1;
		Order order;
		
		/* --- CLIENT DATA ---*/
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		c1 = new Client(name, email, birthDate);
		
		/* --- ORDER DATA ---*/
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		order = new Order(OrderStatus.valueOf(status), c1);
		
		System.out.print("How many items to this order? ");
		int numItems = sc.nextInt();
		
		for(int i = 1; i <= numItems; i++) {
			System.out.printf("Enter #%d item data: %n", i);
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product p = new Product(productName, productPrice);
			
			OrderItem item = new OrderItem(quantity, p.getPrice(), p);
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
}
