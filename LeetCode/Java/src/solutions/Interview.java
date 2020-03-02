package solutions;

import java.util.Stack;

public class Interview {
    /**
     * alibaba
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * @param str
     * @return
     */
    public boolean isValid(String str) {
        if(str == "" || str == null)return true;
        Stack<Character> st = new Stack<>();
        int len = str.length();
        for(int i = 0 ; i < len ; i++){
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else if(st.isEmpty() || Math.abs(st.pop() - c) > 2){
                return false;
            }
        }
        return st.isEmpty();
    }
}
