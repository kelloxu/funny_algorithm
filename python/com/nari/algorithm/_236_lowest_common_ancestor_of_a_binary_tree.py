"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
"""

from com.nari.algorithm.model.Node import Node


def lowest_common_ancestor(root: Node, p: Node, q: Node):
    if root is None or root == p or root == q:
        return root
    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right, p, q)
    if left is None:
        return right
    elif right is None:
        return left
    else:
        return root


def main():
    #       23
    #    5       7
    #  2   9   4   3
    node31 = Node(2)
    node32 = Node(9)
    node33 = Node(4)
    node34 = Node(3)
    node21 = Node(5, node31, node32)
    node22 = Node(7, node33, node34)
    node11 = Node(23, node21, node22)
    print(lowest_common_ancestor(node11, node21, node32).val)


if __name__ == '__main__':
    main()
