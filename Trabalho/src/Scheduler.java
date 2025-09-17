import java.util.PriorityQueue;
import java.util.Comparator;

public class Scheduler {
    private PriorityQueue<Processo> filaPrioridade;

    public Scheduler() {
        filaPrioridade = new PriorityQueue<>(new Comparator<Processo>() {
            @Override
            public int compare(Processo p1, Processo p2) {
                return Integer.compare(p2.getPrioridade(), p1.getPrioridade());
            }
        });
    }

    public void adicionarProcesso(Processo processo) {
        filaPrioridade.add(processo);
    }

    public Processo removerProcesso() {
        return filaPrioridade.poll();
    }

    public boolean isEmpty() {
        return filaPrioridade.isEmpty();
    }

    public int tamanho() {
        return filaPrioridade.size();
    }
}