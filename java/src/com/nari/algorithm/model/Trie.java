package com.nari.algorithm.model;

/**
 * PACKAGE_NAME: com.nari.algorithm
 * User: xujiong
 * Date: 2022/3/26
 * Time: 11:04
 * Description: java语言实现字典树, Word and prefix consist only of lowercase English letters.
 */
public class Trie {

    class TrieNode {

        public boolean isWord;
        public TrieNode[] children;

        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }

    private final TrieNode root;

    /**
     * 构造函数
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     *  向字典树中插入单词 word
     * @param word 待插入的单词
     */
    public void insert(String word) {
        TrieNode curNode = root;  // 当前节点
        for (int i = 0; i< word.length(); i++) {
            int ascii = word.charAt(i) - 'a'; // 将字母转为 ascii 码
            if (curNode.children[ascii] == null) {
                curNode.children[ascii] = new TrieNode();
            }
            curNode = curNode.children[ascii];
        }
        curNode.isWord = true;
    }

    /**
     * 在字典树中搜索 word
     * @param word 待搜索的单词
     * @return 是否搜索到
     */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i) - 'a'; // 将字母转为 ascii 码
            if (curNode.children[ascii] == null) return false;
            curNode = curNode.children[ascii];
        }
        return curNode.isWord; // word 在字典树中为一个单词，才返回true
    }

    /**
     *
     * @param prefix 前缀
     * @return 字典树中是否包含前缀为 prefix 的单词
     */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ascii = prefix.charAt(i) - 'a'; // 将字母转为 ascii 码
            if (curNode.children[ascii] == null) return false;
            curNode = curNode.children[ascii];
        }
        return true;
    }
}
