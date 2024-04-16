/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVacapinto.Arbol;

/**
 *
 * @author USER
 */
public class Main {
    
    public static void main(String[] args) {
        IArbolBusqueda<Integer, String> arbolPrueba = new ArbolBinarioBusqueda<>();


//
//        arbolPrueba.insertar(21, "Jeans");
//        arbolPrueba.insertar(13, "Amarillo");
//        arbolPrueba.insertar(33, "Negro");
//
//       
//        System.out.println(arbolPrueba);
//        System.out.println("Recorrido en PostOrden: " + arbolPrueba.recorridoEnPostOrden());
//        

        arbolPrueba.insertarRecursivo(21, "Ronald");
        arbolPrueba.insertarRecursivo(13, "Juan");
        arbolPrueba.insertarRecursivo(33, "Felipe");
        
        System.out.println(arbolPrueba.recorridoEnPostOrden());
        System.out.println("Cantidad de Nodos: " + arbolPrueba.cantidadNodos());
        System.out.println("Cantidad de Hojas: " + arbolPrueba.cantidadHojas());
        System.out.println("Existe el valor 13:  " + arbolPrueba.verificarExiste(13));
    }
}
