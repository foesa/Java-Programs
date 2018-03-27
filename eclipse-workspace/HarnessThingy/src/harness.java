
public class harness {
	final String make;
	final int modelNumber;
	private int noOfUses;
	private String nameOfLastCheck;
	private boolean isOnLoan;
	private String nameOfBorrower;
	private static final int MAX_NUMBER_OF_USES = 25;

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

	public String getMake() {
		return make;
	}


	public int getModelNumber() {
		return modelNumber;
	}


	public int getNoOfUses() {
		return noOfUses;
	}

	public void setNoOfUses(int noOfUses) {
		this.noOfUses = noOfUses;
	}

	public String getNameOfLastCheck() {
		return nameOfLastCheck;
	}

	public void setNameOfLastCheck(String nameOfLastCheck) {
		this.nameOfLastCheck = nameOfLastCheck;
	}

	public boolean isOnLoan() {
		return isOnLoan;
	}

	public void setOnLoan(boolean isOnLoan) {
		this.isOnLoan = isOnLoan;
	}

	public String getNameOfBorrower() {
		return nameOfBorrower;
	}

	public void setNameOfBorrower(String nameOfBorrower) {
		this.nameOfBorrower = nameOfBorrower;
	}

	public static int getMaxNumberOfUses() {
		return MAX_NUMBER_OF_USES;
	}
	

}
