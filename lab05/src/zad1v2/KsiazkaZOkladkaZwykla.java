package zad1v2;

public class KsiazkaZOkladkaZwykla extends Decorator{
	public KsiazkaZOkladkaZwykla(Publikacja publikacja2) {
		super(publikacja2);
		// TODO Auto-generated constructor stub
	}
	String okladka = "okladka zwykla";
	
	
     @Override
    public String toString() {
        return super.toString() + '|' + okladka;
    }
}
     
