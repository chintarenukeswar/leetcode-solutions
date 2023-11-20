package main.java.udemydatastrcutures.bst;

public class BinarySearchTree {
    Node root;

    public boolean contains(int value){
        if(root == null){
            return false;
        }
        Node temp = root;
        while(temp != null){
            if(temp.value == value){
                return true;
            }else if(value < temp.value){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return false;
    }
    public boolean rContains(int value){
        return rContains(root,value);
    }

    //using recursive
    private boolean rContains(Node rootNode, int value){
        if(rootNode == null) return false;
        if(rootNode.value == value) return true;
        if(value < rootNode.value){
            return rContains(rootNode.left,value);
        }else{
            return rContains(rootNode.right,value);
        }
    }

    public Node rInsert(int value){
        return rInsert(root,value);
    }
    private Node rInsert(Node currentNode,int value){
        Node newNode = new Node(value);
        if (root == null) return newNode;
        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left,value);
        }else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right,value);
        }
        return currentNode;
    }

    public int rMinimumvalue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root= newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(newNode.value == temp.value)
                return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }


        }
    }

    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value =value;
        }

    }
}
