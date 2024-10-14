public class soldado {
    protected String nombre;
    protected String id;
    protected String rango;

    public soldado(String nombre, String id, String rango){
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
    }

    void mostrar_informacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Rango: " + rango);
    }

}
