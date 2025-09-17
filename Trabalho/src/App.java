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
