public class Teniente extends Rango {
    private String unidad;

    public Teniente(String nombre, String id, String unidad) {
        super(nombre, id, 2); 
        this.unidad = unidad;
        this.rango = "Teniente";
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está supervisando a los soldados en la unidad " + unidad + ".");
    }
}
