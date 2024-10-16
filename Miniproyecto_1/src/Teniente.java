public class Teniente extends Rango implements OperacionesMilitares {
    private String unidad;
    private String misionAsignada;

    public Teniente(String nombre, String id, String unidad) {
        super(nombre, id, 2); // Nivel 2 para Teniente
        this.rango = "Teniente";
        this.unidad = unidad;
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está supervisando la unidad " + unidad + " en la misión: " + misionAsignada);
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
