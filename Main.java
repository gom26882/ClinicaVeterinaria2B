import controller.MascotaController;
import view.MascotaView;

public class Main {
    public static void main(String [] Args){
        MascotaView view = new MascotaView();

        MascotaController controller = new MascotaController(view);

        controller.iniciar();
    }
}
