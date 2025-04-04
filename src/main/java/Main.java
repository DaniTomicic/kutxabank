import C.*;

public class Main {
    public static void main(String[] args) {declararVar();}
    public static void declararVar() {
        ModeloController modeloController = new ModeloController();
        VistaController vistaController = new VistaController(modeloController);
        modeloController.setVista(vistaController);
    }
}
