import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        Schedule Controlador = new Schedule();

        while (Controlador.ListaAltaPrioridade.listaVazia()||
        Controlador.ListaMediaPrioridade.listaVazia()||
        Controlador.ListaBaixaPrioridade.listaVazia()||
        Controlador.ProcessosBloqueados.listaVazia()) {
            Controlador.executarCiclosDeCPU();
        }
    }
}