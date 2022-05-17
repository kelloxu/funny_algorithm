from com.nari.algorithm.model.LinkNode import LinkNode


def swap_paris(head: LinkNode) -> LinkNode:
    # 新增虚节点，指向 head
    dummy = LinkNode(0)
    dummy.next = head

    # cur 指向虚节点
    cur = dummy

    # 开始迭代
    # 1. 当 cur.next = None 时，说明已经遍历到最后一个节点，迭代可以结束了
    # 2. 当 cur.next = None 时，说明链表的节点数是奇数，还剩最后一个节点，无法交换了，迭代也可以结束了
    while cur.next and cur.next.next:
        cur.next, cur.next.next, cur.next.next.next = cur.next.next, cur.next, cur.next.next.next
        cur = cur.next.next  # cur 向后移动两个节点，准备下一轮迭代
    return dummy.next


def main():
    node5 = LinkNode(5, None)
    node4 = LinkNode(4, node5)
    node3 = LinkNode(3, node4)
    node2 = LinkNode(2, node3)
    node1 = LinkNode(1, node2)
    res = swap_paris(node1)
    while res:
        print("{}->".format(res.val), end="")
        res = res.next
    print("NULL")


if __name__ == '__main__':
    main()
