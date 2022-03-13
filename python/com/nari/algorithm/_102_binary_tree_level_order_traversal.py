"""
* 题目地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
* 题目概述：Given the root of a binary tree, return the level order traversal of
*         its nodes' values. (i.e., from left to right, level by level).

* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/3sum
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

from collections import deque
from com.nari.algorithm.model.Node import Node


def level_order(root):
    if not root:
        return []

    result = []  # 二维数组
    queue = deque()  # 双端队列，存放当前层的节点
    queue.append(root)  # 根节点对象（第一层）首先入列

    while queue:
        current_level_size = len(queue)  # 当前层节点数目，为下文for循环的次数
        current_level_node_vals = []  # 存放当前层节点的值
        for _ in range(current_level_size):
            node = queue.popleft()  # 始终从队列左端弹出本层的节点
            current_level_node_vals.append(node.val)
            if node.left:
                queue.append(node.left)  # 下一层的新节点放在队列尾部
            if node.right:
                queue.append(node.right)  # 下一层的新节点放在队列尾部
        result.append(current_level_node_vals)

    return result


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
    print(level_order(node11))


if __name__ == '__main__':
    main()
