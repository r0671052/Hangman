package domain;

public class HangMan {
	private Speler speler;
	private HintWoord hintwoord;
	private TekeningHangMan tekening;
	private WoordenLijst woordenlijst;
	private HintWoord alfabet;
	
	public HangMan(Speler speler, WoordenLijst woordenlijst){
		setSpeler(speler);
		if(woordenlijst==null) throw new DomainException("Ongeldige woordenlijst");
		this.woordenlijst = woordenlijst;
		setTekening();
		setHintWoord(woordenlijst);
		setAlfabet();
	}
	
	public String getHint(){
		return this.hintwoord.toString();
	}
	
	public String getWoord(){
		return this.hintwoord.getWoord();
	}
	
	public Speler getSpeler(){
		return speler;
	}
	
	private void setTekening(){
		//Naam tekening wordt de naam van de speler
		tekening = new TekeningHangMan(speler.getNaam());
	}
	
	public TekeningHangMan getTekening(){
		
		return tekening;
	}
	
	public void raad(char letter){
		boolean gok = this.hintwoord.raad(letter);
		this.alfabet.raad(letter);
		if(gok==false){
			tekening.zetVolgendeZichtbaar();
		}
	}
	
	public boolean isGameOver(){
		//If aantal onzichtbaar == 0 -> return true anders false
		return (tekening.getAantalOnzichtbaar()==0) ? true : false;
	}
	
	public boolean isGewonnen(){
		//Gewonnen is true als hintwoord geraden
		return (hintwoord.isGeraden()) ? true: false;
	}
	
	private void setSpeler(Speler speler) {
		if(speler==null) throw new DomainException("Ongeldige Speler.");
		this.speler = speler;
	}
		
	private void setHintWoord(WoordenLijst woordenlijst){
		this.hintwoord = new HintWoord(woordenlijst.getRandomWoord());
	}
	
	public void resetGame(){
		setHintWoord(woordenlijst);
		setAlfabet();
		tekening.reset();
		
	}
	
	private void setAlfabet(){
		alfabet = new HintWoord("abcdefghijklmnopqrstuvwxyz");
	}
	
	public String getAlfabet(){
		return alfabet.toString();
	}
	
}
