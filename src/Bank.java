import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
	
	static Scanner input = new Scanner(System.in);
	
	public static void upis() throws IOException {
		Path path = Paths.get("users.txt");
		BufferedWriter writer = Files.newBufferedWriter(path);
		
		for (User e : User.getUsers()) {
			writer.write(e.getBrRacuna() + " ");
			writer.write(e.getImeRacuna() + " ");
			writer.write(String.valueOf(e.getIznosRacuna()));
			writer.newLine();
		}
		writer.close();
	}
	
	public static void ispis() throws IOException {
		Path path = Paths.get("users.txt");
		BufferedReader reader = Files.newBufferedReader(path);
		String line;
		
		while ((line = reader.readLine()) != null) {
			String[] v = line.split(" ");
			
			User user = new User(Integer.parseInt(v[0]), v[1], Double.parseDouble(v[2]));
		}
		reader.close();
		
	}
	
	public static void makeUser() throws IOException {
		
		boolean checker = true;
		double iznosRacuna = 0;
		int brRacuna = 0;
		
		do {
			try {
				System.out.println("Unesite broj racuna: ");
					brRacuna = input.nextInt();
				checker = false;
			} catch (InputMismatchException e) {
				System.out.println("Pogresan unos!");
				input.nextLine();
			}
		} while(checker);
		
		System.out.println("Unesite ime racuna: ");
		String imeRacuna = input.next();
		
		
		do {
			try {
				System.out.println("Unesite iznos na racunu: ");
					iznosRacuna = input.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Unijeli ste pogresan iznos!");
			input.nextLine();
		} 
			
		} while(checker);
		
		
		
		User user = new User(brRacuna, imeRacuna, iznosRacuna);
		System.out.println("Racun je kreiran!");
		
	}
	
	static int posiljaoc, primaoc;
	static double iznos;
	
	public static void transakcija() {
		
		boolean checker = true;
		
		do {
			try {
				System.out.println("Broj racuna posiljaoca: ");
				posiljaoc = input.nextInt();
				System.out.println("Broj racuna primaoca: ");
				primaoc = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Pogresan unos!");
				input.nextLine();
			}
			
			
		} while(checker);
		
		while(!provjeraBroja(posiljaoc)) {
			System.out.println("Racun je postoji. Pokusajte ponovo: ");
			posiljaoc = input.nextInt();
		}
		while(!provjeraBroja(primaoc)) {
			System.out.println("Racun ne postoji. Pokusajte ponovo: ");
			primaoc = input.nextInt();
		}
		
		do {
			try {
				System.out.println("Unesite iznos novca za transfer: ");
				iznos = input.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Greska pri unosu!");
				input.nextLine();
			}
			} while(checker);
		
		int brPosiljaoca = brRacuna(posiljaoc);
		int brPrimaoca = brRacuna(primaoc);

		double stanjePosiljaoc = User.getUsers().get(posiljaoc).getIznosRacuna();
		double stanjePrimaoc = User.getUsers().get(primaoc).getIznosRacuna();

		if (stanjePosiljaoc < iznos) {
			System.out.println("Nema dovoljno novca za transakciju, pokušajte sa manjim iznosom: ");
			iznos = input.nextDouble();
		}

		User.getUsers().get(posiljaoc).setIznosRacuna(stanjePosiljaoc - iznos);
		User.getUsers().get(primaoc).setIznosRacuna(stanjePrimaoc + iznos);

		System.out.println("Transakcija uspiješno završena.");

		
		
		
		
	}
	
	public static int brRacuna(int brRacuna) {
		for (User e : User.getUsers()) {
			if (brRacuna == e.getBrRacuna()) {
				int broj = User.getUsers().indexOf(e);
				return broj;
			}
		}
		return brRacuna;
	}
	
	
	
	public static boolean provjeraBroja(int brRacuna) {
		for (User e : User.users) {
			if (brRacuna == e.getBrRacuna()) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean provjeraRacuna(int brRacuna) {
		for (User e : User.users) {
			if (brRacuna == e.getBrRacuna() || brRacuna < 0) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
}
