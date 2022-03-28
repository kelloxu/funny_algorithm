package com.nari.algorithm;

import com.nari.algorithm.model.Trie;

/**
 * PACKAGE_NAME: com.nari.algorithm
 * User: xujiong
 * Date: 2022/3/26
 * Time: 11:04
 * Description: 实现字典树, 实现类为 TrieScala，本类用于测试验证
 *              Word and prefix consist only of lowercase English letters.
 */
public class _208_ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = new String[]{"hello", "world", "deep", "learning", "auto", "spring", "describe", "decide"};
        for (String word : words) {
            trie.insert(word);
        }
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("learning"));
        System.out.println(trie.startsWith("deep"));
        System.out.println(trie.search("dee"));
        System.out.println(trie.startsWith("descri"));
    }
}
