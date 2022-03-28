"""
* PACKAGE_NAME: com.nari.algorithm
* User: xujiong
* Date: 2022/3/28
* Time: 11:12
* Description: scala语言实现字典树, Word and prefix consist only of lowercase English letters.
"""
import string


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: string):
        cur_node = self.root
        for c in word:
            asc_ii = ord(c)  # 将字符转为 ascii 码
            if cur_node.children.get(asc_ii) is None:
                cur_node.children[asc_ii] = TrieNode()
            cur_node = cur_node.children[asc_ii]
        cur_node.isWord = True

    def search(self, word: string):
        cur_node = self.root
        for c in word:
            asc_ii = ord(c)
            if cur_node.children.get(asc_ii) is None:
                return False
            cur_node = cur_node.children[asc_ii]
        return cur_node.isWord

    def starts_with(self, prefix: string):
        cur_node = self.root
        for c in prefix:
            asc_ii = ord(c)
            if cur_node.children.get(asc_ii) is None:
                return False
            cur_node = cur_node.children[asc_ii]
        return True


class TrieNode:
    def __init__(self):
        self.isWord = False
        self.children = {}  # 用字典，代码更简洁，字符也不受限制，但是性能会差点
