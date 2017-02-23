public class RegistreInstruction {
	private Ligne lRI;
	//private boolean nonSignificatif;
	
	
	public RegistreInstruction(){
		lRI = new Ligne();
		//nonSignificatif = true;
	}

	public Ligne getRI() {
		return lRI;
	}

	public void setRI(Ligne lRI) {
		this.lRI = lRI;
	}
	
	public void setRI(int i){ //méthode crée juste pour traiter cette instruction p.setRI(0x4006);
		this.lRI = lRI; //il faut créer une méthode pour que le int reçu puisse être créé en ligne et être stocké en mémoire.
	}

}
