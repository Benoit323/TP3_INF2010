public class Interview {
    public static void atLeastOneRightChildIsNull(TreeNode t1, TreeNode t2, TreeNode result){
        if(t1.right == null)
            result.right = solution(null, t2.right);
        else
            result.right = solution(t1.right, null);
    }

    public static void atLeastOneLeftChildIsNull(TreeNode t1, TreeNode t2, TreeNode result){
        if(t1.left == null)
            result.left = solution(null, t2.left);
        else
            result.left = solution(t1.left, null);
    }

    public static TreeNode treesNotNull(TreeNode t1, TreeNode t2) {
        TreeNode result = t1.val < t2.val ? new TreeNode(t1.val) : new TreeNode(t2.val);
        if(t1.left == null || t2.left == null)
            atLeastOneLeftChildIsNull(t1, t2, result);
        else
            result.left = solution(t1.left, t2.left);

        if(t1.right == null || t2.right == null)
            atLeastOneRightChildIsNull(t1,t2,result);
        else
            result.right = solution(t1.right, t2.right);
        return result;
    }

    public static TreeNode atLeastOneTreeIsNull(TreeNode t1, TreeNode t2) {
        TreeNode result;
        if(t1==null && t2==null)
            result = null;
        else if(t1 == null && t2!=null)
            result = t2;
        else
            result = t1;
        return result;
    }

    public static TreeNode solution(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null)
            return treesNotNull(t1,t2);
        else
            return atLeastOneTreeIsNull(t1, t2);
    }
}


