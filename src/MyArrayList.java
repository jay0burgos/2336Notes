import java.security.DrbgParameters;
/*using Object as the data type makes this type abstract, allowing different types of variables
to be used, object checks at run time for errors
E makes it generic, make all object parameters and return types of object to E
now there's a compile error instead of run time;

cannot do an Intance of a generic type, must specify data type
generic type parameter of a class is not allowed in a static context
exception Classes cannot be generic
*/
public class MyArrayList<E> {
    private Object[] list;
    private int capacity = 4;
    private int size;

    public MyArrayList(){
        this(4);
    }

    public MyArrayList(int capacity){
        if(capacity > 4)
            this.capacity = capacity; //overrides capacity value only when its warranted
        this.list = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public Boolean isEmpty(){
        return this.size == 0;
    }

    //add element in the end of the list O(1) <- order of one
    public void addLast(E s){
        if(size >= capacity) resize(this.capacity * 2); //increase capasity
        list[size] = s;
        size++;
    }

    // it can act like adding element to the begining of list 0[N]
    public  void add(E s, int index){

        if(index >= 0 && index < size-1) //index is within range
        {
            for(int k = size -1; k <= index; k--)//shifts elements
            {
                list[k+1] = list[k];
            }
            list[index] = s;

        }
        else if(index >= size-1) //if equal top final element, will call the add to end method
        {
            System.out.println("index "+ index+" out of bound, resizing and adding to end");
            this.addLast(s);

        }
        else if(index < 0){
            System.out.println(index + " out of range");
        }

    }
    //removing elements from end of list order of complexity of 1
    public void removeLast(){
        if(!this.isEmpty()){
            size--;
            Object temp = list[size];
            list[size] = null;
            if(size!=0 && capacity/size >= 4) resize(this.capacity/2);
            System.out.println(temp + "removed");
        }
        else{
            System.out.println("List is empty");
        }
    }
    /*
    //if do have duplication
    public void removeDuplication(){
      do duplication removal
    }*/

    //order of N, have to search for key
    public void remove(E key){
        int index = this.search(key);
        if(index != -1){
            //do shift
            for(int i = index; i <= size; i++)
            {
                list[i] = list[i+1];
            }
            size--; // resize
            if(size!=0 && capacity/size >= 4) resize(this.capacity/2);
            System.out.println(key + " removed");
        }
        else
            System.out.println("Not in list");
    }



    //linia search order O(n)
    public int search(E key){
        for(int i = 0;i < size;i++)
        {
            if(list[i].equals(key)) return i;
        }
        return -1;
    }
    //O(1) 1 complexity
    public E getElement(int index){
        if( index >= 0 && index < size)
            return (E)list[index];   //look at this one with return type in paranthesis
        else
            return null;
    }

    //used privately cuz only this class will use it
    private void resize(int capacity) { //order of 1 to add a new element
        this.capacity = capacity;
        //create new array
        E[] temp = (E[])list;
        this.list = new Object[this.capacity]; //when declaring a new generic object use object
        for(int i = 0; i < size;i++ )
        {
            list[i] = temp[i];
        }
    }
    public void print(){
        System.out.print(" |");
        for (int i = 0; i < capacity; i++){
            System.out.print(this.list[i] + " | ");
        }
        System.out.println();
    }

}

