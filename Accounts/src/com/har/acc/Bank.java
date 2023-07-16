package com.har.acc;

public class Bank {
	private String bankName;
	private String branchName;
	private Account[] acc;
	
	public Bank() {	}
	
	public Bank(String bankName, String branchName, Account[] acc) {
		this.bankName = bankName;
		this.branchName = branchName;
		this.acc = acc;
	}

	public void addAccount(Account a) throws InsufficientBalanceException {
		boolean added = false;
		for(int i=0; i<acc.length && added == false;i++) {
			if (acc[i] != null) {
				acc[i] = a;
				added = true;
			}
			
		}
		if(!added)
			throw new InsufficientBalanceException("Account Book Full!!!");
	}
	
	public String transactionForBank(char ttype,Account a,double amount) {
		switch(ttype) {
		case 'w':
			Transaction.withdraw(a, amount);
			return "Transaction Successful\nAmount Withdraw: "+amount+" /-";
		case 'd':
			Transaction.deposite(a, amount);
			return "Transaction Successful\n Amount Deposited: "+amount+" /-";
		default:
			throw new InsufficientBalanceException("Invalid Transaction!!!");
		}
		
	}
	
	public void showAccounts() {
		System.out.println("---------------Bank Details---------------");
		System.out.println("Account Number: "+ this.getBankName());
		System.out.println("Account Holder's Name: "+ this.getBranchName());
		System.out.println("-----------------------------------------");
		System.out.println("-------------Account Details-------------");
		for(int i=0; i<acc.length && acc[i] != null;i++) {
			System.out.println("Account Number: "+ acc[i].getAccountNo());
			System.out.println("Account Holder's Name: "+ acc[i].getName());
			System.out.println("Account Balance: "+ acc[i].getBalance());
			System.out.println("Account Type: "+acc[i].getClass().getSimpleName() );
			System.out.println("Date of Account Opening : " + acc[i].dateOfOpening.getDayOfMonth()+"-"+acc[i].dateOfOpening.getMonthValue()+"-"+acc[i].dateOfOpening.getYear());
			System.out.println("-----------------------------------------");
			
		}
	}
	
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Account[] getAccounts() {
		return acc;
	}

	public void setAccounts(Account[] acc) {
		this.acc = acc;
	}

	
	
	
}