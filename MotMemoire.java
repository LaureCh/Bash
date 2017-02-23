import java.util.BitSet;

public class MotMemoire {
	private int adresse;
	private BitSet mot;
	
	public MotMemoire() {
		adresse=-1;
		mot=new BitSet(16);
	}
	
	public BitSet decimalToBinaire(int nb) {
		return BitSet.valueOf(new long[]{nb});
	}
	
	public String decimalToHexa(int nb) {
		return Integer.toHexString(nb);
	}
	
	public String decimalToLangage() {
		String res;
		int nb = getValeurMot() >> 12;
		if (nb == 1) {
			res = "SIN";
		}
		else if (nb == 4) {
			res = "CHA";
		}
		else if (nb == 6) {
			res = "ADD";
		}
		else if (nb == 7) {
			res = "SUB";
		}
		else if (nb == 5) {
			res = "STO";
		}
		else if (nb == 2) {
			res = "SSN";
		}
		else if (nb == 3) {
			res = "SSZ";
		}
		else if (nb == 11) {
			res = "DAR";
		}
		else if (nb == 8) {
			res = "ETL";
		}
		else if (nb == 9) {
			res = "OUL";
		}
		else if (nb == 10) {
			res = "OUX";
		}
		else if (nb == 0) {
			res = "NOP";
		}
		else {
			res = "???";
		}

		return res;
	}

	private int getValeurMot() {
		return mot.length();
	}
}
