package AvanceIngVargas.ArbolBinario;

import java.util.LinkedList;

public class ArbolBinario {

    public NodoBinario raiz;

    //Constructor
    public ArbolBinario() {
        this.raiz = null;
    }

    //insertar un dato x en el Arbol
    public void insertar(int x) {
        raiz = insertarRecursivo(raiz, x);
    }

    //Maton 
    private NodoBinario insertarRecursivo(NodoBinario nuevoRaiz, int x) {
        //caso Base
        if (nuevoRaiz == null) {
            NodoBinario nuevo = new NodoBinario(x);
            nuevoRaiz = nuevo;
            return nuevoRaiz;
//            return new NodoBinario(x);
        }
        //caso General
        if (x < nuevoRaiz.elem) {
            nuevoRaiz.izq = insertarRecursivo(nuevoRaiz.izq, x); //entra lado izquierdo
        } else {
            nuevoRaiz.der = insertarRecursivo(nuevoRaiz.der, x);
        }
        return nuevoRaiz;
    }

    public void RecorrridoInOrden() {
        RecorridoInOrdenRecursivo(raiz);
    }

    private void RecorridoInOrdenRecursivo(NodoBinario raizAuxiliar) {
        //Caso Base| Que pasa si mi arbol
        if (raizAuxiliar == null) {
            return;
        }
        //Caso General
        RecorridoInOrdenRecursivo(raizAuxiliar.izq);
        System.out.print(raizAuxiliar.elem + " ");
        RecorridoInOrdenRecursivo(raizAuxiliar.der);
    }
    
     public void RecorridoPostOrden() {
        RecorridoRecorridoPostOrdenRecursivo(raiz);
    }

    private void RecorridoRecorridoPostOrdenRecursivo(NodoBinario raizAuxiliar) {
        //Caso Base| Que pasa si mi arbol
        if (raizAuxiliar == null) {
            return;
        }
        //Caso General
        RecorridoInOrdenRecursivo(raizAuxiliar.izq);
        RecorridoInOrdenRecursivo(raizAuxiliar.der);
        System.out.print(raizAuxiliar.elem + " ");
    }


    public void postOrdenEjercicio(LinkedList lista1) {
        raiz = postOrdenEjercicioRecursivo(raiz, lista1);
    }

    private NodoBinario postOrdenEjercicioRecursivo(NodoBinario raizAuxiliar, LinkedList listaAux) {
        for (int i = 0; i < listaAux.size(); i++) {
            raizAuxiliar =  insertarRecursivo(raizAuxiliar,(Integer)listaAux.get(i));
        }

        return raizAuxiliar;
    }
    
    

    public static void main(String[] args) {
        ArbolBinario A1 = new ArbolBinario(); //Mi arbol esta vacio
    }

}
