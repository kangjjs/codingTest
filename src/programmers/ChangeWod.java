package programmers;

import java.util.ArrayList;

public class ChangeWod {
    static ArrayList<String> list;
    static int n,answer;

    static void dfs(String str,String target,String[] words,int L){
        if(L>n)
            return;
        if(str.equals(target)){
            answer = Math.min(answer,L);
        }else{
            for(int i = 0; i<n;i++){
                if(diffStr(str,words[i])){
                    if(!list.contains(words[i])){
                        list.add(words[i]);
                        dfs(words[i],target,words,L+1);
                        list.remove(words[i]);
                    }
                }
            }
        }
    }

    static boolean diffStr(String str1,String str2){
        if (str1.length() != str2.length()) {
            return false;
        }

        int diffCount = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }

            if (diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        list = new ArrayList<>();
        n = words.length;
        dfs(begin,target,words,0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
