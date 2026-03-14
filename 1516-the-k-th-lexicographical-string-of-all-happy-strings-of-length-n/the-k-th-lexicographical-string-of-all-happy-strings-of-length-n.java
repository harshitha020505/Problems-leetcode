class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> lst=new ArrayList<>();
        generate("",n,lst);
         Collections.sort(lst);
         if(k>lst.size()) return "";
         return lst.get(k-1);
    }
    public boolean isHappy(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
    public void generate(String s ,int n,List<String> lst ){
        if(s.length()>n){
            return;
        }
        if(s.length()==n) {
            if(isHappy(s)){
            lst.add(s);}
        return;
        }
        generate(s+"a",n,lst);
        generate(s+"b",n,lst);
        generate(s+"c",n,lst);
        

    }
}