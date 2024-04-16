/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVargas;

/**
 *
 * @author Univ.Ronald 
 */

public class ClaseListaSimple {
    public ClaseNodo prim; //Primero //Punteros
    public ClaseNodo ult;  //ultimo  //Punteros
    public int cantElem;  //cantidad de Nodos
    
    //constructor
    public ClaseListaSimple(){
        this.prim = null;
        this.ult = null;
        this.cantElem = 0;
    }
    
     //Inserta el Nodo  al principio de la lista (No tiene Orden)
    public void insertarPrim(int x) {
        if (vacia()) {//en el caso que esta vacio
            ClaseNodo nuevo = new ClaseNodo(x, null); //estoy creando un nuevo Nodo (new)
            prim = ult = nuevo;
        } else { //en el aso que no esta vacio
            ClaseNodo nuevoNodo = new ClaseNodo(x, null);
            nuevoNodo.prox = prim;
            prim = nuevoNodo;
        }
        this.cantElem++;
    }
    
    public void insertarUlt(){
    }
    
    public boolean vacia(){
        return this.prim == null && this.ult == null;
    }
    
    public String mostrarListaSimple(){
        String datos = "[ ";
        ClaseNodo aux; //Puntero
        aux = this.prim;
        while(aux!= null){
            datos = datos + aux.elem + "->";
            aux = aux.prox;
        }
        datos = datos + "]";
        return datos;
    }

    public int obtenerCantidadNodos(){
        return this.cantElem;
    }
}
