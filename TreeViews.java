import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
/**
 * TreeViews
 */

class Tree{
    int data;
    Tree left;
    Tree right;
    public Tree(int data){
        this.data=data;
    }
}
class Pair{
    Tree node;
    int order;
    public Pair(Tree node,int order){
        this.node=node;
        this.order=order;
    }
}

public class TreeViews {
    static void preOrder(Tree root){
        Stack <Pair> stack = new Stack<>();
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair temp= stack.pop();
            if(temp.order==1){
                preOrder.add(temp.node.data);
                temp.order++;
                stack.push(temp);
                if(temp.node.left!=null){
                    stack.push(new Pair(temp.node.left, 1));
                }
                continue;
            }
            if(temp.order==2){
                inOrder.add(temp.node.data);
                temp.order++;
                stack.push(temp);
                if(temp.node.right!=null){
                    stack.push(new Pair(temp.node.right, 1));
                }
                continue;
            }
            if(temp.order==3){
                postOrder.add(temp.node.data);
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
        
    }
    public static void main(String[] args) {
        Tree root = new Tree(0);
        root.left=new Tree(1);
        root.right=new Tree(2);
        root.left.left=new Tree(3);
        root.left.right=new Tree(4);
        root.right.left=new Tree(5);
        root.right.right=new Tree(6);

        preOrder(root);
    }
}