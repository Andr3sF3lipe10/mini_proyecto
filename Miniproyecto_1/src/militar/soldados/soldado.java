package militar.soldados;

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

    @Override
    public String toString() {
        return rango + " " + nombre + " (ID: " + id + ")";
    }

     // Métodos Getter
     public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getRango() {
        return rango;
    }
}
