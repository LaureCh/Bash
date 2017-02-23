public class TesteurPrincipal extends Testeur{

    public static void main (String[] args){

	Machine m=new Machine();
	//m.chargerProgramme("../executables/prog-cible1.orf");
	int mem[]={0x10,0x05};
	//m.setMemoire({0x10, 0x05, 0x00, 0x1b, 0x00, 0x2a, 0x00, 0x1e, 0x00, 0x00, 0x40, 0x01, 0x60, 0x02, 0x70, 0x03, 0x50, 0x04, 0x00, 0x00});
	m.setMemoire(mem);
	m.executerToutLeProgramme();
	tester(m.accumulateur()==39);
	   
	m.chargerProgramme("../executables/prog-cible2.orf");
	m.executerToutLeProgramme();
	if (m.accumulateur()==42)
	    System.out.println("OK");
	else 
	    System.out.println("ECHEC");
    }
}
