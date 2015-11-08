
public class WordDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class DictNode {
    private DictNode[] children;
    private boolean isWord;
    public DictNode() {
        children = new DictNode[26];
    }
    
    public void add(String word) {
        int len = word.length();
        DictNode curr = this;
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new DictNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(this, word);
    }
    
    private boolean searchHelper(DictNode root, String word) {
        int len = word.length();
        if (len == 0) return root.isWord;
        
        char c = word.charAt(0);
        int idx = c - 'a';
        
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    if (searchHelper(root.children[i], word.substring(1)))
                        return true;
                }
            }
        } else {
            if (root.children[idx] != null) {
                return searchHelper(root.children[idx], word.substring(1));
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");