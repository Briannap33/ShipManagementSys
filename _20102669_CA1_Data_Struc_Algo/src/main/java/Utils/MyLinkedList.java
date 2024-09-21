package Utils;


import Models.Port;

public class MyLinkedList<T> {
    private Node<T> head;

    private Node next;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }


    public static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.next = null;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }



    //inserts new node at end of list
    public void insert(T data){
        Node<T> node = new Node<>(data);
        node.data = data;
        node.next = null;

        if (head == null){
            head = node;
        }else{
            Node n = head;
            while (n.next!= null){
                n = n.next;
            }
            n.next = node;
        }
    }

    //inserts new node to beginning of list
    public void  insertAtStart(T data){
        Node<T> node = new Node<T>(data);
        node.next = head;
        head = node;

    }

    //inserts new node at specific index in list
    public void insertAt(int index, T data){
        if (index == 0) {
            insertAtStart(data);
        }else {
            Node<T> node = new Node<>(data);
            node.next = null;

            Node<T> n = head;
            for(int i = 0; i<index - 1; i++){
                n = n.next;
            }
        }
    }

    //delete a node at specified index
    public void deleteAt(int index){
        if(index == 0) {
            head = head.next;
        }else{
            Node<T> n = head;
            Node<T> n1 = null;
            for (int i = 0; i< index -1; i++){
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }
    }

    //displays all elements in linked list
    public void show(){
        Node<T> n = head;
        while(n.next !=null){
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }
    public void remove(T data){
        Node<T> now= head;
        Node<T> past = null;

        while (now !=null && !now.data.equals(data)){
            past = now;
            now = now.next;
        }
        if (now !=null){
            if (past != null){
                past.next = now.next;
            }else{
                head = now.next;
            }
        }
    }





        }

