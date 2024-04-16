
package AvanceIngVargas;

public class Main {
    
    public static void main(String[] args) {
        
        ClaseListaSimple listaSimple = new ClaseListaSimple(); //Eh creado mi Objetp de mi ClaseLostaSimple
        listaSimple.insertarPrim(10);
        listaSimple.insertarPrim(9);
        listaSimple.insertarPrim(8);
        listaSimple.insertarPrim(7);
        
        System.out.println("Mostrar Lista");
        System.out.println(listaSimple.mostrarListaSimple());
        System.out.println("cantidad de Nodos: " + listaSimple.obtenerCantidadNodos());
        
    }
}
