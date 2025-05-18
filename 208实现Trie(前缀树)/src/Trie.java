public class Trie {
    TreeNode[] roots;
    public Trie() {
        roots = new TreeNode[26];
    }

    public class TreeNode {
        char val;
        TreeNode[] childs = new TreeNode[26];;
        boolean isEnd;
        TreeNode(char val) {
            this.val = val;
            this.isEnd = false;
        }
        void setEnd(){
            this.isEnd = true;
        }
    }

    public void insert(String word) {
        char firstChar = word.charAt(0);
        TreeNode root;
        if(roots[firstChar - 'a'] == null){
            roots[firstChar - 'a'] = new TreeNode(firstChar);
        }

        root = roots[firstChar - 'a'];
        for(int i=1; i<word.length();i++){
            char nextChar = word.charAt(i);
            if(root.childs[nextChar - 'a'] == null){
                root.childs[nextChar - 'a'] = new TreeNode(nextChar);
            }

            root = root.childs[nextChar - 'a'];
        }
        root.setEnd();
    }

    public boolean search(String word) {
        char firstChar = word.charAt(0);
        TreeNode root;
        if(roots[firstChar - 'a'] == null){
            return false;
        }

        root = roots[firstChar - 'a'];
        for(int i=1; i<word.length();i++){
            char nextChar = word.charAt(i);
            if(root.childs[nextChar - 'a'] == null){
                return false;
            }

            root = root.childs[nextChar - 'a'];
        }

        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        char firstChar = prefix.charAt(0);
        TreeNode root;
        if(roots[firstChar - 'a'] == null){
            return false;
        }

        root = roots[firstChar - 'a'];
        for(int i=1; i<prefix.length();i++){
            char nextChar = prefix.charAt(i);
            if(root.childs[nextChar - 'a'] == null){
                return false;
            }

            root = root.childs[nextChar - 'a'];
        }

        return true;

    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("abc");
    }
}
