package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille < 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.capacite = taille;
    }

    /**
     * Cr�e une nouvelle instance de {@see question2.Pile2} avec une "taille maximale" par d�faut � {@value question3.PileI#CAPACITE_PAR_DEFAUT}.
     */
    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
    /**
     * Retourne la taille actuelle de la pile.
     * 
     * @return La taille de la pile. 
     */
    public int taille() {
        return stk.size();
    }
    
    /**
     * Retourne la capacit� maximale de la pile.
     * 
     * @return La capacit� de la pile.
     */
    public int capacite() {
        return capacite;
    }

    /**
     * Ajoute un objet en haut de la pile.
     * 
     * @param obj Objet � ajouter.
     */
    public void empiler(T obj) throws PilePleineException{
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (estPleine()) {
            throw new PilePleineException();
        }

        stk.push(obj);
    }

    /**
     * Retire et retourne l'objet au sommet de la pile.
     * 
     * @return L'objet au sommet de la pile.
     */
    public T depiler() throws PileVideException{
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.pop();
    }

    /**
     * Retourne l'objet au sommet de la pile sans le retirer.
     * 
     * @return L'objet au sommet de la pile.
     */
    public T sommet() throws PileVideException{
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }
    
    /**
     * D�finit si la pile est pleine.
     * 
     * @return Un bool�en indiquant si la pile est pleine.
     */
    public boolean estPleine() {
        return stk.size() == capacite;
    }
    
    /**
     * D�finit si la pile est vide (ne contient aucun �l�ment).
     * 
     * @return Un bool�en indiquant si la pile est vide.
     */
    public boolean estVide() {
        return stk.isEmpty();
    }
        
    /**
     * Compare l'�galit� de deux piles.
     * 
     * @return Un bool�en indiquant l'�galit� ou non de des deux piles.
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof Pile2) {
            Pile2<T> pile = (Pile2<T>)obj;
            
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            for (int i = stk.size() - 1; i >= 0; i--) {
                
                T a = stk.elementAt(i), b = pile.stk.elementAt(i);
                if (a != null) {
                    equals &= a.equals(b);
                } else {
                    equals = false;
                }                   
                if (!equals) {
                    
                }
            }
        }
        return equals;
    }
    
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = stk.size() - 1; i >= 0; i--) {
            Object item = stk.elementAt(i);
            if (item != null) {
                sb.append(item.toString());
                if (i > 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }}