"""
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/design-linked-list/
说明：原题是使用单向链表或双向链表的结构来设计链表，本代码只使用双向链表来设计。
"""

from com.nari.algorithm.model.DoubleLinkNode import Node


class MyLinkedList:

    def __init__(self):
        """
        构造函数，创建三个私有变量，并初始化
        """

        self._head, self._tail = Node(0), Node(0)  # 虚拟节点
        self._head.next, self._tail.prev = self._tail, self._head  # 首指向尾，尾指向首
        self._count = 0  # 记录节点数

    def _get_node(self, index: int) -> Node:
        """
        私有函数：根据索引获取节点
        :param index: 索引
        :return: 节点
        """

        if index >= self._count // 2:

            # index 位于链表后半部分，从尾部往前找
            node = self._tail
            for _ in range(self._count - index):
                node = node.prev
        else:

            # index 位于链表前半部分，从头部往后找
            node = self._head
            for _ in range(index + 1):
                node = node.next

        return node

    def get(self, index: int) -> int:
        """
        根据索引获取节点，通过调用私有函数 _get_node() 来实现
        :param index: 索引
        :return: 节点的值
        """
        if 0 <= index < self._count:
            node = self._get_node(index)
            return node.val
        else:
            return -1

    def _add_new_node(self, prev_node: Node, next_node: Node, new_node: Node) -> None:
        """
        抽象的公共函数：添加新节点
        :param prev_node: 新节点的前一个节点
        :param next_node: 新节点的后一个节点
        :param new_node: 新节点
        :return: None
        """
        self._count += 1
        prev_node.next, next_node.prev, new_node.prev, new_node.next = new_node, new_node, prev_node, next_node

    def add_at_head(self, val: int) -> None:
        """
        在链表头部增加一个节点
        :param val: 待添加的节点的值
        :return: None
        """

        self._add_new_node(self._head, self._head.next, Node(val))

    def add_at_tail(self, val: int) -> None:
        """
        在链表尾部增加一个节点
        :param val: 待添加的节点的值
        :return: None
        """

        self._add_new_node(self._tail.prev, self._tail, Node(val))

    def add_at_index(self, index: int, val: int) -> None:
        """
        在指定索引处添加一个节点
        :param index: 索引
        :param val: 待添加的节点的值
        :return: None
        """

        if index <= 0:
            self.add_at_head(val)
            return
        elif index == self._count:
            self.add_at_tail(val)
            return
        elif index > self._count:  # 注意，这里不能包括等号
            return

        node = self._get_node(index)
        self._add_new_node(node.prev, node, Node(val))

    def delete_at_index(self, index: int) -> None:
        """
        删除指定索引处的节点
        :param index: 索引
        :return: None
        """

        if 0 <= index < self._count:
            node = self._get_node(index)
            self._count -= 1
            node.prev.next, node.next.prev = node.next, node.prev

    def get_head(self) -> Node:
        return self._head

    def get_count(self) -> int:
        return self._count
