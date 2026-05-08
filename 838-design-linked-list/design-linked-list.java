class MyLinkedList {
    class Node{
        Node next;
        int val;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    
    }
    Node head;
    int size;

    public MyLinkedList() {
        head=null;
        size=0;

    }
    
    public int get(int index) {
        if(index<0 || index >= size) return -1;
        Node temp=head;

        while(index>0 && temp.next!=null){
            temp=temp.next;
            index--;
        }
        return temp.val;
        
    }
    
    public void addAtHead(int val) {
        Node newNode=new Node(val);
        newNode.next=head;
        head=newNode;

        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        Node temp=head;
        //what if head is null
        if(head==null){
            head=newNode;
            size++;
            return;
        }

        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        // Insert at head
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // Insert at tail
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;

        
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        // Delete head
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        size--;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */