public class Coronel extends Rango implements OperacionesMilitares {
    private String estrategia;
    private String misionAsignada;

    public Coronel(String nombre, String id, String estrategia) {
        super(nombre, id, 4); // Nivel 4 para Coronel
        this.rango = "Coronel";
        this.estrategia = estrategia;
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está implementando la estrategia: " + estrategia + " para la misión: " + misionAsignada);
    }

    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        System.out.println("Coronel " + nombre + " ha recibido la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("Coronel " + nombre + " reporta: Estrategia " + estrategia + " en ejecución para la misión " + misionAsignada + ".");
    }
}