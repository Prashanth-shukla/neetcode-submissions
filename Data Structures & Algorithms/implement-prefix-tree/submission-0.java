class PrefixTree {
    static class TrieNode {
        boolean isEnd;
        TrieNode children[];

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public TrieNode root;

    public PrefixTree() {
        root = new TrieNode();

    }

    public TrieNode getNode() {
        return new TrieNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = getNode();
            }
            crawler = crawler.children[idx];

        }
        crawler.isEnd = true;

    }

    public boolean search(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }

        return crawler != null && crawler.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode crawler = root;
        int i = 0;
        for (; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];

        }

        return i == prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */