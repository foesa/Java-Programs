import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class harnessRecords {
	ArrayList<harness> harnessList = new ArrayList<harness>();

	public harnessRecords() {
	}

	public harnessRecords(InputStream data) {
		Scanner inputScanner = new Scanner(data);
		String firstLine = inputScanner.nextLine();
		int numberOfHarnesses = Integer.parseInt(firstLine);
		boolean eof = false;
		while (!eof) {
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
		for(int count = 0; count<this.harnessList.size();count++) {
			if(harnessList.get(count).make.equals(make) && harnessList.get(count).modelNumber == modelNumber) {
				return harnessList.get(count);
			}
		}
		return null;
	}

	public void checkHarness(String instructorName, String harnessmake, int modelNumber ) {
		harness checkedHarness = findHarness(harnessmake, modelNumber);
	}

}
