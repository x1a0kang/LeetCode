public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;
        // 遍历字符串
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int index = c - 'a';
            // 如果当前字符没有，则创建一个节点
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
            // 如果是最后一个字符，则将isEnd设为true
            if (i == charArray.length - 1) {
                node.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        // 找到字符串的结尾节点，不是null且isEnd
        Node node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        // 找到字符串的结尾节点，不是null即可
        Node node = find(prefix);
        return node != null;
    }

    // 找到字符串的结尾节点
    private Node find(String str) {
        char[] charArray = str.toCharArray();
        Node node = root;
        for (char c : charArray) {
            int index = c - 'a';
            // 如果当前字符不存在，直接返回null
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static class Node {
        // 用数组模拟26个字母
        public Node[] children;
        // 当前节点是否是一个单词的结束节点
        public boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
}
