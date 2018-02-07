import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bank implements BankInterface{
		static BankCustomer[]customerArray = new BankCustomer[100];
		long accountNumber;
		static Map<Long, BankCustomer> customerMap = new HashMap<Long, BankCustomer>();
		
		
		public static void main(String[]args) {
			Bank bank = new Bank();
			BankCustomer myCustomer = new BankCustomer();
			myCustomer.setAccountNumber((long) 17324649);
			myCustomer.setCustomerAddress("Trinity College Dublin");
			myCustomer.setCustomerDateOfBirth("24/07/1999");
			myCustomer.setCustomerEmail("eguavoee@tcd.ie");
			myCustomer.setSortCode(12341312);
			
			
			customerArray[0] = myCustomer;
			
			
		}
		public Bank() {
			account = 10001;
			customerMap = new HashMap<Long, BankCustomer>();
		}
		public void readCustomersFromFile() {
			try {
				FileReader fileReader = new FileReader("customer.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				boolean endOfFileFound = false;
				while(!endOfFileFound) {
					String customerData = bufferedReader.readLine();
					if(customerData == null) {
						endOfFileFound = true; 
					}
					else {
						String[]customerProperties = customerData.split(",");
						BankCustomer customer = new BankCustomer();
						customer.setAccountNumber(Long.parseLong(customerProperties[0]));
						customer.setSortCode(Integer.parseInt(customerProperties[1]));
						customer.setCustomerName(customerProperties[2]);
						customer.setCustomerAddress(customerProperties[3]);
						customer.setCustomerEmail(customerProperties[4]);
						customer.setBalance(new Double(customerProperties[5]));
						customerMap.put(customer.getAccountNumber(), customer);
					}
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public long accountNumber() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public BankCustomer findCustomer(long accountNumber) {
			// TODO Auto-generated method stub
			BankCustomer customer = null;
			boolean customerFound = false;
			int counter = 0;
			while(!customerFound && counter< customerArray.length) {
				customer = customerArray[counter];
				if(customer.getAccountNumber() == accountNumber) {
					customerFound = true;
				}
				counter++;
			}
			return customer;
		}
		@Override
		public boolean debitAccount(long accountNumber, double debitAmount) {
			BankCustomer customer = findCustomer(accountNumber);
			boolean accountDebited = false;
			double balance = customer.getBalance();
			if(balance>= debitAmount) {
				customer.setBalance(balance-debitAmount);
				accountDebited = true;
			}else {
				accountDebited = false;
			}
			return accountDebited;
		}
		@Override
		public boolean creditAccount(long accountNumber, double creditAmount) {
			BankCustomer customer = findCustomer(accountNumber);
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void printBalance(long AccountNumber) {
			// TODO Auto-generated method stub
			
		}

		
	}
