package ecommerce;

import java.io.IOException;
import java.util.Scanner;

import ProductManagement.ProductManagement;
import UserManagement.UserManagement;

public class ApplicationMain {
	public static void main(String[] args) throws IOException {
		System.out.println("*******Welcome To Ecommerce_02********");
		Scanner sc = new Scanner(System.in);
		ProductManagement product = new ProductManagement();
		UserManagement user = new UserManagement();
		boolean run = true;
		while (run) {
			System.out.println("What you would like you to do today");
			System.out.println("1.User Management");
			System.out.println("2.Product Management");
			System.out.println("9.Exit");
			System.out.println("Enter Your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				user.usermanagement();
				break;
			case 2:
				product.productmanagement();
				break;
			case 9:
				System.out.println("Exit Application Successfully!!!");
				run = false;
				break;
			default:
				System.out.println("Invalid Input");
				break;

			}
		}
	}


}
