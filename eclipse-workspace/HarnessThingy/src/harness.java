
public class harness {
	String make;
	int modelNumber;
	int noOfUses;
	String nameOfLastCheck;
	boolean isOnLoan;
	String nameOfBorrower;
	public static final int MAX_NUMBER_OF_USES = 25;

	public harness(String make, int modelNumber, int noOfUses, String nameOfLastCheck, boolean isOnLoan,
			String nameOfBorrower) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.noOfUses = noOfUses;
		this.nameOfLastCheck = nameOfLastCheck;
		this.isOnLoan = isOnLoan;
		this.nameOfBorrower = nameOfBorrower;
	}

	public harness(String make, int modelNumber, int noOfUses, String nameOfLastCheck) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.noOfUses = noOfUses;
		this.nameOfLastCheck = nameOfLastCheck;
		this.isOnLoan = false;
		this.nameOfBorrower = "";
	}

	public void checkHarness(String instructorName) {
		if(!(isHarnessOnLoan())) {
			this.noOfUses =0;
			this.nameOfLastCheck = instructorName;
		}
	}

	public boolean isHarnessOnLoan() {
		if (this.isOnLoan) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canHarnessBeLoaned() {
		if(!(isHarnessOnLoan()) && this.noOfUses <MAX_NUMBER_OF_USES ) {
			return true;
		}
		else {
			return false;
		}
	}  
	public void loanHarness(String memberName) {
		if(canHarnessBeLoaned()) {
			this.nameOfBorrower = memberName;
			this.isOnLoan = true;
			this.noOfUses++;
		}
	}
	public void returnHarness() {
		if(isHarnessOnLoan()) {
			this.nameOfBorrower ="";
			this.isOnLoan = false;
		}
	}

	@Override
	public String toString() {
		return "Harness [make=" + this.make + ", modelNumber=" + this.modelNumber + ", noOfUses=" + this.noOfUses
				+ ", nameOfLastCheck=" + this.nameOfLastCheck + ", isOnLoan=" + this.isOnLoan + ", nameOfBorrower="
				+ this.nameOfBorrower + "]";
	}
	

}
