public class MyLinkedList<E> {
    MyNode<E> first;
    MyNode<E> last;
    int size;

    public boolean isEmpty()
    {
        return first == null;
    }
    //1- create node
    //2- first is going to have the reference to it
    //3-


    public int getSize() {
        return this.size;
    }

    public E getFirstElement() {
        return (E) first.element;
    }

    public E getLastElement() {
        return (E) last.element;
    }

    public void addFirst(E e){
        MyNode<E> newNode = new MyNode<>(e);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }
        else { //not the only element
            newNode.next = first;
            first = newNode;
        }
        first = newNode;
        size++;
    }
    public void addLast(E e){
        MyNode<E> newNode = new MyNode<>(e);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }
        else { //not the only element
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public void removeFirst() {
        if (!isEmpty()) {
            E temp = (E) first.element;
            if(first == last)
            {
                first = last = null;
            }
            else
            {
                first = first.next;
            }
            size--;
            System.out.println(temp + " is removed");
        }
        else{
            System.out.println("List is empty");
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            E temp = (E) last.element;
            if(first == last)
            {
                first = last = null;
            }
            else //do traversing
            {
                MyNode previous = first; // place to start checking takes order of N elements
                while(previous.next != last){
                    previous = previous.next;
                }
                previous.next = null;
                last = previous;
            }
            size--;
            System.out.println(temp + " is removed");
        }
        else{
            System.out.println("List is empty");
        }
    }

    public boolean search(E key){
        MyNode pointer = first;
        while(pointer != null && !pointer.element.equals(key)){
            pointer = pointer.next;
        }
        return pointer != null;
    }

    public void remove(E key){
        if(search(key)){
            MyNode<E> prev = first;
            MyNode<E> curr = first;
            while(curr != null && !curr.element.equals(key)){
                prev = curr;
                curr = curr.next;

            }
            if(curr == first) removeFirst();
            else if(curr == last)removeLast();
            else{
                prev.next = curr.next;
                size--;
                System.out.println(key + " removed");
            }
        }
    }

    public void print(){
        MyNode<E> pointer = first;
        if(!isEmpty()){
            System.out.print("| ");
            while(pointer != null){
                System.out.print(pointer.element + " | ");
                pointer = pointer.next;
            }

            System.out.println();
        }
    }
}

class MyNode<E> {
    //if a linked list is to by generic, the node must be made
    //into a generic class
    E element;
    MyNode next;//points to the next element

    MyNode(E element){
        this.element = element;
    }

}

