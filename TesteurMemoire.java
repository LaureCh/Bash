// responsable : Jérome Palaysi.

class TesteurMemoire extends Testeur{
    
    public static void main(String args[]){
	int taille=512;
	Memoire mem=new Memoire(taille);// taille en nombre de lignes
	

	int adresse=5;
	int valeur=23;
	//mem.setOctet(adresse,valeur);
	//tester(mem.getOctet(5)==23);
	
	//adresse=1;// "en octet"
	//valeur=1005;
	//mem.setMot(adresse,valeur);
	//tester(mem.getMot(1)==1005);
    }   
}
