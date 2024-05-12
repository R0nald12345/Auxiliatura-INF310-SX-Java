/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVacapinto.ArbolMVias;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */
public class NodoMVias<K, V> {

    //Atributos
    private List<K> listaDeClaves;
    private List<V> listaDeValores;
    private List<NodoMVias<K, V>> listaDeHijos;

    //constructor, Orden = Nro de Hijos
    public NodoMVias(int orden) {
        listaDeClaves = new LinkedList<>();
        listaDeValores = new LinkedList<>();
        listaDeHijos = new LinkedList<>();
        for (int i = 0; i < orden - 1; i++) {
            listaDeHijos.add(null);
            listaDeClaves.add(null);
            listaDeValores.add(null);
        }
    }

    //2do Contructor
    public NodoMVias(int orden, K primerClave, V primerValor) {
        this(orden);
        this.listaDeClaves.set(0, primerClave);
        this.listaDeValores.set(0, primerValor);

    }

    public static boolean esNodoVacio(NodoMVias nodo) {
        return nodo == null;
    }

    public K getClave(int posicion) {
        return this.listaDeClaves.get(posicion);
    }

    public void setClave(int posicion, K clave) {
        this.listaDeClaves.set(posicion, clave);
    }

    public V getValor(int posicion) {
        return this.listaDeValores.get(posicion);
    }

    public void setValor(int posicion, V valor) {
        this.listaDeValores.set(posicion, valor);
    }

    public NodoMVias<K, V> getHijo(int posicion) {
        return this.listaDeHijos.get(posicion);
    }

    public void setHijo(int posicion, NodoMVias<K, V> nuevoNodo) {
        this.listaDeHijos.set(posicion, nuevoNodo);
    }

    public boolean esClaveVacio(int posicion) {
        return this.listaDeClaves.get(posicion) == null;
    }

    public boolean esHijoVacio(int posicion) {
        return this.listaDeHijos.get(posicion) == null;
    }

    // .length()  ==> la cantidad de Datos que contiene mi vector
    public boolean esHoja() {
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                return false;
            }
        }
        return true;
    }

    public int cantidadDeHijosNoVacios() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadDeClavesNoVacias() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (!this.esClaveVacio(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public boolean estanClaveLlenas() {
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.esClaveVacia(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean esClaveVacia(int posicion) {
        return this.listaDeClaves.get(posicion) == datoVacio();
    }

    public static Object datoVacio() {
        return null;
    }
    
    public static NodoMVias nodoVacio() {
        return null;
    }

}
