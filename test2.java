import java.util.HashMap;

class Test2 {
    private static HashMap<Integer,Integer> hash2;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int p_length = preorder.length;
        int i_length = inorder.length;

        if(p_length==0) return null;

        // TreeNode root = new TreeNode(preorder[0]);
        // if(p_length==0) return root;
        // hash1 = new HashMap<Integer,Integer>();
        hash2 = new HashMap<Integer,Integer>();

        for(int i=0;i<p_length;i++){
            // hash1.put(preorder[i], i);
            hash2.put(inorder[i], i);
        }

        return buildTreeMiddle(preorder, inorder, 0, p_length-1, 0);
    }

    public static TreeNode buildTreeMiddle(int[] preorder, int[] inorder,int i,int j,int r){
        // System.out.println(preorder[r]);
        // System.out.println(i+" "+j+" "+r);
        // System.out.println(inorder[i]+" "+inorder[j]);
        // System.out.println("--------------------");
        if(i>j) return null;
        TreeNode root = new TreeNode(preorder[r]);
        // System.out.println("err1");
        if(i==j) return root;
        
        // System.out.println("return");
        // System.out.println(hash2.get(preorder[r]));
        int hashget = hash2.get(preorder[r]);
        root.left = buildTreeMiddle(preorder, inorder, i, hashget-1,r+1);
        // System.out.println("err2");
        root.right = buildTreeMiddle(preorder, inorder,hashget+1,j,r+hashget-i+1);
        return root;
    }
    public static void main(String[] args) {
        String s = "hello world";
        char c[]=s.toCharArray();
        System.out.println(c);
        // int a[] = {1,2};
        // int b[] = {2,1};

        // buildTree(a, b);
    }
}