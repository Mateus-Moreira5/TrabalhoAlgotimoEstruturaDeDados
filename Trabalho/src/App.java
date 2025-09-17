import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Erro: Forneça o nome do arquivo de processos como argumento.");
            System.out.println("Exemplo: java App processos.txt");
            return;
        }

        String nomeArquivo = args[0];
        Schedule controlador = new Schedule();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados.length != 5) {
                    System.err.println("Linha mal formatada: " + linha);
                    continue;
                }

                try {
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    int prioridade = Integer.parseInt(dados[2]);
                    int ciclos = Integer.parseInt(dados[3]);
                    String recurso = dados[4].equalsIgnoreCase("null") ? null : dados[4];

                    Processo novoProcesso = new Processo(id, nome, prioridade, ciclos, recurso);
                    controlador.AdicionarFilas(novoProcesso);

                } catch (NumberFormatException e) {
                    System.err.println("Erro de conversão em: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        System.out.println(">>> Processos carregados. Iniciando simulação...");

        while (!controlador.ListaAltaPrioridade.listaVazia() ||
               !controlador.ListaMediaPrioridade.listaVazia() ||
               !controlador.ListaBaixaPrioridade.listaVazia() ||
               !controlador.ProcessosBloqueados.listaVazia()) {

            controlador.executarCiclosDeCPU();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Boa prática
            }
        }

        System.out.println(">>> Todos os processos foram finalizados.");
    }
}
