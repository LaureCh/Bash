//developpeur principal : Diana

public class Ligne {
	private byte[] ligne;
	
	public Ligne() {
		ligne=new byte[16];
	}

	public byte[] getLigne(){
		return ligne;
	}

	// returne l'operateur dans un tableau (cases de 0 à 3)
	public byte[] getOperateur() {
		byte[] operateur = {this.ligne[0],this.ligne[1],this.ligne[2],this.ligne[3]};
		return operateur;
	}

	// returne l'operande dans un tableau (cases de 4 à 15)
	public byte[] getOperande() {
		byte[] operande = new byte[12];
		for(int i=0; i<12; i++) {
			operande[i]=ligne[i+4];
		}
		return operande;
	}

	// conversion de l'operateur de binaire à décimal
	public int getOperateurInt() {
		byte[] operateur = getOperateur();
		int j=1, tmp=0;
		for(int i=0; i<operateur.length; i++) {
			tmp+=operateur[3-i]*j;
			j*=2;
		}
		return tmp;
	}

	// conversion de l'operande de binaire à décimal
	public int getOperandeInt() {
		byte[] operande = getOperande();
		int j=1, tmp=0;
		for(int i=0; i<operande.length; i++) {
			tmp+=operande[11-i]*j;
			j*=2;
		}
		return tmp;
	}
}