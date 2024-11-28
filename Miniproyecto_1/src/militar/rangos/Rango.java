package militar.rangos;

import militar.operaciones.OperacionesMilitares;
import militar.soldados.soldado;;

/**
 * Clase abstracta que representa un rango militar.
 */
public abstract class Rango extends soldado implements OperacionesMilitares {
    protected int nivel;

    public Rango(String nombre, String id, int nivel) {
        super(nombre, id);
        this.nivel = nivel;
    }

    // Métodos Getter
    public int getNivel() {
        return nivel;
    }

    // Método común a sobrescribir en clases derivadas
    public void prepararseParaMision() {
        System.out.println("Preparándose para la misión.");
    }
}
