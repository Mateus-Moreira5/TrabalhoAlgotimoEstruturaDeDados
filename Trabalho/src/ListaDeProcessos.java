public class ListaDeProcessos {
    Node head;
    Node tail;
    int size = 0;
    public void adicionarProcesso(Processo processo){
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
    public Processo removerInicio(){
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
    public boolean listaVazia(){
        return head == null;
    }
    public Processo mostrarPrimeiro(){
        if (head == null){
            return null;
        }
        return head.processo;
    }
    public void visualizarLista(){
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
        System.out.println();
    }
}