public class soldado {
    protected String nombre;
    protected String id;
    protected String rango;

    public soldado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.rango = "Soldado"; // Valor por defecto, puede ser sobreescrito
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Rango: " + rango);
    }
}