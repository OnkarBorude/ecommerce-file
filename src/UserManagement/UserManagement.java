package UserManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
	List<String> list=new ArrayList<>();
	public void usermanagement() throws IOException {
		System.out.println("******Welcome To User Management*******");
		loadDataFromFile();
		User user=new User();
		boolean run=true;
		while(run) {
			Scanner sc=new Scanner(System.in);
			System.out.println("What would you like to do today");
			System.out.println("1.Add User");
			System.out.println("2.Update User");
			System.out.println("3.Search User");
			System.out.println("4.Delete User");
			System.out.println("5.Print User");
			System.out.println("9.Exit");
			System.out.println("enter your choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("----Add User----");
				System.out.println("Enter User first Name: ");
				user.firstname=sc.next();
				System.out.println("Enter User Last Name: ");
				user.lastname=sc.next();
				System.out.println("Enter User Age: ");
				user.age=sc.nextInt();
				System.out.println("Enter User Email: ");
				user.email=sc.next();
				System.out.println();
				System.out.println("Enter password");
				String password = sc.next();
				System.out.println("Enter Confirm Password");
				String confirmPassword = sc.next();
				if (password.equals(confirmPassword)) {
					user.password = password;
				} else {
					System.out.println("Password and confirm password does not match");
					System.out.println("User Addition failed");
				}
				list.add(user.firstname+", "+user.lastname+", "+user.age+", "+user.email);
				System.out.println("User Added Successfully!!!!");
				break;
			case 2:
				System.out.println("----Update Product----");
				System.out.println("Enter name of user that you want to update: ");
				String updateUserName=sc.next();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).contains(updateUserName)) {
						System.out.println("Enter User First Name: ");
						String userName=sc.next();
						System.out.println("Enter User Last Name: ");
						String userLastName=sc.next();
						System.out.println("Enter User Age: ");
						int Age=sc.nextInt();
						System.out.println("Enter User Email: ");
						String email=sc.next();
						list.add(i, userName+", "+userLastName+", "+Age+", "+email);
					}
				}
			    System.out.println("User Update Successfullty!!!");
			    break;
			case 3:
				System.out.println("----Search User-----");
				System.out.println("Enter User Name That You Want To Search: ");
				String userSearchName=sc.next();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).contains(userSearchName)) {
						System.out.println(list.get(i));
					}
				}
				break;
			case 4:
				System.out.println("----Delete User----");
				System.out.println("Enter User  name That you want to delete: ");
				String deleteUserNmae=sc.next();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).contains(deleteUserNmae)) {
						list.remove(i);
					}
				}
				System.out.println("User Deleted Succesfully!!!");
				break;
			case 5:
				System.out.println("-----Print User------");
				for(String line:list) {
					System.out.println(line);
				}
				break;
			case 9:
				System.out.println("Exit User Management Successfully!!!!");
				loaddataToFile();
				run=false;
				break;
			default :
				System.out.println("Invalid Input");
				break;
					
				}
		}
	}
	public void loadDataFromFile() throws IOException {
		String path="C:\\Users\\onkar\\eclipse-workspace\\Ecommerce_ArrayList_02\\src\\UserManagement\\user.txt";
		File file=new File(path);
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferReader=new BufferedReader(fileReader);
		String line="";
		while((line=bufferReader.readLine()) !=null ) {
			list.add(line);
		}
		bufferReader.close();
	}
	public void loaddataToFile() throws IOException {
		String path="C:\\Users\\onkar\\eclipse-workspace\\Ecommerce_ArrayList_02\\src\\UserManagement\\user.txt";
	    File file=new File(path);
		FileWriter fw=new FileWriter(file, false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(String line:list) {
			bw.write(line);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
