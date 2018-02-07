
public interface BankInterface {
	public long accountNumber();
	public BankCustomer findCustomer(long accountNumber);
	public boolean debitAccount(long accountNumber, double debitAmount);
	public boolean creditAccount(long accountNumber, double creditAmount);
	public void printBalance(long AccountNumber);

}
