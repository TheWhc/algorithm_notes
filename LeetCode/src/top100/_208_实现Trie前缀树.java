package top100;

/**
 * @ClassName: _208_实现Trie前缀树
 * @Author: whc
 * @Date: 2021/05/13/12:45
 */
public class _208_实现Trie前缀树 {

	/**
	 * 思路:
	 *
	 * 时间: O(len) len为入参的字符串长度
	 * 空间: O(nk)  n为结点数量  k为字符集大小 （构建每个结点需开辟额外的一个大小为k=26的数组）
	 */
	 class TrieNode{
	 	TrieNode[] children;
	 	boolean flag;
	 	public TrieNode(){
	 		children = new TrieNode[26];
	 		flag = false;
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
		}
	 }

	TrieNode root;

	/** Initialize your data structure here. */
	public _208_实现Trie前缀树() {
		this.root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		char[] chars = word.toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < chars.length; i++) {
			if(cur.children[chars[i] - 'a'] == null) {
				cur.children[chars[i] - 'a'] = new TrieNode();
			}
			cur = cur.children[chars[i] - 'a'];
		}
		// 访问标志位:当前节点代表结束
		cur.flag = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		char[] chars = word.toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < chars.length; i++) {
			if(cur.children[chars[i] - 'a'] == null) {
				return false;
			} else {
				cur = cur.children[chars[i] - 'a'];
			}
		}
		// 返回当前标志位是否为真
		return cur.flag;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		char[] chars = prefix.toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < chars.length; i++) {
			if(cur.children[chars[i] - 'a'] == null) {
				return false;
			} else {
				cur = cur.children[chars[i] - 'a'];
			}
		}
		return true;
	}
}
