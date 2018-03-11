import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class ATM {
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		boolean checker = true;
		int izbor = 0;
		do {
			System.out.println("Sta zelite?");
			System.out.println("1.Kreiranje racuna"
							+ "\n2.Transfer novca"
							+ "\n3.Ispis racuna"
							+ "\n4.Izlaz");
			
			izbor = input.nextInt();
			switch(izbor) {
				case 1: 
						Bank.makeUser();
						Bank.upis();
						ATM.main(args);
						break;
				case 2: 
						Bank.transakcija();
						Bank.upis();
						ATM.main(args);
						break;
				case 3: 
						Bank.ispis();
						ATM.main(args);
						break;
				case 4: 
						checker = false;
						break;
				default: break;
			}
			
		} while (checker);
		
		input.close();
		
	}
}
