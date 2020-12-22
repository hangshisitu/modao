package modao.array;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrieTree {
    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(char data) {
            this.data = data;
        }
    }
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
    }

//    public List<String> find(char[] pattern) {
//        TrieNode p = root;
//        List<String> reslut = new ArrayList<String>;
//        for (int i = 0; i < pattern.length; ++i) {
//            int index = pattern[i] - 'a';
//            if (p.children[index] == null) {
//
//            }
//            p = p.children[index];
//        }
//    }

//    public boolean find(char[] pattern) {
//        TrieNode p = root;
//        for (int i = 0; i < pattern.length; ++i) {
//            int index = pattern[i] - 'a';
//            if (p.children[index] == null) {
//                return false;
//            }
//            p = p.children[index];
//        }
////        if (p.isEndingChar == false)
////        {
////            return false;
////        }
////        else
////        {
////            return true;
////        }
//    }


    public List<String> buildResult(TrieNode p, String prefix)
    {
        List<String> result = new ArrayList<>();
        Stack<Character> path = new Stack<>();
        backTrace(p,result,prefix,path);
        return result;
    }
    public void backTrace(TrieNode p, List<String> result, String prefix,Stack<Character> path)
    {
        if(p == null)
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prefix);
            for(int i=0; i<path.size();++i)
            {
                stringBuilder.append(path.elementAt(i));
            }
            return;
        }
        for(int i=0; i<p.children.length;++i)
        {
            if(p.children[i]!=null)
            {
//                path.push((Character)(i+'a'));
//                backTrace(p.children[i],result,path);
                path.pop();
            }
        }
    }


}