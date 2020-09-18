public class heap2<E>{
    /*parent nodes are bigger than child nodes
    always complete except for last row
    use- quick to insertion and deletion and sorting
    but slow to traverse and search

    when deleting, next highest node replaces the deleted node,
    removes highest priority node at the top of the heap, but correct order
    must be restored
        process-> save top node to a temp to be returned
        2- take the lowest right most node and send to top
        3-then do sift down by picking largest num
    Use either array or binary tree-for an arraylist you can use
    2k+1 and 2k+2 for kids, every node,top down left to right is numbered
    according to the index

    to insert, start from bottom up, add to left most spot if its a full heap


    */

    node<E> root;

}
