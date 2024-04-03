package arboles_generales;


/**
 *
 * @author uahua
 */
public interface Tree<E> extends Iterable<Position<E>>{
    /** Check if the Tree is empty*/
    public boolean isEmpty();  
    
    /** Return the position of root of the tree*/
    public Position<E> root();
    
     /**Return the parent of "p" */
    public Position<E> parent (Position<E> p );
    
     /**Change "element" of the "p" for elem */    
    public Position<E> replace(Position<E> p, E elem );
    
     /**Retur Iterable of Positions */
    public Iterable<? extends Position<E>> children(Position<E> v);
    
     /** Check if the node of p is internal */
    public boolean isInternal(Position<E> p);
    
     /**Check if the node os p is leaf */
    public boolean isLeaf(Position<E> p);
    
     /**Check is the node is root */
    public boolean isRoot(Position<E> p);
    
}
