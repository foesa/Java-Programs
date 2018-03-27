import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class harnessRecords {
	private ArrayList<harness> harnessList = new ArrayList<harness>();
	private int numberOfHarnesses;
	
	public harnessRecords() {
		harnessList = null;
	}
	public harnessRecords(InputStream data) {
		Scanner inputScanner = new Scanner(data);
		String firstLine = inputScanner.nextLine();
		numberOfHarnesses = Integer.parseInt(firstLine);
		boolean eof = false;
		while (!eof) {
			if (inputScanner.hasNextLine()) {
				String harnessInfo = inputScanner.nextLine();
				if (harnessInfo != null) {
					String[] harnessString = harnessInfo.split(",");
					String make = harnessString[0];
					int modelNumber = Integer.parseInt(harnessString[1]);
					int noOfUses = Integer.parseInt(harnessString[2]);
					String nameOfLastCheck = harnessString[3];
					harness createHarness = new harness(make, modelNumber, noOfUses, nameOfLastCheck);
					this.harnessList.add(createHarness);
				} else {
					eof = true;
				}
			}
			else {
				eof = true;
			}
		}
	}

	public boolean isEmpty() {
		if (this.harnessList.size() == 0) {
			return true;
		}
		return false;
	}

	public void addHarness(harness addedHarness) {
		harnessList.add(addedHarness);
	}

	public harness findHarness(String make, int modelNumber) {
		for (int count = 0; count < this.harnessList.size(); count++) {
			if (harnessList.get(count).make.equals(make) && harnessList.get(count).modelNumber == modelNumber) {
				return harnessList.get(count);
			}
		}
		return null;
	}

	public harness checkHarness(String instructorName, String harnessmake, int modelNumber) {
		harness checkedHarness = findHarness(harnessmake, modelNumber);
		if (checkedHarness.isHarnessOnLoan() == false) {
			checkedHarness.checkHarness(instructorName);
			return checkedHarness;
		} else {
			return null;
		}
	}

	public harness loanHarness(String userName) {
		harness returnHarness;
		for (int count = 0; count < this.harnessList.size(); count++) {
			returnHarness = harnessList.get(count);
			if ((returnHarness.canHarnessBeLoaned() == true)) {
				returnHarness.loanHarness(userName);
				return returnHarness;
			}
		}
		return null;
	}

	public harness returnHarness(String harnessMake, int modelNumber) {
		harness foundHarness = findHarness(harnessMake, modelNumber);
		if (foundHarness != null) {
			foundHarness.returnHarness();
			return foundHarness;
		} else {
			return null;
		}
	}

	public harness removeHarness(String harnessMake, int modelNumber) {
		harness removeHarness = findHarness(harnessMake, modelNumber);
		if (removeHarness != null) {
			if (harnessList.contains(removeHarness)) {
				harnessList.remove(removeHarness);
				return removeHarness;
			}
		}
		return null;
	}
	public ArrayList<harness> getHarnessList() {
		return harnessList;
	}
	public void setHarnessList(ArrayList<harness> harnessList) {
		this.harnessList = harnessList;
	}
	
	

}
