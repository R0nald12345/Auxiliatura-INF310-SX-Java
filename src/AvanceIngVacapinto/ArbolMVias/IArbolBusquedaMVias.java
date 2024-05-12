/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVacapinto.ArbolMVias;

import AvanceIngVacapinto.Arbol.NodoBinario;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IArbolBusquedaMVias<K extends Comparable<K>,V> {
    void vaciar();
    boolean esArbolVacio();
    void insertar(K clave, V valor);
     
    int cantidadNodos();
    int cantidadHojas();
    boolean verificarExiste(K valorX);
    
    
    int contarNumerosPares();
    int contarNumeroImpar();
    void recorridoInOrdenR();
    void recorridoPreOrdenR();
    void recorridoPostOrdenR();
    int obtenerAlturaArbol();
    int obtenerCantidadNodosIncompletos();
}
