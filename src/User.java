
public class User {
	
	private int brRacuna;
	private String imeRacuna;
	private double iznosRacuna;
	
	User(int brRacuna, String imeRacuna, double iznosRacuna){
		this.brRacuna = brRacuna;
		this.imeRacuna = imeRacuna;
		this.iznosRacuna = iznosRacuna;
	}
	
	@Override
	public String toString() {
		return "Broj racuna: " + brRacuna + ", ime: " + imeRacuna + ", iznos na racunu: " + iznosRacuna;
	}
	
	//Getters and Setters
	
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
