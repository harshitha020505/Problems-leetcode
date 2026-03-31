import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] word = new char[n + m - 1];
        Arrays.fill(word, 'a');
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'T'){
                for(int j = i; j < i + m; j++){
                    if(word[j] == 'a' || word[j] == str2.charAt(j - i)){
                        word[j] = str2.charAt(j - i);
                    } else {
                        return "";
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'F'){
                boolean match = true;

                for(int j = 0; j < m; j++){
                    if(word[i + j] != str2.charAt(j)){
                        match = false;
                        break;
                    }
                }

                if(match){
                    for(int j = m - 1; j >= 0; j--){
                        boolean canChange = true;
                        for(int k = 0; k < n; k++){
                            if(str1.charAt(k) == 'T'){
                                if(i + j >= k && i + j < k + m){
                                    canChange = false;
                                    break;
                                }
                            }
                        }

                        if(!canChange) continue;

                        for(char c = 'a'; c <= 'z'; c++){
                            if(c != str2.charAt(j)){
                                char old = word[i + j];
                                word[i + j] = c;
                                boolean valid = true;
                                for(int k = 0; k < n; k++){
                                    if(str1.charAt(k) == 'T'){
                                        for(int x = 0; x < m; x++){
                                            if(word[k + x] != str2.charAt(x)){
                                                valid = false;
                                                break;
                                            }
                                        }
                                        if(!valid) break;
                                    }
                                }

                                if(valid){
                                    match = false;
                                    break;
                                } else {
                                    word[i + j] = old; // revert
                                }
                            }
                        }

                        if(!match) break;
                    }

                    if(match) return "";
                }
            }
        }
        for(int i = 0; i < n; i++){
            String sub = new String(word, i, m);

            if(str1.charAt(i) == 'T'){
                if(!sub.equals(str2)) return "";
            } else {
                if(sub.equals(str2)) return "";
            }
        }

        return new String(word);
    }
}