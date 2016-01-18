import java.util.ArrayList;

class TrieNode {
    char c;
    TrieNode[] children;
    boolean isWord=false;
    
    //boolean isLeaf=false;
    public TrieNode(char ch) {
        c=ch;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null) curr.children[ch - 'a'] = new TrieNode(ch);
            
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++)
        {
            char ch = word.charAt(i);    
            if(curr.children[ch-'a'] == null) return false;
            curr=curr.children[ch-'a'];
        }
        
        return curr.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);    
            if(curr.children[ch-'a'] == null) return false;
            curr=curr.children[ch-'a'];
        }        
        
        for( TrieNode tr : curr.children)
        {
            if(tr != null) return true;
        }
        return false;
    }
    
    public ArrayList<String> getWords(String str)
    {
    	ArrayList<String> ans  = new ArrayList<>(); 
    	TrieNode curr = root;
    	if(startsWith(str)){
    		 for(int i=0; i < str.length(); i++)
    	        {
    	            char ch = str.charAt(i);        	            
    	            curr=curr.children[ch-'a'];
    	        }
    	}
    	else return ans;
    	
    	TrieNode tr;
    	
    	for(int i=0;i<26;i++)
    	{    		
    		tr = curr.children[i];
    	
    		if(tr != null) {
    			char c  = tr.c;
    			
    			if(tr.isWord){
    				ans.add(""+tr);    				
    			}
    			
    			ans.addAll(this.getWords(str+""+c));   			
    		}    		    	
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args)
    {
    	Trie tr = new Trie();
    	tr.insert("shiva");
    	tr.search("shiva");
    	tr.insert("at");
    	tr.insert("att");
    	tr.insert("attworld");
    	
    	ArrayList<String> arr =  tr.getWords("at");
    	
    	for(String a : arr)
    		System.out.print(a);
    	    	
    }
    
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");