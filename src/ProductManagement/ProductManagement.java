package ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
	List<String> list = new ArrayList<>();

	public void productmanagement() throws IOException {

		Scanner sc = new Scanner(System.in);
		Product product = new Product();
		System.out.println("*********Welcome To Product Management********");
		loadDataFromFile();
		boolean run = true;
		while (run) {
			System.out.println("What you would like to do today");
			System.out.println("1.Add Product");
			System.out.println("2.Update product");
			System.out.println("3.Search Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Print Product");
			System.out.println("9.Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			Scanner sc1 = new Scanner(System.in);
			switch (choice) {
			case 1:
				System.out.println("Enter product details");
				System.out.println("enter product name: ");
				product.name = sc1.next();
				System.out.println("enter product quantity: ");
				product.productquantity = sc.nextInt();
				System.out.println("enter product price: ");
				product.productprice = sc.nextInt();
				list.add(product.name + ", " + product.productquantity + ", " + product.productprice);
				System.out.println("Product Added Successfully!!!!");
				break;
			case 2:
				System.out.println("enter product name that you want to update");
				String productNameToUpdate = sc1.next();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(productNameToUpdate)) {
						System.out.println("enter product details");
						System.out.println("enter product name: ");
						String productname = sc.next();
						System.out.println("enter product quantity: ");
						int productquantity = sc.nextInt();
						System.out.println("enter product price: ");
						int productprice = sc.nextInt();
						list.add(i, productname + ", " + productquantity + ", " + productprice);
						System.out.println("Product update succesfully");
					}
				}
				break;
			case 3:
				System.out.println("enter product name that you want to search: ");
				String productnameToSearch = sc.next();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(productnameToSearch)) {
						System.out.println(list.get(i));
					}
				}
				break;
			case 4:
				System.out.println("Enter product name that you want to delete: ");
				String productnameToBeDelete = sc.next();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(productnameToBeDelete)) {
						list.remove(i);
					}
				}
				System.out.println("product deleted successfully!!!");
				break;
			case 5:
				for (String line : list) {
					System.out.println(line);
				}
				break;
			case 9:
				System.out.println("Exit Product Mangement Successfully!!");
				loadDataToFile();
				run = false;
				break;
			default:
				System.out.println("invalid input");
				break;
			}
		}
	}
	public void loadDataFromFile() throws IOException {
		String path = "C:\\Users\\onkar\\eclipse-workspace\\Ecommerce_ArrayList_02\\src\\ProductManagement\\product.txt";
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		String line = "";
		while ((line = bufferReader.readLine()) != null) {
			list.add(line);
		}
		bufferReader.close();
	}
	public void loadDataToFile() throws IOException {
		String path = "C:\\Users\\onkar\\eclipse-workspace\\Ecommerce_ArrayList_02\\src\\ProductManagement\\product.txt";
		File file = new File(path);
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);
		for (String line : list) {
			bw.write(line);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
