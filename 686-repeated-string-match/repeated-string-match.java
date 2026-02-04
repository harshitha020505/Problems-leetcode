class Solution {
    public int repeatedStringMatch(String a, String b) {
        int c=0;
        String d="";
        while(d.length()<b.length()){
            d=d+a;
            c++;
        }
        if(d.contains(b)){
            return c;

        }
        c++;
        d=d+a;
        if(d.contains(b)){
            return c;
        }
        return -1;
    }
}