/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVargas.ArbolBinario;
import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
         ArbolBinario A1 = new ArbolBinario(); //Mi arbol esta vacio
//         A1.insertar(80);
//         A1.insertar(60);
//         A1.insertar(90);
//         A1.insertar(100);
          
         LinkedList<Integer> L1 =  new LinkedList<>();
         L1.add(20);
         L1.add(40);
         L1.add(15);
         L1.add(6);
         L1.add(35);
         A1.postOrdenEjercicio(L1);
         
         A1.RecorrridoInOrden();
         System.out.println("");
         A1.RecorridoPostOrden();
         
         System.out.println("");
    }
}
