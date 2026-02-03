class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        String s="11";
        
        for(int i=3;i<=n;i++){
            String str=s;
            s="";
            int c=1;
            
            for(int j=1;j<str.length();j++){
                Character a=str.charAt(j-1);
                if(str.charAt(j)==a){
                    c++;
                }
                else{
                    if(j==1){
                        s+=1;
                        s+=str.charAt(0);
                    }
                    else{
                    s+= String.valueOf(c);
                    c=1;
                    s+=String.valueOf(a);}
                }
            }
s += String.valueOf(c);
            s+=String.valueOf(str.charAt(str.length()-1));
            
        }
        return s;
    }
}