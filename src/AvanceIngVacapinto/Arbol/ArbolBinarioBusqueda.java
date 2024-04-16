/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVacapinto.Arbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author USER
 * @param <K>
 * @param <V>
 */

//Implementacion del Desarollo de mi codigio que hice (Declaré) en el Interface(IArbolBusqueda)
public  class ArbolBinarioBusqueda<K extends Comparable <K>,V> implements IArbolBusqueda<K, V> {

    protected NodoBinario<K,V> raiz;
    
    @Override
    public void vaciar() {
        this.raiz = (NodoBinario<K, V>)NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    public void insertar(K claveInsertar, V valorAInsertar) {
        if(claveInsertar == null){
            throw new IllegalArgumentException("Clave no puede ser Nula");
        }
        
        if(valorAInsertar == null){
            throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        
        if(this.esArbolVacio()){
            this.raiz = new NodoBinario<>(claveInsertar,valorAInsertar);
            return;
        }
        
        NodoBinario<K,V> nodoActual = this.raiz; //Puntero
        NodoBinario<K,V> nodoAnterior = (NodoBinario<K,V>)NodoBinario.nodoVacio(); // NOs retorna Null
        
        while(!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            nodoAnterior =  nodoActual;
            if(claveInsertar.compareTo(claveActual)< 0 ){
                nodoActual = nodoActual.getHijoIzquierdo();
            }else if (claveInsertar.compareTo(claveActual)> 0){
                nodoActual = nodoActual.getHijoDerecho();
            }else { //La clave existe, entonces reemplazar su valor
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
       
        //la clave, entonces debo crear un nodo, con la clave y valor a insertar
        //y el nodoAnterior es el padre de ese nuevo nodo
        NodoBinario<K,V>  nuevoNodo = new NodoBinario<>(claveInsertar,valorAInsertar);
        K claveDelPadre = nodoAnterior.getClave();
        if(claveInsertar.compareTo(claveDelPadre)<0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }

    @Override
    public boolean contiene(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido = new ArrayList<>();
        if (!this.esArbolVacio()) {
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            NodoBinario<K, V> nodoActual = this.raiz;
            meterEnPilaParaPostOrden(nodoActual, pilaDeNodos);
            while (!pilaDeNodos.isEmpty()) {
                nodoActual = pilaDeNodos.pop();
                //visita del nodo. En este caso estoy agragando la clave a la lista
                recorrido.add(nodoActual.getClave());

                if (!pilaDeNodos.isEmpty()) {
                    NodoBinario<K, V> nodoDelTope = pilaDeNodos.peek();
                    if (!nodoDelTope.esVacioHijoDerecho()
                            && nodoDelTope.getHijoDerecho() != nodoActual) {
                        meterEnPilaParaPostOrden(nodoDelTope.getHijoDerecho(), pilaDeNodos);
                    }
                }
            }
        }
        return recorrido;
    }

    //8.1
    private void meterEnPilaParaPostOrden(NodoBinario<K, V> nodoActual, Stack<NodoBinario<K, V>> pilaDeNodos) {
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            pilaDeNodos.push(nodoActual);
            if (!nodoActual.esVacioHijoIzquierdo()) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else {
                nodoActual = nodoActual.getHijoDerecho();

            }
        }
    }

    @Override
    public List<K> recorridoPorNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarRecursivo(K clave, V valor) {
        this.raiz = insertarRecursivoMask(this.raiz,clave,valor);
    }
    
    private NodoBinario<K,V> insertarRecursivoMask(NodoBinario<K,V> nodoRaiz, K nuevoClave,V nuevoValor){
        if(nodoRaiz == null){
             NodoBinario<K,V>  nuevoNodo = new NodoBinario<>(nuevoClave,nuevoValor);
             this.raiz = nuevoNodo;
             return raiz;
        }else{
            if(nodoRaiz.getClave().compareTo(nuevoClave) > 0){
                nodoRaiz.setHijoIzquierdo( insertarRecursivoMask(nodoRaiz.getHijoIzquierdo(),nuevoClave,nuevoValor));
            }else if(nodoRaiz.getClave().compareTo(nuevoClave) == 0){
                nodoRaiz.setValor(nuevoValor);
            }else{
                 nodoRaiz.setHijoDerecho(insertarRecursivoMask(nodoRaiz.getHijoDerecho(),nuevoClave,nuevoValor));
            }
            return nodoRaiz;
        }
        
    }

    @Override
    public int cantidadNodos() {
        return cantidadNodosMask(this.raiz);
    }
    
    private int cantidadNodosMask(NodoBinario<K,V> nodoRaiz){
        if(nodoRaiz == null){
            return 0;
        }
        if(nodoRaiz.esHoja()){
            return 1;
        }
        int i = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        int d = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        return i + d + 1;
    }

    @Override
    public int cantidadHojas() {
        return cantidadHojasMask(this.raiz);
    }
    
    private int cantidadHojasMask(NodoBinario<K,V> nodoRaiz){
        //1er Caso Si mi arbol es Bacio
        if(nodoRaiz == null){
            return 0;
        }
        
        //2do Caso Base 
        if(nodoRaiz.esHoja()){
            return 1;
        }
        //Caso General
        int i = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        int d = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        return i + d;
         
    }
    
    

    @Override
    public boolean verificarExiste(K valorX) { //ValorX = el valor Numerico que buscamos
        return verificarExisteMask(this.raiz, valorX);
    }
    
    private boolean verificarExisteMask(NodoBinario<K,V> nodoRaiz, K valorX){
        //1er Caso base
        if(nodoRaiz == null){
            return false;
        }
        
        if(nodoRaiz.getClave() == valorX){
            return true;
        }
        if(nodoRaiz.getClave().compareTo(valorX)> 0){
            return verificarExisteMask(nodoRaiz.getHijoIzquierdo(),valorX);
        }else{
            return verificarExisteMask(nodoRaiz.getHijoDerecho(), valorX);
        }
    }
}
