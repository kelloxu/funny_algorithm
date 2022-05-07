from com.nari.algorithm.model.LinkNode import LinkNode


def reverse(head: LinkNode) -> LinkNode:

    # 方法1：迭代，直至最后一个节点
    # cur, prev = head, None
    # while cur:
    #
    #     # 通过中间变量实现数据交换
    #     # temp = cur.next
    #     # cur.next = prev
    #     # prev = cur
    #     # cur = temp
    #
    #     # 利用 python 特性，简洁、搞笑实现数据交换
    #     cur.next, prev, cur = prev, cur, cur.next
    # return prev

    # 方法2：递归
    return reverse_recursion(head)


def reverse_recursion(cur: LinkNode, prev: LinkNode = None) -> LinkNode:
    """
    递归方法
    :param cur: 当前节点
    :param prev: 前继节点
    :return: 结果（头节点head）
    """

    # 递归终止条件
    if cur is None:
        return prev

    # 每个子问题都做相同处理：
    #   调换next指针——将原来指向后继节点的指针断开，重新指向前继节点
    #   当前节点移动到下一个节点
    cur.next, prev, cur = prev, cur, cur.next

    # 递归调用
    return reverse_recursion(cur, prev)


def main():
    node5 = LinkNode(12, None)
    node4 = LinkNode(3, node5)
    node3 = LinkNode(7, node4)
    node2 = LinkNode(4, node3)
    node1 = LinkNode(8, node2)

    res = reverse(node1)
    while res:
        print("{}->".format(res.val), end="")
        res = res.next
    print("NULL")


if __name__ == '__main__':
    main()
