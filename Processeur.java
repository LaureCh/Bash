/* Développeur principal : Laure
 */

public class Processeur {
	private Accumulateur acc;
	private CompteurOrdinal co;
	private RegistreInstruction ri;
	private Memoire mem;
	
	
	public Processeur(int taille){  //constructeur
		acc = new Accumulateur();
		co = new CompteurOrdinal();
		ri = new RegistreInstruction();
		mem = new Memoire(taille);
	}
	
	//Methodes pour accumulateur
	public int getACC() {
		int valeur=acc.getACC();		
		return valeur;
	}

	public void setACC(int i) {
		 acc.setACC(i);;
	}

	//Methodes pour compteur ordinal
	public int getCO() {
		int indice = co.getIndice();
		return indice;
	}

	public void setCO(int i) {
		co.setIndice(i);
	}
	
	//Methodes pour Registre d'instructions
	public Ligne getRI() {
		return ri.getRI();
	}

	public void setRI(Ligne l) {
		ri.setRI(l);
	}
	
	public Ligne setRI(int i){//?? juste pour répondre à p.setRI(0x4006)
		ri.setRI(i); 
	}

	public Memoire getMemoire() {
		return mem;
	}

	public void setMem(Memoire mem) {
		this.mem = mem;
	}
	
	public void chargerProchaineInstruction(){
		int indice = co.getIndice(); 
		Ligne ligne = mem.getLigne(indice);//va chercher dans la mémoire la ligne correspondante à l'indice récupéré dans le compteur ordinal
		setRI(ligne); // envoie la ligne dans le registre d'instruciton
	}
	
	public void executerInstruction(){
		Ligne l = ri.getRI(); 
		int instruction = l.getOperateurInt(); // récupère la valeur de l'opérateur de la ligne chargée dans le ri
	
		//execution selon la valeur récupérée = pê à passer en switch ?
		//fonctionnelle
		if (instruction == 1) { //SI : saut inconditionnel
			co.setIndice(ri.getRI().getOperateurInt());
		}
		if (instruction == 2) { //SSN : si acc a une valeur négative alors on charge la valeur operande dans le compteur ordinal
			 if ((acc.getACC())<0){ //Strictement inférieure à 0 ou =0?
				 co.setIndice(ri.getRI().getOperateurInt());
			 }
		}
		if (instruction == 3) { //SSZ : si acc a une valeur =0 alors on charge la valeur operande dans le compteur ordinal
			if ((acc.getACC())==0){ 
				 co.setIndice(ri.getRI().getOperateurInt());
			 }
		}
		if (instruction == 4) { //CHA : charge la valeur de l'opérande dans l'accumulateur
			acc.setACC(ri.getRI().getOperandeInt());
		}
		
		if (instruction == 6) { //ADD : additionne opérande + valeur dans l'acc
			acc.setACC((acc.getACC())+(ri.getRI().getOperateurInt()));
		}
		if (instruction == 7) {//SUB : soustrait valeur dans acc - opérande
			acc.setACC((acc.getACC())-(ri.getRI().getOperateurInt()));;
		}
		if (instruction == 11) {//DAR : décalage arithmétique = on met dans acc, la valeur de acc x 2(opérande)
			int i = (int)Math.pow(2.0,(ri.getRI().getOperandeInt())); 
			acc.setACC(i);
		}
		/*méthode à compléter
		if (instruction == 5) {//STO : charge la valeur de l'accumulateur dans une valeur x de la mémoire
			acc.getACC(mem.setOctet(adr, val));
		}
		if (instruction == 8) {//ETL = ET LOGIQUE valeurACC & operande //à définir, pour savoir si & ou && en opérateur
			acc.setACC(acc.getACC() & ri.getRI().getOperandeInt()); //
		}
		if (instruction == 9) { //OUL = OU LOGIQUE, mm question entre | ou ||
			acc.setACC(acc.getACC() | ri.getRI().getOperandeInt());
		}
		if (instruction == 10) {//OUX = OU EXCLUSIF
			acc.setACC(acc.getACC() ^ ri.getRI().getOperandeInt());
		}
		if (instruction == 0) {//NOP : Non opération = arrêt si opérande = 0. Que veut dire Arrêt ?? On stoppe l'exécution ou on passe à la ligne suivante?
			if ((acc.getACC())==0){ 	 
			 }
		}
		Est-ce qu'on créer un cas où la valeur n'est pas comprise ? 
		*/		
	}
	}
	

}
