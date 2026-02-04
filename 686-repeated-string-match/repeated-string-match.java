class Solution {
    public int repeatedStringMatch(String a, String b) {
        int c=0;
        String d="";
        while(d.length()<b.length()){
            d=d+a;
            c++;
        }
        for(int i=0;i<2;i++){
            if(d.contains(b)){
                return c;
            }
            else{
                d=d+a;
                c++;
            }
        }
        return -1;
    }
}