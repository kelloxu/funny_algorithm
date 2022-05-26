from com.nari.algorithm.model.DoubleLinkNode import Node
from com.nari.algorithm.link._707_design_double_linked_list import MyLinkedList


def main():
    linked_list = MyLinkedList()
    linked_list.add_at_head(7)
    linked_list.add_at_head(2)
    linked_list.add_at_head(1)
    linked_list.add_at_index(3, 0)  # index 超过链表长度
    linked_list.delete_at_index(2)
    linked_list.add_at_head(6)
    linked_list.add_at_tail(4)
    print(linked_list.get(4))
    linked_list.add_at_head(4)
    linked_list.add_at_index(5, 0)
    linked_list.add_at_head(6)
    print_linked_lis(linked_list)


def print_linked_lis(lst: MyLinkedList) -> None:
    cur = lst.get_head()
    while cur.next:
        print("{}->".format(cur.val), end="")
        cur = cur.next
    print("NULL")


if __name__ == '__main__':
    main()
