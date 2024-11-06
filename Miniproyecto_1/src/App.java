import militar.rangos.Rango;
import militar.soldados.Capitan;
import militar.soldados.Coronel;
import militar.soldados.SoldadoRaso;
import militar.soldados.Teniente;

public class App {
    public static void main(String[] args) throws Exception {
        SoldadoRaso soldado1 = new SoldadoRaso("Juan", "1");
        Teniente teniente1 = new Teniente("Pedro", "2", "Alfa");
        Capitan capitan1 = new Capitan("Luis", "3", 10);
        Coronel coronel1 = new Coronel("Carlos", "4", "Ofensiva");

        soldado1.asignarMision("Patrullar la zona");
        teniente1.asignarMision("Reconocimiento del terreno");
        capitan1.asignarMision("Ataque sorpresa");
        coronel1.asignarMision("Conquista del territorio");

        reportarEstadoSoldado(soldado1);
        reportarEstadoSoldado(teniente1);
        reportarEstadoSoldado(capitan1);
        reportarEstadoSoldado(coronel1);

    }

    public static void reportarEstadoSoldado (Rango soldado) {
        soldado.realizarAccion();
    }
}
