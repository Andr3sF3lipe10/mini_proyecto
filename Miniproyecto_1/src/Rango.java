public abstract class Rango extends soldado {
    protected int nivel;

    public Rango(String nombre, String id, String rango, int nivel) {
        super(nombre, id);
        this.rango = rango; // Sobrescribe el valor por defecto
        this.nivel = nivel;
    }

    public abstract void realizarAccion();
}