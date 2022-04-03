package com.nari.algorithm;

import com.nari.algorithm.model.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PACKAGE_NAME: com.nari.algorithm
 * User: xujiong
 * Date: 2022/4/3
 * Time: 15:04
 * Description: 实给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *              单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格
 *              内的字母在一个单词中不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _212_Word_Search_II {

    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        // 将所有单词插入到字典树中
        for (String word: words) {
            trie.insert(word);
        }

        // board 为二维数组，可以理解为矩阵，m表示行数，n表示列数
        int m = board.length;
        int n = board[0].length;

        // 标识board中被访问过的字符
        boolean[][] visited = new boolean[m][n];

        // 遍历board，作为深度优先搜索的起始点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        // Set 转为 List 返回
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (visited[x][y]) return;
        str += board[x][y];
        if (!trie.startsWith(str)) return;
        if (trie.search(str)) res.add(str);
        visited[x][y] = true; // (x, y) 已访问

        // 继续访问（x, y） 周围相邻的四个节点
        dfs(board, visited, str, x - 1, y, trie); // 向左搜索
        dfs(board, visited, str, x + 1, y, trie); // 向右搜索
        dfs(board, visited, str, x, y - 1, trie); // 向上搜索
        dfs(board, visited, str, x, y + 1, trie); // 向下搜索

        // (x, y) 恢复成未访问
        visited[x][y] = false;
    }

    public static void main(String[] args) {

        // 4行4列
        // o a a n
        // e t a e
        // i h k r
        // i f l v
//        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};

        // 1行2列
        char[][] board = {{'a','a'}};
        String[] words = {"a"};

        _212_Word_Search_II search = new _212_Word_Search_II();
        System.out.println(search.findWords(board, words));
    }
}
