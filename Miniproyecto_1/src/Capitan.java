public class Capitan extends soldado implements OperacionesMilitares {
    private int cantidadSoldadosBajoSuMando;
    private String misionAsignada;

    public Capitan(String nombre, String id, int cantidadSoldadosBajoSuMando) {
        super(nombre, id);
        this.rango = "Capitán";
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        System.out.println("Capitán " + nombre + " ha recibido la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("Capitán " + nombre + " reporta: Preparado para coordinar " + misionAsignada + " con " + cantidadSoldadosBajoSuMando + " soldados.");
    }
}