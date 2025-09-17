// Recolhe as ferramentas necessárias para ler arquivos.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App { // Classe principal do programa.
    public static void main(String[] args) { // Ponto de entrada do programa
        if (args.length == 0) { // Checa se o usuário informou o nome de um arquivo.
            System.out.println("Erro: Forneça o nome do arquivo de processos como argumento.");// Caso contrário, exibe uma mensagem de erro e encerra a execução.
            System.out.println("Exemplo: java App processos.txt");
            return;
        }

        String nomeArquivo = args[0]; // Guarda o nome do arquivo.
        Schedule controlador = new Schedule();  // Cria o "gerenciador" que vai organizar os processos.

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) { // Tenta ler o arquivo de processos de forma segura.
            String linha; // Variável para guardar cada linha do arquivo.
            while ((linha = br.readLine()) != null) { // Lê o arquivo, uma linha de cada vez, até o final.
                String[] dados = linha.split(","); // Separa os dados da linha pela vírgula.

                // Se a linha não contiver os 5 campos esperados, ela é ignorada e a iteração prossegue.
                if (dados.length != 5) { 
                    System.err.println("Linha mal formatada: " + linha);
                    continue;
                }

                try { // Tenta transformar os dados lidos em um processo.
                    int id = Integer.parseInt(dados[0]);  // Converte os textos em números (ID, prioridade, ciclos).
                    String nome = dados[1];
                    int prioridade = Integer.parseInt(dados[2]);
                    int ciclos = Integer.parseInt(dados[3]);
                    String recurso = dados[4].equalsIgnoreCase("null") ? null : dados[4];

                    Processo novoProcesso = new Processo(id, nome, prioridade, ciclos, recurso); // Cria o novo processo com esses dados.
                    controlador.AdicionarFilas(novoProcesso); // Adiciona o processo na fila de espera do gerenciador.

                // Se algum dado estiver errado (ex: texto onde deveria ser número), avisa e ignora a linha.
                } catch (NumberFormatException e) {
                    System.err.println("Erro de conversão em: " + linha);
                }
            }
        // Se der um erro grave ao ler o arquivo (ex: não encontrado), avisa e para o programa.
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Avisa que os processos foram carregados e a simulação vai começar.
        System.out.println(">>> Processos carregados. Iniciando simulação...");

        // Loop principal: continua rodando enquanto houver processos em qualquer fila.
        while (!controlador.ListaAltaPrioridade.listaVazia() ||
               !controlador.ListaMediaPrioridade.listaVazia() ||
               !controlador.ListaBaixaPrioridade.listaVazia() ||
               !controlador.ProcessosBloqueados.listaVazia()) {

            controlador.executarCiclosDeCPU(); // Pede ao gerenciador para executar um passo da simulação.
        }

        System.out.println(">>> Todos os processos foram finalizados."); // Quando o loop acaba, avisa que todos os processos terminaram.
    }
}
