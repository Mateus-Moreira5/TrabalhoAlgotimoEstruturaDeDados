public class EstruturaProcesso{
    private int id; 
    private String nome;
    private int prioridade; 
    private int ciclos_necessarios;
    private String recurso_necessario;

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getPrioridade() {
        return prioridade;
    }public int getCiclos_necessarios() {
        return ciclos_necessarios;
    }
    public String getRecurso_necessario() {
        return recurso_necessario;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }public void setCiclos_necessarios(int ciclos_necessarios) {
        this.ciclos_necessarios = ciclos_necessarios;
    }public void setRecurso_necessario(String recurso_necessario) {
        this.recurso_necessario = recurso_necessario;
    }
}