package hibskyi;

public class Stack<Item>{

    private Node head;
    private int size;

    public void push(Item item) {
        head = new Node(item, head);
        size++;
    }

    public Item pop() {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        Item item;
        Node next;
        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}

