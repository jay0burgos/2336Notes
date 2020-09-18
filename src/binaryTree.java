import org.w3c.dom.Node;

public class binaryTree<e> {
    /*root is the parent of all the children
    its a hierarchial structure
    top is the root
    traversal:
            in order-> smallest to largerst node

     */
    node<e> root;

    public void addNode(e payLoad, int key){
        if(root == null){
            root = new node<>(payLoad, key);
        }else
        {
            //traversal to find the new place for the node
            //theres an issue if the keys are equal
            node focusNode = root;
            node parent;
            while (true){
                parent = focusNode;
                if(key < focusNode.getKey()){
                    focusNode = focusNode.getLeftChild();
                    if(focusNode == null){
                        parent.setLeftChild(new node(payLoad, key));
                        return;
                    }
                }
                else
                    {
                    focusNode = focusNode.getRightChild();
                    if(focusNode == null){
                        parent.setRightChild(new node(payLoad, key));
                        return;
                    }
                }
            }
        }
    }
    public void inOrderTraver(node focusNode){
        if(focusNode != null){
            this.inOrderTraver(focusNode.getLeftChild());
            System.out.println(focusNode.getKey() + " is the" + focusNode.getKey());
            this.inOrderTraver(focusNode.getRightChild());
        }
    }

    public void preOrderTraver(node focusNode){
        if(focusNode != null){
            System.out.println(focusNode.getKey() + " is the " + focusNode.getPayLoad());
            this.inOrderTraver(focusNode.getLeftChild());
            this.inOrderTraver(focusNode.getRightChild());
        }
    }

    public node findNode(int key){
    node focusNode = root;
    while(focusNode.getKey() != key ){
        if(key < focusNode.getKey()){
            focusNode = focusNode.getLeftChild();
        }
        else
        {
            focusNode = focusNode.getRightChild();
        }
        if(focusNode == null)
            return null;
    }
    return focusNode;
    }


    public static  void main(String[] args){
        binaryTree<String> tree = new binaryTree<>();
        tree.addNode("Jose", 7);
        tree.addNode("kailey", 5);
        tree.addNode("Binx", 3);
        tree.addNode("Rhea",9 );
        tree.preOrderTraver(tree.root);

        System.out.println(tree.findNode(3));
    }

    public boolean remove(int key){
        node focusNode = root;
        node parent = root;

        boolean isItaLeftChild= true;

        while (focusNode.getKey() != key){
            parent = focusNode;
            if(key < focusNode.getKey()){
                isItaLeftChild = true;
                focusNode = focusNode.getLeftChild();
            }
            else{
                isItaLeftChild = false;
                focusNode = focusNode.getRightChild();
            }
            if(focusNode == null)
                return false;

        }
        //if node has no children this if engages to delete it
        if(focusNode.getLeftChild() == null && focusNode.getRightChild() == null){
            if(focusNode == root){
                root = null;
            }
            else if(isItaLeftChild){
                parent.setLeftChild(null);

            }
            else{
                parent.setRightChild(null);
            }
        }
        //if right child is null
        else if(focusNode.getRightChild() ==null){ //practically focusNode is the one being deleted
            if(focusNode == root){
                root = focusNode.getLeftChild();
            }
            else if(isItaLeftChild) // focus left child takes its place
                parent.setLeftChild(focusNode.getLeftChild());
            else
                parent.setRightChild(focusNode.getLeftChild());
        }
        else if(focusNode.getLeftChild() == null){ //if focus only has a right child
            if(focusNode == root)
                root = focusNode.getRightChild();
            else if(isItaLeftChild)
                    parent.setLeftChild(focusNode.getRightChild());
            else
                parent.setRightChild(focusNode.getLeftChild());
        }
        else{
            node replacement = getReplacementNode(focusNode);
            if(focusNode == root){
                root = replacement;
            }
            else if(isItaLeftChild){
                parent.setLeftChild(replacement);
            }
            else
                parent.setRightChild(replacement);

            replacement.setLeftChild(focusNode.getLeftChild());
        }
    return true;
    }

    private node getReplacementNode(node replaceNode) {
        node replacementParent = replaceNode;
        node replacement = replaceNode;

        node focusNode = replaceNode.getRightChild();

        while(focusNode != null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();

        }

        if(replacement != replaceNode.getRightChild()){
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replaceNode.getRightChild());
        }
        return replacement;
    }





}

class node<e>{
      private e payLoad;
      private int key;

      private node<e> leftChild;
      private node<e> rightChild;

    public node(e payLoad, int key) {
        this.payLoad = payLoad;
        this.key = key;
    }

    public e getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(e payLoad) {
        this.payLoad = payLoad;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public node<e> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(node<e> leftChild) {
        this.leftChild = leftChild;
    }

    public node<e> getRightChild() {
        return rightChild;
    }

    public void setRightChild(node<e> rightChild) {
        this.rightChild = rightChild;
    }
}