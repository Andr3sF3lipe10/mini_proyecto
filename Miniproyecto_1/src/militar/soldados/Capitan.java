package militar.soldados;

import militar.operaciones.OperacionesMilitares;
import militar.rangos.Rango;
public class Capitan extends Rango implements OperacionesMilitares {
    private final int cantidadSoldadosBajoSuMando; 
    private String misionAsignada;

    public Capitan(String nombre, String id, int cantidadSoldadosBajoSuMando) {
        super(nombre, id, 3); // Nivel 3 para Capitán
        this.rango = "Capitán";
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }


    @Override
    public void realizarAccion() {
        System.out.println(nombre + " está coordinando la misión: " + misionAsignada + 
                           " con " + cantidadSoldadosBajoSuMando + " soldados.");
    }

    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        System.out.println("Capitán " + nombre + " ha recibido la misión: " + mision);
    }

    
    @Override
    public void reportarEstado() {
        System.out.println("Capitán " + nombre + " reporta: Preparado para coordinar " + 
                           misionAsignada + " con " + cantidadSoldadosBajoSuMando + " soldados.");
    }

    // Método sobrescrito para preparación
    @Override
    public void prepararseParaMision() {
        System.out.println("Capitan " + nombre + " esta revisando el plan de la mision.");
      }


    public int getCantidadSoldadosBajoSuMando() {
        return cantidadSoldadosBajoSuMando;
    }


    public String getMisionAsignada() {
        return misionAsignada;
    }
}
