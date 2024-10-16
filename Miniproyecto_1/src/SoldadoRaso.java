public class SoldadoRaso extends soldado implements OperacionesMilitares {
    private String misionAsignada;

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id);
        this.rango = "Soldado Raso";
    }

    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        System.out.println("Soldado Raso " + nombre + " ha recibido la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("Soldado Raso " + nombre + " reporta: En posición y listo para la misión.");
    }
}