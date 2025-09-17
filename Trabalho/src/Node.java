public class Node { // Classe que vai criar o nó das listas
    Processo processo;
    Node next;
    
    public Node(Processo processo, Node next) {
        this.processo = processo;
        this.next = next; 
    }
}