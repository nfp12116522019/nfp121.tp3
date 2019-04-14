package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

	private Vector<Object> v;

	public Pile3() {
	this(PileI.CAPACITE_PAR_DEFAUT);
	}

	public Pile3(int taille) {
		 if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
         v = new Vector<Object>(taille);
	}

	public void empiler(Object o) throws PilePleineException {
		 if (o == null) {
            throw new IllegalArgumentException("objet ne peut pas �tre nul");
        }
        if (estPleine()) {
            throw new PilePleineException();
        }
        v.add(o);
    }
	
	public Object depiler() throws PileVideException {
		Object last = sommet();
        v.remove(last);
        return last;
	}

	public Object sommet() throws PileVideException {
		 if (estVide()) {
            throw new PileVideException();
        }
        return v.lastElement();
    }
	

	public int taille() {
		  return v.size();
	}

	public int capacite() {
		return v.capacity();
	}

	public boolean estVide() {
		 return v.isEmpty();
	}
 
	public boolean estPleine() {
	return v.size() == v.capacity();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("[");
        for (int i = v.size() - 1; i >= 0; i--) {
            Object item = v.elementAt(i);
            if (item != null) {
                sb.append(item.toString());
                if (i > 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

	

	public boolean equals(Object o) {
	    boolean equals = false;
        if (o instanceof Pile3) {
            Pile3 pile = (Pile3)o;
           
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            for (int i = v.size() - 1; i >= 0; i--) {
               
                Object a = v.elementAt(i), b = pile.v.elementAt(i);
                if (a != null) {
                    equals &= a.equals(b);
                } else {
                    equals = false;
                }                   
                if (!equals) {
                    
                    break;
                }
            }
        }    
        return equals;
   }
	// fonction fournie
	public int hashCode() {
		return toString().hashCode();
	}
}

