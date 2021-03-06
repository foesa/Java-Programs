import java.util.Date;
public class Transactions {
	private Date transactionsDate;
	private String transactionType;
	private double transactionAmount;
	private double closingBalance;
	
	public Transactions(Date date, String type, double amoun)
	@Override
	public String toString() {
		return "T ransactionsDate=" + transactionsDate + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", closingBalance=" + closingBalance + "]";
	}
	public Date getTransactionsDate() {
		return transactionsDate;
	}
	public void setTransactionsDate(Date transactionsDate) {
		this.transactionsDate = transactionsDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	
	

}
