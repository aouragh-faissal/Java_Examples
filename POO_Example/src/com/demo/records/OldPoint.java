package com.demo.records;

import java.util.Objects;

public class OldPoint {

    /*
     *  Deux attributs finaux ne pouvant plus être
     *  modifiés après la construction de l'instance. 
     */
    private final double x;
    private final double y;
    
    /*
     * Un constructeur de classe avec une délégation 
     * à un second constructeur acceptant deux flottants.
     */
    public OldPoint() {
        this( 0, 0 );
    }
    
    /*
     * Un second constructeur permettant de fixer l'état
     * initial des deux attributs de la classe.
     */
    public OldPoint( double x, double y ) {
        this.x = x;
        this.y = y;
    }
    
    /*
     * Deux getters pour l'accès à l'état de vos points.
     * Les setters ne sont pas disponibles afin de garantir
     * l'aspect immuable (readonly) de vos objets.
     */
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    /*
     * Cette méthode est utile si vous souhaitez utiliser des instances 
     * de points dans une table associative (type Hashtable ou HashMap).
     * Elle permettra de calculer le "hashcode" (en gros, la position 
     * dans la collection) d'un point donné.
     */

    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return Objects.hash(x, y);
    }
    
    /*
     * Cette méthode permettra de comparer deux instances Java et
     * d'indiquer si elles sont identiques ou non.
     */
    @Override
    public boolean equals( Object object ) {
        if ( this == object ) {
            return true;
        } else if ( object instanceof OldPoint ) {
        	OldPoint other = (OldPoint) object;
            return x == other.x && y == other.y;
        } else {
            return false;
        }
    }
    
    /*
     * Pour calculer la chaîne de caractères de représentative d'un point.
     */
    @Override public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
    
    // TODO: imaginez d'autres méthodes relatives à la gestion de vos points.
}
