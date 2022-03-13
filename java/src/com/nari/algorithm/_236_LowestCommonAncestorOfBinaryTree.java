package com.nari.algorithm;

import com.nari.algorithm.model.TreeNode;

/**
 * PACKAGE_NAME: com.nari.algorithm
 * User: xujiong
 * Date: 2022/3/13
 * Time: 11:27
 * Description:
 */
public class _236_LowestCommonAncestorOfBinaryTree {


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode right = lowestCommonAncestor(root.getRight(), p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        //       23
        //    5       7
        // 2   9   4   3
        TreeNode node31 = new TreeNode(2);
        TreeNode node32 = new TreeNode(9);
        TreeNode node33 = new TreeNode(4);
        TreeNode node34 = new TreeNode(3);
        TreeNode node21 = new TreeNode(5, node31, node32);
        TreeNode node22 = new TreeNode(7, node33, node34);
        TreeNode node11 = new TreeNode(23, node21, node22);
        System.out.println(lowestCommonAncestor(node11, node21, node32).getVal());
    }
}
