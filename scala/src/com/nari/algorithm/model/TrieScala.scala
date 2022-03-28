package com.nari.algorithm.model

/**
 * PACKAGE_NAME: com.nari.algorithm
 * User: xujiong
 * Date: 2022/3/28
 * Time: 11:12
 * Description: scala语言实现字典树, Word and prefix consist only of lowercase English letters.
 */
class TrieScala {

  class TrieNode {
    var isWord: Boolean = false;
    var children: Array[TrieNode] = new Array[TrieNode](26);
  }

  var root: TrieNode = new TrieNode()

  /**
   * 向字典树中插入单词 word
   *
   * @param word 待插入的单词
   */
  def insert(word: String): Unit = {
    var curNode = root
    for (c <- word) {
      val ascii = c - 'a'
      if (curNode.children(ascii) == null) curNode.children(ascii) = new TrieNode()
      curNode = curNode.children(ascii)
    }
    curNode.isWord = true
  }

  /**
   * 在字典树中搜索 word
   *
   * @param word 带搜索的单词
   * @return 是否搜索到
   */
  def search(word: String): Boolean = {
    var curNode = root
    for (c <- word) {
      val ascii = c - 'a'
      if (curNode.children(ascii) == null) return false
      curNode = curNode.children(ascii)
    }
    curNode.isWord
  }

  /**
   * @param prefix 前缀
   * @return 字典树中是否包含前缀为 prefix 的单词
   */
  def startsWith(prefix: String): Boolean = {
    var curNode = root
    for (c <- prefix) {
      val ascii = c - 'a'
      if (curNode.children(ascii) == null) return false
      curNode = curNode.children(ascii)
    }
    true
  }
}
