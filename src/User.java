import java.util.ArrayList;

public class User {
	
	public static ArrayList<User> users = new ArrayList<>();
	
	private int brRacuna;
	private String imeRacuna;
	private double iznosRacuna;
	
	public User(int brRacuna, String imeRacuna, double iznosRacuna){
		this.brRacuna = brRacuna;
		this.imeRacuna = imeRacuna;
		this.iznosRacuna = iznosRacuna;
		users.add(this);
	}
	
	@Override
	public String toString() {
		return "Broj racuna: " + brRacuna + ", ime: " + imeRacuna + ", iznos na racunu: " + iznosRacuna;
	}
	
	public void uplata(double iznos) {
		this.iznosRacuna += iznos;
	}
	
	public void isplata(double iznos) {
		if(this.iznosRacuna >= iznos) {
			this.iznosRacuna -= iznos;
			System.out.println("Izvukli ste " + iznos);
		} else {
			System.out.println("Nemate dovoljno novca na racunu!");
		}
	}
	
	//Getters and Setters
	public static ArrayList<User> getUsers() {
		return users;
	}
	
	public int getBrRacuna() {
		return brRacuna;
	}

	public void setBrRacuna(int brRacuna) {
		this.brRacuna = brRacuna;
	}

	public String getImeRacuna() {
		return imeRacuna;
	}

	public void setImeRacuna(String imeRacuna) {
		this.imeRacuna = imeRacuna;
	}

	public double getIznosRacuna() {
		return iznosRacuna;
	}

	public void setIznosRacuna(double iznosRacuna) {
		this.iznosRacuna = iznosRacuna;
	}
	
}
