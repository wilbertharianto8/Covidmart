import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
		
class Staff implements Staffdata{
	private String id;
	
	ArrayList<Product> productlist;			//ASSOCIATE TO PRODUCT
	Product product;
	
	
	//Input option
	Scanner input = new Scanner(System.in);
	
	
	Staff(){ 
		productlist= new ArrayList<Product>();
		}
		
	public void staffid(String id){this.id=id;}
	
	public void addproduct(Product p){ 				//adding fnb data
		productlist.add(p);
	}
	
	
	public void printproduct(){
		for(int b=0; b< productlist.size(); b++){
			System.out.println(((Product)productlist.get(b)).display());
		}
	}
	
	public void printgross(){
		for(int c=0; c< productlist.size(); c++){
				System.out.println(((Product)productlist.get(c)).displaygross());
			}
	}
	
	public void login(){
		
	

		//login staff
		//precondition
		id = JOptionPane.showInputDialog("Please enter the staff id : ");
		
		
		//Welcome staff
		//operation
		switch(id){
			case "s01":
				System.out.println("\n\nStaff number: "+c01+", ");
				System.out.println("Welcome "+ 1+" ("+ j01+")");
				break;
			case "s02":
				System.out.println("\n\nStaff number: "+c02+", ");
				System.out.println("Welcome "+ 2+" ("+ j02+")");
				break;
			default: 
			assert false : "user is not found";
			
		}
		//Main menu
		//postcondition
		System.out.println("-----------------------------");
		System.out.println(" WELCOME TO COVID MART\t");
		System.out.println("-----------------------------");
		System.out.println(" 1. Add new Products");
		System.out.println(" 4. Exit");
		System.out.print("Please choose the menu :");
	}//login
	
	public void nextmenu(){
		
		//Full menu (After adding products)
		//precondition
		System.out.println("\n Continue ?? ...");
		System.out.println("-----------------------------");
		System.out.println(" 1. Add new Products");
		System.out.println(" 2. Display Products");
		System.out.println(" 3. Display Gross income");
		System.out.println(" 4. Exit");
		System.out.print("Please choose the menu :"); 
	}
	public void inputmenu(){
		String code; String name; double prc; int qty; String etc;
		//HOW TO INPUT PRODUUCT
		//operation
		System.out.print("- product code\t\t:");
			code = input.nextLine();
		System.out.print("- product name (2 words):");
			name = input.nextLine();
		System.out.print("- product price (RM)\t:");
			prc = Integer.parseInt(input.nextLine());
			assert (prc > 0): "Input should be positive value";
		System.out.print("- product quantity\t:");
			qty = Integer.parseInt(input.nextLine());
			assert (qty > 0): "Input should be positive value";
		System.out.print("- product expdate/desc\t:");
			etc = input.nextLine();
		//postcondition
		product = new Fnb(code, name, prc, qty, etc);
			addproduct(product); 
					
		nextmenu();
		mainmenu();
	}
	
	public void mainmenu(){
	    
		

		//Main menu option
		//precondition
		int a;
		a= Integer.parseInt(input.nextLine());
		assert (a<5) : "user should input value between 1-4";
		

		//Main menu option 
		//operation
		if(a== 1){
			prodmenu();
			a=Integer.parseInt(input.nextLine());
			
			System.out.println("\n-- INPUT PRODUCT --");
			System.out.println("-----------------------");
		//postcondition	
			switch(a){
				case 1: 
					inputmenu();
					break;
					
				case 2:
					inputmenu();
					
					nextmenu();
					mainmenu();
					break;
				case 4:
					System.exit(0);
			}
						
		}
		
		else if(a== 2){					//DISPLAY MENU
			dismenu();
		}
		else if(a== 3){
			System.out.println("\n COVIDMART Gross Income");
			System.out.println("----------------------------------------");
			System.out.println("Code\tName\t\tPrice\tQty\tGross income");
			System.out.println("------------------------------------------------");
			printgross();
			nextmenu();
			mainmenu();
		}
		
		else if(a== 4){return;}
		assert (a<5) : "user should input value between 1-4";
		
	} //mainmenu
	
	public void prodmenu(){
		System.out.println("\n\n-- ADD PRODUCT --");
		System.out.println("---------------------");
		System.out.println(" 1. Food and Beverage");
		System.out.println(" 2. Personal care");
		System.out.println(" 4. Exit");
		System.out.print("choose product :");
	}//prodmenu
	
	public void dismenu(){
			System.out.println("\n\nDisplaying ...");
			System.out.println("---------------------------------------");
			System.out.println(" COVIDMART Products");
			System.out.println("----------------------------------------");
			System.out.println("Code\tName\t\tPrice\tQty\tExpdate/Desc");
			System.out.println("------------------------------------------------");
					printproduct();
					nextmenu();
					mainmenu();
	}//dismenu
	
}//Staff