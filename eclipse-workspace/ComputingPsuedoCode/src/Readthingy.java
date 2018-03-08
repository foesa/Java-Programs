import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Readthingy {
	public static void main(String[]args) {
			ArrayList<String> dictionary = new ArrayList<String>();
			try {
				BufferedReader reader = new BufferedReader(
						new FileReader("C:\\Users\\legua\\Downloads\\reviews.csv"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					dictionary.add(line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(dictionary.toString());
		}
	}

