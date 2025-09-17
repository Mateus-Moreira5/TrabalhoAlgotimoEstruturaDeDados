public class ListaDeProcessos { // Classe que monta as listas encadeadas
    Node head;
    Node tail;
    int size = 0;

    public void adicionarProcesso(Processo processo){ // Adiciona os processos no final da lista como s fosse uma fila
        Node Processo1 = new Node(processo, null);
        if (head == null){
            head = Processo1;
            tail = Processo1;
        } else {
            tail.next = Processo1;
            tail = Processo1;
        }
        size++;
    }
    public Processo removerInicio(){ // Remove o primeiro processo da lista e retorna ele como "processoRemovida"
        if( head == null){
            return null;
        }
        Processo processoRemovido = head.processo;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return processoRemovido;
    }
    public boolean listaVazia(){ // Verifica se a lista está vazia
        return head == null;
    }
    public Processo mostrarPrimeiro(){ // Retorna o primeiro processo da lista
        if (head == null){
            return null;
        }
        return head.processo;
    }
    public void visualizarLista(){ // Vizualia a lista
        if(listaVazia()){
            System.out.println("Lista Vazia.");
            return;
        }
        Node atual = head;
        while(atual != null){
            Processo p = atual.processo;
            System.out.println(p.getNome()+"["+p.getCiclos_necessarios()+"]");
            if (atual.next != null) {
                System.out.print("->");
            }
            atual = atual.next;
        }
    }
    public int getSize() { // Retorna o tamanho da lista
        return size;
    }
    public int getSize() {
    return this.size;
    }
}