public class SoldadoRaso extends Rango implements OperacionesMilitares {
    private String misionAsignada;

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id, 1); // Nivel 1 para Soldado Raso
        this.rango = "Soldado Raso";
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está siguiendo órdenes en la misión: " + misionAsignada);
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