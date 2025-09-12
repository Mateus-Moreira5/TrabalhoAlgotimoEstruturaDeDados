public class Node {
    Processo processo;
    Node next;
    
    public Node(Processo processo, Node next) {
        this.processo = processo;
        this.next = next; 
    }
}