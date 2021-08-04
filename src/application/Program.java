package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date data = sdf1.parse(sc.next());

		Client client = new Client(name, email, data);

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		Date moment = new Date();

		Order order = new Order(moment, OrderStatus.valueOf(status), client);

		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		String productName;
		Double productPrice;
		int quantity;

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			productName = sc.nextLine();
			System.out.print("Product price: ");
			productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			quantity = sc.nextInt();

			Product p = new Product(productName, productPrice);
			OrderItem orderitem = new OrderItem(quantity, productPrice, p);
			order.addItem(orderitem);
		}

		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.print("Order moment: " + sdf.format(order.getMoment()) + "\n");
		System.out.print("Order status: " + order.getOrder() + "\n");
		System.out.print("Client: " + order.getClient() + "\n");

		System.out.println("Order items: ");
		for (OrderItem show : order.getItems()) {
			System.out.println(show);
		}

		System.out.println("Total price: ");
		System.out.println(order);

	}

}
