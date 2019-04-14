package question2;



import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
	/** la liste des Maillons/Elements */
	private Maillon stk;
	/** la capacité de la pile */
	private int capacite;
	/** le nombre */
	private int nombre;

	/**
	 * Classe interne "statique" contenant chaque élément de la chaine c'est une
	 * proposition, vous pouvez l'ignorer !
	 */
	private static class Maillon implements Cloneable {
		private Object element;
		private Maillon suivant;
              
		public Maillon(Object element, Maillon suivant) {
			this.element = element;
			this.suivant = suivant;
			
		}
		public Maillon suivant() {
			return this.suivant;
		}

		public Object element() {
			return this.element;
		}

		public Object clone() throws CloneNotSupportedException {
			Maillon m = (Maillon) super.clone();
			m.element = element;
			return m;
		}
	}

	public Pile4(int taille) {
		if (taille <= 0)
			taille = CAPACITE_PAR_DEFAUT;
		this.stk = null;
		this.capacite = taille;
	}

	public Pile4() {
		this(PileI.CAPACITE_PAR_DEFAUT);
	}

	public void empiler(Object o) throws PilePleineException {
		if (estPleine()){
			throw new PilePleineException();}
			Maillon first=new Maillon(o,stk);
			stk=first;
			nombre++;
		
	}

	public Object depiler() throws PileVideException {
		if (estVide())
			throw new PileVideException();
			
		Object o = stk.element();
	         stk = stk.suivant();
		nombre--;
		return o;
	}

	public Object sommet() throws PileVideException {
		if (estVide()){
			throw new PileVideException();}
		return stk.element(); 
}
	public boolean estVide() {
		return stk==null;
	}

	
	public boolean estPleine() {
		return nombre==capacite; 
	}

	
	public String toString() {
         Maillon initial = stk;
        String s = "[";
        while (stk != null){
            s += (stk.element()==null)? "null":stk.element().toString();
            stk = stk.suivant();
            if(stk!=null) s+=", ";    
        }
        stk = initial;
        return s + "]";
    }
    

    
	 

	public boolean equals(Object o) {
	    boolean equals=false;
		if (o instanceof Pile4) {
			Pile4 pile = (Pile4)o;
			equals = capacite() == pile.capacite() && taille() == pile.taille();
			if (equals) {
                Maillon thisStk = stk, targetStk = pile.stk;
		while (thisStk != null && targetStk != null) {	
		    Object a = thisStk.element(), b = targetStk.element();
		    if (a != null) {
                 } else {
                        equals = false;
                    }
                    if (!equals) {
                       break;
                       
                    }

		}}
		return equals;
}

	public int capacite() {
		return this.capacite;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public int taille() {
		return nombre;
	}}