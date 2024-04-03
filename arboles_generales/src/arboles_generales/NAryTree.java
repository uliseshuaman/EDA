/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arboles_generales;

/**
 *
 * @author uahua
 * @param <E>
 */
public interface NAryTree<E> extends Tree<E> {
     /**Está definido para un árbol vacío y añade el elemento
      raiz y retorna una Position de ese nodo*/
    public Position<E> addRoot(E e);
    
     /**Añade un nuevo nodo como hijo de p */
    public Position<E> add(E e, Position<E> p);
    
     /**Añade un nuevo nodo como hijo de p y en la posición num de 
      la lista de los hijos de p*/
    public Position<E> add(E e, Position<E> p, final int num);
    
     /**Intercambia los elementos de ps1 y ps2 */
    public void swapElements(Position<E> ps1, Position<E> ps2);
    
    /** Elimina el nodo de ps y el subarbol que cuelga de él,
     es decir, ps como raiz y todos sus descendientes son eliminados*/
    public void remove(Position<E> ps);
    
     /**Crea un arbol ps como raiz y todas sus descendientes de ps */
    public NAryTree<E> subTree(Position<E> ps);
    
     /**Inserta tree como hijo de p
      Nota. 
        Sí p es null entonces raiz de tree será root*/
    public void attach(Position<E> p, NAryTree<E> tree);
    
}
