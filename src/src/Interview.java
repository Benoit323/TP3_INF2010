public class Interview {

    //TODO: completer
    public static TreeNode solution (TreeNode t1, TreeNode t2) {
        TreeNode result = null;
        if(t1 != null && t2 != null){
            result = t1.val < t2.val ? new TreeNode(t1.val): new TreeNode(t2.val);
        }
        else{
            if(t1 == null){
                return t2;
            }
            else{
                return t1;
            }

        }
        if(t1.left == null || t2.left == null){
            if(t1.left == null)
                result.left = solution(null, t2.left);
            else
                result.left = solution(t1.left, null);
        }
        else
            result.left = solution(t1.left, t2.left);

        if(t1.right == null || t2.right == null){
            if(t1.right == null)
                result.right = solution(null, t2.right);
            else
                result.right = solution(t1.right, null);
        }
        else
            result.right = solution(t1.right, t2.right);

        return result;
    }
}


