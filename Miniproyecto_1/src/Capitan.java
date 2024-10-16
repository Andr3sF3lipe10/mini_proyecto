public class Capitan extends Rango implements OperacionesMilitares {
    private int cantidadSoldadosBajoSuMando;
    private String misionAsignada;

    public Capitan(String nombre, String id, int cantidadSoldadosBajoSuMando) {
        super(nombre, id, 3); // Nivel 3 para Capitán
        this.rango = "Capitán";
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está coordinando la misión: " + misionAsignada + " con " + cantidadSoldadosBajoSuMando + " soldados.");
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