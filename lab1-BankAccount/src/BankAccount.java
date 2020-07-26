
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
public class BankAccount {// class Name


	//property
	String[] customerName;
	double[] balance = {100,200,300,400,500};
	int[] accountNumber = {111,222,333,444,555};
	double interestRate = 0.02;
	double receip;
	double x = 0.0 ,totalde = 0.0;
	double monney = 0.0 ;
	int num ,accNum;
	int max = 0, min = 0 ;
	String name;
	String[] transaction = {"D","D","D","D","D"};
	
	
	
	
	//Constructor
	public BankAccount(String[] accountName) {
		//for(int i = 0 ; i < 5 ; i++)
		//	balance[i] = monney ;
		for(int i = 1 ; i > 0 ; i++) {
			System.out.println("Enter 0 to Exit");
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter Account 1-5 : ");
			int login = keyboard.nextInt();
			if(login == 0 ) {
				System.out.println("---------------------Exit-------------------------\n");
				System.exit(0); 
				}
			accNum = login-1;
			num = accountNumber[accNum];
			System.out.println("Account Number : "+num);
			System.out.println("Hello "+accountName[accNum]);
			for(int j = 1 ; j > 0 ; j++) {
				Scanner keyboard1 = new Scanner(System.in);
				System.out.print("Enter Menu [1]:Show Balance [2]:Deposit [3]:Withdraw [0:Exit]  : ");
				int menu = keyboard1.nextInt();
				if(menu == 0) {
					System.out.println("---------------------back-------------------------\n");
					break;
					}
				switch (menu) {
				case 1 :	
							System.out.println(accountName[accNum]+" balance : "+showBalance(accNum)+"\n");
							break;
				case 2 :	
							balance[accNum] = deposit(accNum);
							System.out.println("Deposit Monney Total : (" + showBalance(accNum) + ")\n");
							break;
				case 3 :	
							balance[accNum] = withdraw(accNum);
							System.out.println("Monney Total : (" + showBalance(accNum) + ")\n");
							break;
				}
			}
			for(int j = 0 ; j < 5 ; j++) {
				if (showBalance(j)>showBalance(max)) {
					max = j;
				}
				if (showBalance(j)<showBalance(min)) {
					min = j;
				}
			}
			System.out.println("The person with highest account balance is "+accountName[max]+"($"+balance[max]+")"+"\n");
			System.out.println("The person with lowest account balance is "+accountName[min]+"($"+balance[min]+")"+"\n");
		}		
	}
	
	
	
	//method
	double showBalance(int num) {
		x = balance[num];
		return x;
	}
	
	double deposit(int num ) {
		Scanner keyboard1 = new Scanner(System.in);
		System.out.print("Insert Monney : ");
		double monney = keyboard1.nextInt();
		System.out.println("Interest Rate i s 2% : " + monney*interestRate);
		monney = (monney*interestRate)+monney;
		balance[num] = balance[num]+monney;
		System.out.println("Transaction : "+ addTransaction(num,"D"));
		return balance[num];
	}
	
	double withdraw(int num) {
		System.out.println("Monney In Bank : (" + showBalance(num) + ")\n");
		Scanner keyboard1 = new Scanner(System.in);
		System.out.print("How Much Withdraw : ");
		double monney = keyboard1.nextInt();
		if(monney < showBalance(num)) {
			balance[num] = balance[num] - monney;
			System.out.println("Withdraw Successful!");
			System.out.println("Transaction : "+addTransaction(num,"W"));
			
			
		}else {
			System.out.println("Withdraw False!!");
			balance[num] = balance[num];
		}
		return balance[num];
	}
	
	
	String addTransaction(int num ,String mem) {
		transaction[num] += mem;
		return transaction[num];
	}
	
	
	
	
	//main
	public static void main(String[] args) {
		String[] accountName = {"Mr.A","Mr.B","Mr.C","Mr.D","Mr.E"};
		new BankAccount(accountName);
		}
}
