public class Capitan extends Rango {
    private int cantidadSoldadosBajoSuMando;

    public Capitan(String nombre, String id, int cantidadSoldadosBajoSuMando) {
        super(nombre, id, 3);
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
        this.rango = "Capitán";
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está coordinando misiones con " + cantidadSoldadosBajoSuMando + " soldados bajo su mando.");
    }
}
