from com.nari.algorithm.model.LinkNode import LinkNode


def reverse(head: LinkNode) -> LinkNode:
    cur, prev = head, None

    # 迭代，直至最后一个节点
    while cur:
        temp = cur.next
        cur.next = prev
        prev = cur
        cur = temp

        # cur.next, prev, cur = prev, cur, cur.next
    return prev


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
