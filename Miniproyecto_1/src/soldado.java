public class soldado {
    protected String nombre;
    protected final String id;
    protected String rango;
    private static int contadorSoldados = 0;

    public soldado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.rango = "Soldado Raso"; // Valor por defecto
        contadorSoldados++;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Rango: " + rango);
    }

    public static int getContadorSoldados() {
        return contadorSoldados;
    }
}