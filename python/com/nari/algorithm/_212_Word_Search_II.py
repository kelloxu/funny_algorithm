"""
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
"""

import collections
from typing import List

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

END_OF_WORD = "#"


class Solution(object):

    def __init__(self):
        self.n = None
        self.m = None
        self.result = None

    def find_words(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]:
            return []
        if not words:
            return []

        self.result = set()

        '''使用字典实现一个字典树'''
        root = collections.defaultdict()
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, collections.defaultdict())
            node[END_OF_WORD] = END_OF_WORD

        self.m, self.n = len(board), len(board[0])

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)

        return list(self.result)

    def _dfs(self, board, i, j, cur_word, cur_dict):
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]

        if END_OF_WORD in cur_dict:
            self.result.add(cur_word)

        tmp, board[i][j] = board[i][j], '@'
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < self.m and 0 <= y < self.n \
                    and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        board[i][j] = tmp


if __name__ == '__main__':
    _board = [['o', 'a', 'a', 'n'], ['e', 't', 'a', 'e'], ['i', 'h', 'k', 'r'], ['i', 'f', 'l', 'v']]
    _words = ["oath", "pea", "eat", "rain", "klf"]
    solution = Solution()
    print(solution.find_words(_board, _words))
