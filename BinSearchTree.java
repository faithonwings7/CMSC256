package cmsc256;

import bridges.base.BinTreeElement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinSearchTree<E extends Comparable<E>> implements BinTreeInterface<E> {

    private int size = 0;
    BinTreeElement<E> root;

    /**
     * Return the height of this binary tree
     */
    public int height(BinTreeElement<E> node) {
        //TODO: Issues with Node and BinaryNode.
        // Having issues getting left and right to catch

        /**Base case*/
        if (root == null) {
            return 0;
        }

        Queue<BinTreeElement<E>> q = new LinkedList();
        q.add(node);
        int height = 0;

        while (1 == 1) {
            int nodeCount = q.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;


            while (nodeCount > 0) {
                BinTreeElement<E> newNode = q.peek();
                q.remove();
                if (newNode.getLeft() != null) {
                    q.add(newNode.getLeft());
                }
                if (newNode.getRight() != null) {
                    q.add(newNode.getRight());
                }
                nodeCount--;
            }
        }
    }

    /**
     * Returns true if the tree is a full binary tree
     * @param left
     */
    public boolean isFullBST(BinTreeElement<E> left) {
        //TODO
//        if (_________ >= ________.length - 1) {
//            return true;
//        }
//        return false;

        if (root == null) {
            return true;
        }
        else if (root.getLeft() == null && root.getRight() != null) {
            return false;
        }
        else if (root.getRight() == null && root.getLeft() != null) {
            return false;
        }
        else {
            return isFullBST(root.getLeft()) && isFullBST(root.getRight());
        }
    }

    /**
     * Return the number of leaf nodes
     */
    public int getNumberOfLeaves(BinTreeElement<E> node){

        //TODO
        if(node == null) {
            return 0;
        } else if((node.getLeft() == null) && (node.getRight() == null)) {
            return 1;
        } else {
            return getNumberOfLeaves(node.getLeft()) + getNumberOfLeaves(node.getRight());
        }
    }

    /**
     * Return the number of non-leaf nodes
     */
    public int getNumberOfNonLeaves(){
        int numNonLeaves = 0;

        //TODO

        return numNonLeaves;
    }

    //TODO: Needed? Or no?
    private boolean addToParent(BinTreeElement<E> parentNode, BinTreeElement<E> addNode) {
        int compare = parentNode.getValue().compareTo(addNode.getValue());
        boolean wasAdded = false;

        if (compare > 0) {
            // if parent has no left node, add new node as left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(addNode); // fill in this blank
                wasAdded = true;
            } else {
                // otherwise, add to parentNode's left (recursive)
                wasAdded = addToParent(parentNode.getLeft(), addNode);
            }
        } else if (compare < 0) {
            // if parent has no right node, add new node as right
            if (parentNode.getRight() == null) {
                parentNode.setRight(addNode);
                wasAdded = true;
            } else {
                // otherwise, add to parentNode's right (recursive)
                wasAdded = addToParent(parentNode.getRight(), addNode);
            }
        }
        return wasAdded;

    }


    public static void main(String[] args) {

        BinSearchTree<String> names = new BinSearchTree<>();
        names.add("Frodo");
        names.add("Dori");
        names.add("Bilbo");
        names.add("Kili");
        names.add("Gandalf");
        names.add("Fili");
        names.add("Thorin");
        names.add("Nori");

    }

    /** Returns the root of this tree
     */
    @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }

    /** Insert element into the binary tree
     * Return true if the element is inserted successfully
     */
    @Override
    public boolean add(E valueIn) {
        BinTreeElement<E> node = new BinTreeElement<E>();
        boolean wasAdded = true;
        int size = 0;

        if (root == null) {
           root = node;
        }
        else {
           wasAdded = addToParent(root, node);
            }

            if (wasAdded) {
                size++;
            }
            return wasAdded;
    }

    /** Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    @Override
    public boolean remove(E element) {
        int size = 0;

        if (root == null) {
            return false;
        }

        if (root.getValue().compareTo(element) == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            }
            else if (root.getRight() == null) {
                root = root.getLeft();
            }
            else {
                BinTreeElement formerRight = root.getRight();
                root = root.getLeft();
                addToParent(root, formerRight);
            }
            size--;
            return true;
        }

        return removeSubNode(root, element);
    }

    private boolean removeSubNode(BinTreeElement<E> parent, E element) {
        int compareParent = root.getValue().compareTo(element);

        BinTreeElement<E> subTree = null;
        if (compareParent > 0)
            subTree = parent.getLeft();
        else
            subTree = parent.getRight();

        if (subTree == null) {
            return false;
        }

        if (subTree.getValue().compareTo(element) == 0) {
            BinTreeElement<E> replacement;
            if (subTree.getLeft() == null) {
                replacement = subTree.getRight();
            }
            else if (subTree.getRight() == null) {
                replacement = subTree.getLeft();
            }
            else {
                BinTreeElement<E> formerRight = subTree.getRight();
                replacement = subTree.getLeft();
                addToParent(replacement, formerRight);
            }

            if (compareParent > 0) {
                parent.setLeft(replacement);
            }
            else {
                parent.setRight(replacement);
            }

            size--;
            return true;
        }

        return removeSubNode(subTree, element);
    }

    /** Returns the number of nodes in the tree
     */
    @Override
    public int size()
    {
        return size; }

    /** Return true if the tree is empty
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;    }

    /** Removes all nodes from the tree
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Return true if the element is in the tree
     */
    @Override
    public boolean search(E o) {
        BinTreeElement<E> current = root; // Start from the root

        //equals object
        while (current != null) {
            if (o.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            }
            else if (o.compareTo(current.getValue()) > 0) {
                current = current.getRight();
            } else
                // element matches current.element
                return true; // Element is found
        }
        return false;
    }

    /** Inorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
    @Override
    public String inorder() {
        String inorder = "";
        inorder(node) + "  ";

        return inorder;
    }

    private void inorder(BinTreeElement<E> root) {
        if (root == null)
            return;

         Stack<BinTreeElement<E>> inOrderStack = new Stack<BinTreeElement<E>>();
         BinTreeElement<E> currentNode = root;

         while(!inOrderStack.empty() || currentNode != null){
             if(currentNode != null){
                 inOrderStack.push(currentNode);
                 currentNode = currentNode.setLeft();
             }
             else{
                 BinTreeElement<E>  n = inOrderStack.pop();
                 System.out.printf("%d ", n.data);
                 currentNode = currentNode.setRight();
             }
         }
    }

    /** Postorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
    @Override
    public String postorder() {
        return null;
    }

    /** Preorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
    @Override
    public String preorder() {
        return null;
    }

}
