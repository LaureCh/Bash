// responsable : Jérome

class TesteurProcesseur extends Testeur{
    
    public static void main(String[] args){
    	Processeur p=new Processeur(512);
    	p.setACC(0);
    	tester(p.getACC()==0);
	tester(p.getCO()==0);
	
	Memoire mem=p.getMemoire();

	// ADD X
	System.out.println("Test de l'instruction ADD X ... ");
	mem.setLigne(0,0x6038);// La valeur 0x6038 correspond à l'instruction ADD 56
	mem.setLigne(56,13);
	p.chargerProchaineInstruction();
	/*
	  ou:
	  ligne=mem.getLigne(p.getCO());
	  p.setRI(ligne);
	 */
	p.executerInstruction();
	tester(p.getACC()==13);

	// CHA X
	System.out.println("Test de l'instruction CHA X ... ");
	mem.setLigne(6,20);// mettre la valeur 20 à la ligne n°6
	p.setRI(0x4006);// 0x4006 correspond à l'instruction CHA 6
	p.executerInstruction();// exécuter l'instruction stockée dans le RI
	tester(p.getACC()==20);
    }
}
