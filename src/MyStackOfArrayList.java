public class MyStackOfArrayList {
    private int top;//size
    private MyArrayList mystack = new MyArrayList();

    public boolean isEmpty()
    {
        return mystack.isEmpty();
    }

    public void push(String s ){
        mystack.addLast(s);
        top = mystack.getSize();
    }

    //public String peek(){
        //return mystack.getElement(top-1);
   // }

    public void pop(){
        mystack.removeLast();
        top = mystack.getSize();
    }

    public int search(String key){
        return mystack.search(key);
    }

}