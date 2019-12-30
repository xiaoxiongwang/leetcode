import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import jdk.nashorn.api.tree.Tree;

class test_tree{
    public static TreeNode init_tree(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(6);

        treeNode3.right = treeNode6;

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;

        return treeNode1;
    }
    public static void qianorderTraversal(TreeNode root) {
        if(root!=null){
            System.out.println(root.val);
            qianorderTraversal(root.left);
            qianorderTraversal(root.right);
        }
    }
    public static void qianorderTraversal_not_recu(TreeNode root) {
        TreeNode head = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        // stack.push(head);
        while(true){
            if(head!=null){
                System.out.println(head.val);
                stack.push(head);
                head = head.left;
            }else{
                if(stack.isEmpty()) break;
                head = stack.pop();
                head = head.right;
                // if(head!=null) System.out.println(head.val);
            }

        }
    }

    public static void inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            System.out.println(root.val);
            inorderTraversal(root.right);
        }
    }
    public static void inorderTraversal_not_recusion(TreeNode root) {
        TreeNode head = root;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        // while(true){
        //     if(head!=null){
        //         stack.push(head);
        //         head = head.left;
        //     }else{
        //         if(stack.isEmpty()) break;
        //         TreeNode cur = stack.pop();
        //         System.out.println(cur.val);
        //         head = cur.right;
        //     }
        // }

        while(head!=null||!stack.isEmpty()){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else{
                // if(stack.isEmpty()) break;
                TreeNode cur = stack.pop();
                System.out.println(cur.val);
                head = cur.right;
            }
        }
        
    }

    public static void houorderTraversal(TreeNode root) {
        if(root!=null){
            houorderTraversal(root.left);
            houorderTraversal(root.right);
            System.out.println(root.val);

        }
    }


    public static void houorderTraversal_not_recuscion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<TreeNode>();

        while(!stack.isEmpty()){
            TreeNode head = stack.pop();
            if((head.left==null||set.contains(head.left))&&(head.right==null||set.contains(head.right))){
                // TreeNode cur = stack.pop();
                System.out.println(head.val);
                set.add(head);
            }else{
                stack.push(head);
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }   
        }
    }

    public static void levelTraverse(TreeNode root){
        LinkedList<TreeNode> list= new LinkedList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode cur = list.pop();
            System.out.println(cur.val);
            if(cur.left!=null) list.add(cur.left);
            if(cur.right!=null) list.add(cur.right);
        }
    }
    public static void main(String[] args) {
        // System.out.println("test");
        TreeNode head = init_tree();
        // houorderTraversal_not_recuscion(head);
        // houorderTraversal_not_recuscion(head);
        // levelTraverse(head);
        // houorderTraversal(head);
        // qianorderTraversal_not_recu(head);
        // qianorderTraversal(head);
        // inorderTraversal(head);
        inorderTraversal_not_recusion(head);
        // LinkedList<Integer> test = new LinkedList<Integer>();
        // test.add(3);
        // test.add(4);
        // test.push(5);
        // System.err.println(test.pop());
        // System.out.println(test.pop());
        // System.out.println(test.isEmpty());
        // System.out.println(test.isEmpty());

    }
}
