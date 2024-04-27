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

//        arbolPrueba.insertarRecursivo(21, "Ronald");
        arbolPrueba.insertarRecursivo(45, "Juan");
        arbolPrueba.insertarRecursivo(23, "Felipe");
        arbolPrueba.insertarRecursivo(65, "Felipe");
        arbolPrueba.insertarRecursivo(2, "Ronald");
        arbolPrueba.insertarRecursivo(38, "Felipe");
        arbolPrueba.insertarRecursivo(52, "Felipe");
        arbolPrueba.insertarRecursivo(96, "Felipe");
        arbolPrueba.insertarRecursivo(7, "Fe");
        arbolPrueba.insertarRecursivo(48, "Fel");
        arbolPrueba.insertarRecursivo(6, "Fel");
        
        
        System.out.println(arbolPrueba.recorridoEnPostOrden());
//        System.out.println("Cantidad de Nodos: " + arbolPrueba.cantidadNodos());
//        System.out.println("Cantidad de Hojas: " + arbolPrueba.cantidadHojas());
//        System.out.println("Existe el valor 13:  " + arbolPrueba.verificarExiste(13));
        
        System.out.println("Cantidad de Numeros Pares: " + arbolPrueba.contarNumerosPares());
        arbolPrueba.recorridoInOrdenR();
        System.out.println("");
        arbolPrueba.recorridoPreOrdenR();
        System.out.println("");
        arbolPrueba.recorridoPostOrdenR();
        System.out.println("");
        
        System.out.println("Obtener la Altura de Arbol: " + arbolPrueba.obtenerAlturaArbol());
        System.out.println("Cantidad Nodos incompletos: " + arbolPrueba.obtenerCantidadNodosIncompletos());
        System.out.println("-------------------------------");
        arbolPrueba.recorridoInOrdenR();
        System.out.println("");
        arbolPrueba.eliminarDatoXDeUnArbol(6);
        System.out.println("");
        arbolPrueba.recorridoInOrdenR();
        
    }
}
