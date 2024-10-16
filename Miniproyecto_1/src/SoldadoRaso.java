public class SoldadoRaso extends soldado {

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id);
    }

    public void realizarAccion() {
        System.out.println(nombre + " está siguiendo órdenes.");
    }
}
