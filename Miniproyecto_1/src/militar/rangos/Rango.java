package militar.rangos;
import militar.soldados.soldado;

public abstract class Rango extends soldado {
    protected int nivel;

    public Rango(String nombre, String id, int nivel) {
        super(nombre, id);
        this.nivel = nivel;
    }

    public abstract void realizarAccion();
}
