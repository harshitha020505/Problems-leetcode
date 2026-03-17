class Solution {
    public String removeOuterParentheses(String s) {
        String str="";
        int k=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                
                if(k!=0){
                    str+='(';
                }
                k++;
                
            }
            else{
                k--;
                if(k!=0){
                    str+=')';
                }
                
            }
        }
        return str;
    }
}