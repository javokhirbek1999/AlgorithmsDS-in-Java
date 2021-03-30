import java.util.ArrayList;

class Node{
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedList{
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size += 1;
    }

    public void append(int value){
        Node node = new Node(value);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size += 1;
    }

    public void remove(int index) {
        if(this.head == null) {
            System.out.println("LinkedList does not exist");
        } else {
            if (index == 0) {
                this.head = this.head.next;
            } else if(index==this.size-1){
                Node current = this.head;
                while(current.next!=this.tail) {
                    current = current.next;
                }
                current.next = null;
                this.tail = current;
            }else {
                Node current = this.head;
                int ind = 0;
                while(ind < index-1) {
                    current = current.next;
                    ind += 1;
                }
                current.next = current.next.next;
            }
            this.size -= 1;
        }
    }

    public boolean contains(int value){
        if(this.head == null) {
            return false;
        } else{
            Node current = this.head;
            while(current!=null) {
                if(current.value==value){
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    public int search(int value) {
        if(this.head == null) {
            return -1;
        }else{
            Node current = this.head;
            int ind = 0;
            while(current!=null) {
                if(current.value==value) {
                    return ind;
                }
                current = current.next;
                ind += 1;
            }
            return -1;
        }
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public ArrayList<Integer> print() {
        Node current = this.head;
        ArrayList<Integer>arrayList = new ArrayList<>();
        while(current!=null){
            arrayList.add((current.value));
            current = current.next;
        }
        return arrayList;
    }

    public int getSize(){
        return this.size;
    }
}
