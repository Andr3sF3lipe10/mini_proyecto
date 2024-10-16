public class Coronel extends Rango {
    private String estrategia;

    public Coronel(String nombre, String id, String estrategia) {
        super(nombre, id, 4); // Nivel jerárquico 4
        this.estrategia = estrategia;
        this.rango = "Coronel";
    }

    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está implementando la estrategia: " + estrategia + ".");
    }
}
