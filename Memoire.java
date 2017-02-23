/* Développeur principal : Tupac.
Définition des méthodes setOctet, getOctet, getLigne et setLigne 
 */

//import java.util.Iterator;
//import java.util.Vector;

public class Memoire {

    //private Vector<MotMemoire> mots;
    private int [] tabmemoire;

// construction d'un objet de type Memoire : tableau représentant la mémoire et contenant des octets:	
    public Memoire (int taille){
	this.tabmemoire = new int [taille];
    }

  /*  public Memoire() {
	this.lignes = new Vector<MotMemoire>();
	//ajouter iterator
    }*/

    // méthode permettant de mettre une valeur (val) dans une case (adr) de la mémoire (tableau).
    public void setOctet(int adr, int val){
    
	if (adr > tabmemoire.length && adr<0){
	    System.out.println("Adresse " +adr+" non valide.");
	}
	else{
	    tabmemoire[adr]=val;
		System.out.println("La valeur " + val + " a été enregistrée à l'adresse de l'octet "+ adr+".\n");
    	}
    }
    // méthode permettant d'obtenir une valeur à partir de l'adresse passée en paramètre.
    public int getOctet(int i){
    
	if (i > tabmemoire.length &&i<0){
	    System.out.println("Adresse " + i +" non valide.");
	    return -1;
	}

	else{
	    return tabmemoire[i];
	}
    }

    /* 
       Je ne suis pas trop sur des méthodes créées ci-dessous car rien ne définit la longueur d'un mot. Donc elles fonctionnent sur la base de 1 mot = 2 octets. (Tupac)
       Ca m'étonnerait ! (Jérome)
    */

    public void setLigne(int adrligne, int valeurligne){
    
	if (adrligne > tabmemoire.length && adrligne<0){
	    System.out.println("Adresse " +adrligne+" non valide.");
	}
	else{
	    tabmemoire[adrligne]=valeurligne;
		System.out.println("La valeur " + valeurligne + " a été enregistrée à l'adresse de l'octet "+ adrligne+".\n");
    	}
    }

    public int getLigne(int caseligne){
    
	if (caseligne > tabmemoire.length &&caseligne<0){
	    System.out.println("Adresse " + caseligne +" non valide.");
	    return -1;
	}

	else{
	    return tabmemoire[caseligne];
	}


    }

}
