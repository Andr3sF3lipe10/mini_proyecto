package militar.rangos;

import militar.soldados.soldado;

public abstract class Rango extends soldado {
    protected int nivel;

    public Rango(String nombre, String id, int nivel) {
        super(nombre, id);
        this.nivel = nivel;
    }

    public abstract String realizarAccion();

    public abstract String asignarMision(String mision);

    // Método común a sobrescribir en clases derivadas
    public void prepararseParaMision() {
        System.out.println("Preparándose para la misión.");
    }
}
