public class Coronel extends soldado implements OperacionesMilitares {
    private String estrategia;
    private String misionAsignada;

    public Coronel(String nombre, String id, String estrategia) {
        super(nombre, id);
        this.rango = "Coronel";
        this.estrategia = estrategia;
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