
class LinkedList {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node Head;
    public static Node Tail;
    public static int size;

    public static void print(){
        if(Head == null){
            System.out.println("Linked List is Empty");
        }

        Node temp = Head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    // add first element
    public static void addFirst(int data){
        Node newNode = new Node(data);

        if(Head == null){
            Head = Tail = newNode;
            return;
        }

        newNode.next = Head;
        Head = newNode;

    }

    //addLast
    public static void addLast(int data){
        Node newNode = new Node(data);

        if(Head == null){
            Head = Tail = newNode;
        }

        Tail.next = newNode;
        Tail = newNode;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);

        ll.addLast(9);
        ll.addLast(8);
        ll.addLast(7);
        ll.addLast(6);

        print();

        System.out.println("Sagar");
    }
}
