/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvanceIngVacapinto.ArbolMVias;

import Excepciones.ExceptionOrdenInvalido;

/**
 *
 * @author USER
 */
public class ArbolMVias<K extends Comparable<K>, V> implements IArbolBusquedaMVias<K, V> {

    protected NodoMVias<K, V> raiz;
    protected int orden;
    protected int POSICION_INVALIDA = -1;

    public ArbolMVias() {
        this.orden = 3;
    }

    public ArbolMVias(int orden) throws ExceptionOrdenInvalido {
        if (orden < 3) {
            throw new ExceptionOrdenInvalido();
        }
        this.orden = orden;
    }

    protected void insertarClaveYValorEnNodo(NodoMVias<K, V> nodoActual, K claveAInsertar, V valorAInsertar) {
        int posicionDondeInsertar = getPosicionDondeInsertar(nodoActual, claveAInsertar);
        int posicionActual = nodoActual.cantidadDeClavesNoVacias();
        while (posicionActual > posicionDondeInsertar) {
            K claveActual = nodoActual.getClave(posicionActual - 1);
            V valorActual = nodoActual.getValor(posicionActual - 1);
            nodoActual.setClave(posicionActual, claveActual);
            nodoActual.setValor(posicionActual, valorActual);
            posicionActual--;
        }
        nodoActual.setClave(posicionDondeInsertar, claveAInsertar);
        nodoActual.setValor(posicionDondeInsertar, valorAInsertar);
    }

    protected int getPosicionDondeInsertar(NodoMVias<K, V> nodoActual, K claveAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    protected int getPosicionPorDondeBajar(NodoMVias<K, V> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esArbolVacio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (this.esArbolVacio()) { //en Caso del Arbol Vacio
            this.raiz = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
            return;
        }
        NodoMVias<K, V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            int posicionClaveExistente = this.getPosicionDeClave(nodoActual, claveAInsertar);
            if (posicionClaveExistente != POSICION_INVALIDA) {
                nodoActual.setValor(posicionClaveExistente, valorAInsertar);
                return; //nodoActual = NodoMVias.nodoVacio();
            } else if (nodoActual.esHoja()) {
                if (nodoActual.estanClaveLlenas()) {
                    int posicionPorDondeBajar = this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
                    NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                } else {
                    this.insertarClaveYValorEnNodo(nodoActual, claveAInsertar, valorAInsertar);
                }
                nodoActual = NodoMVias.nodoVacio(); //para romper el bucle
            } else {
                int posicionPorDondeBajar = this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
                if (nodoActual.esHijoVacio(posicionPorDondeBajar)) {
                    NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                    nodoActual = NodoMVias.nodoVacio();
                } else {
                    nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                }
            }

        }
    }

    protected int getPosicionDeClave(NodoMVias<K, V> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    @Override
    public int cantidadNodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadHojas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarExiste(K valorX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contarNumerosPares() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contarNumeroImpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoInOrdenR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoPreOrdenR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoPostOrdenR() {
        recorridoPostOrdenRecursivo(this.raiz);
    }

    private void recorridoPostOrdenRecursivo(NodoMVias<K, V> nodoActual) {
        //Que es un Arbol
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }

        //En el Padre 
        for (int i = 0; i < nodoActual.cantidadDeHijosNoVacios(); i++) {
            recorridoPostOrdenRecursivo(nodoActual.getHijo(i));
        }

        //
        recorridoPostOrdenRecursivo(nodoActual.getHijo(nodoActual.cantidadDeHijosNoVacios()));
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            System.out.print(nodoActual.getClave(i) + " ");
        }
    }

    @Override
    public int obtenerAlturaArbol() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerCantidadNodosIncompletos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*\
public void recorridoInOrden() {
    recorridoInOrdenRecursivo(this.raiz);
}

private void recorridoInOrdenRecursivo(NodoMVias<K, V> nodoActual) {
    if (NodoMVias.esNodoVacio(nodoActual)) {
        return;
    }

    for (int i = 0; i < nodoActual.cantidadDeHijosNoVacios(); i++) {
        recorridoInOrdenRecursivo(nodoActual.getHijo(i));
        if (i < nodoActual.cantidadDeClavesNoVacias()) {
            System.out.print(nodoActual.getClave(i) + " ");
        }
    }

    recorridoInOrdenRecursivo(nodoActual.getHijo(nodoActual.cantidadDeHijosNoVacios()));
}

 */
