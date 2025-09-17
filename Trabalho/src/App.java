import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("processos.txt"));
        String line;
        Scheduler scheduler = new Scheduler();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String nome = parts[1].trim();
            int prioridade = Integer.parseInt(parts[2].trim());
            int ciclos_necessarios = Integer.parseInt(parts[3].trim());
            String recurso_necessario = parts[4].trim();
            boolean requisitou = Boolean.parseBoolean(parts[5].trim());

            Processo processo = new Processo(id, nome, prioridade, ciclos_necessarios, recurso_necessario, requisitou);
            scheduler.adicionarProcesso(processo);
        }
        reader.close();

        System.out.println("Processos na fila de prioridade (do mais alto para o mais baixo):");
        while (!scheduler.isEmpty()) {
            Processo processo = scheduler.removerProcesso();
            System.out.println(processo);
        }
    }
}