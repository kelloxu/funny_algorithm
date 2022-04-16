package com.nari.algorithm;

import com.nari.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _102_BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int current_level_size = queue.size();
            List<Integer> current_node_vals = new ArrayList<>();
            for (int i = 0; i < current_level_size; i++) {
                TreeNode currNode = queue.poll();
                assert currNode != null;
                current_node_vals.add(currNode.getVal());
                if (currNode.getLeft() != null) {
                    queue.add(currNode.getLeft());
                }
                if (currNode.getRight() != null) {
                    queue.add(currNode.getRight());
                }
            }
            res.add(current_node_vals);
        }

        return res;
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
        System.out.println(levelOrder(node11));
    }

}
