public class Teniente extends soldado implements OperacionesMilitares {
    private String unidad;
    private String misionAsignada;

    public Teniente(String nombre, String id, String unidad) {
        super(nombre, id);
        this.rango = "Teniente";
        this.unidad = unidad;
    }

    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        System.out.println("Teniente " + nombre + " ha recibido la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("Teniente " + nombre + " reporta: Unidad " + unidad + " lista para la misión.");
    }
}
