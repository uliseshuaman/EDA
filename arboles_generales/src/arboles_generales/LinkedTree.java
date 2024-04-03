/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles_generales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author uahua
 * @param <E>
 */
public class LinkedTree<E> implements NAryTree<E> {
    private class TreeNode<N> implements Position<N>{
        private N elemento;
        private TreeNode<N> padre;
        private List<TreeNode<N>> hijos;
        
        public TreeNode(N elemento, TreeNode<N> padre, List<TreeNode<N>> listaHijos){
            this.elemento = elemento;
            this.padre = padre;
            this.hijos = listaHijos;
        }

        @Override
        public N getElement() {
            return this.elemento;
        }
        
        public void setElement(N elem){
            this.elemento = elem;
        }

        public TreeNode<N> getPadre() {
            return padre;
        }

        public void setPadre(TreeNode<N> padre) {
            this.padre = padre;
        }

        public List<TreeNode<N>> getHijos() {
            return hijos;
        }

        public void setHijos(List<TreeNode<N>> hijos) {
            this.hijos = hijos;
        }
        
        
    }// Fin de la clase TreeNode
    
    //Inicio del Arbol
    private TreeNode<E> root;
    
    //Se crea vacío por comodidad puesto que tiene métodos que añaden el nodo root
    private LinkedTree(){
        this.root = null;
    }
    
    //Para que este método añada root el arbol tendrá que estar vacío
    @Override
    public Position<E> addRoot(E e) {
        ArrayList<TreeNode<E>> hijos = new ArrayList<>();
        TreeNode<E> nodo = new TreeNode<>(e,null, hijos);
        this.root = nodo;
        return nodo;
    }
    
    private TreeNode<E> checkPosition(Position<E> p){
        if(p == null || !(p instanceof TreeNode)){
            throw new RuntimeException("El Position es null o inválida");
        }else{
        TreeNode<E> aux = (TreeNode<E>) p;
        return aux;
        }
    }

    @Override
    public Position<E> add(E e, Position<E> p) {
        TreeNode<E> padre = checkPosition(p);
        List<TreeNode<E>> hijos = new ArrayList<>();
        TreeNode<E> nuevo = new TreeNode<>(e, padre, hijos);
        nuevo.setPadre(padre);
        if(padre.getHijos() == null){
            List<TreeNode<E>> ls = new ArrayList<>();
            ls.add(nuevo);            
            padre.setHijos(ls);
            
        }else{
            padre.getHijos().add(nuevo);
        }
        return nuevo;
    }

    @Override
    public Position<E> add(E e, Position<E> p, int num) {
        TreeNode<E> padre = checkPosition(p);
        List<TreeNode<E>> ls = new ArrayList<>();
        TreeNode<E> nuevo = new TreeNode<>(e,padre,ls);
        nuevo.setPadre(padre);
        padre.getHijos().add(num, nuevo);
        return nuevo;
    }

    @Override
    public void swapElements(Position<E> ps1, Position<E> ps2) {
       TreeNode<E> nodo1 = checkPosition(ps1);
       TreeNode<E> nodo2 = checkPosition(ps2);
       E e = nodo1.getElement();
       nodo1.setElement(nodo2.getElement());
       nodo2.setElement(e);
    }

    @Override
    public void remove(Position<E> ps) {
        TreeNode<E> actual = checkPosition(ps);
        TreeNode<E> padre = actual.padre;
        actual.setPadre(null);
        padre.getHijos().remove(actual);       
    }

    @Override
    public NAryTree<E> subTree(Position<E> ps) {
        this.remove(ps);
        NAryTree<E> nuevo = new LinkedTree<>();
        TreeNode<E> root = checkPosition(ps);
        root.setPadre(null);
        //falta
        
        return nuevo;
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> tree) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Position<E> root() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Position<E> parent(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Position<E> replace(Position<E> p, E elem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isInternal(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isRoot(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
