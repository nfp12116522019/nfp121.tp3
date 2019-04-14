package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un num√©ro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
       if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
      this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
    if (o == null) {
            throw new IllegalArgumentException("obj ne peut pas Ítre nul");
        }
        if (estPleine()) {
            throw new PilePleineException();
        }
         zone[ptr] = o;
        ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        ptr--;
        return zone[ptr];
    }
    

    public Object sommet() throws PileVideException {
          if (estVide()) {
            throw new PileVideException();
        }
        return zone[ptr - 1];
    }
    
    public int capacite() {
          return zone.length;
    }

    public int taille() {
         return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
       boolean equals = false;
        if (o instanceof Pile) {
            Pile pile = (Pile)o;
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            if (equals) {
                for (int i = ptr - 1; i >= 0; i--) {
                    
                    Object a = zone[i], b = pile.zone[i];
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
        }
        return equals;
    }

    

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
         StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            Object item = zone[i];
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
}
    
