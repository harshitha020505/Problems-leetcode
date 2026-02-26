class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
        while(!st.isEmpty() && k>0 && (st.peek()-'0')>(num.charAt(i)-'0')){
            st.pop();
            k--;
        }
        st.push(num.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        String str="";
        while(!st.isEmpty()){
            char a=st.pop();
            
            str+=a;
            
        }
        
       String str1 = new StringBuilder(str).reverse().toString();
        str1 = str1.replaceFirst("^0+(?!$)", "");
        if(str1.length()==0){
            return "0";
        }
        return str1;
        
    }
}