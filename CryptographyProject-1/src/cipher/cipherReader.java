package cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cipherReader {
	
	public static String getCipher(String cipherFile) {
		String cipherText = null;
		try {
			File file = new File(cipherFile);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				cipherText = reader.nextLine();
			}
			reader.close();
		} catch(FileNotFoundException e) {	
			System.out.println("An error occurred");
			e.printStackTrace();
			
		}
		return cipherText;
	}
	
}
