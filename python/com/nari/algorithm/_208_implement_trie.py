from com.nari.algorithm.model.Trie import Trie


def main():
    trie = Trie()
    words = ["hello", "world", "deep", "learning", "auto", "spring", "describe", "decide"]
    for w in words:
        trie.insert(w)
    print(trie.search("learning"))
    print(trie.search("describe"))
    print(trie.starts_with("dec"))
    print(trie.starts_with("dei"))


if __name__ == '__main__':
    main()
