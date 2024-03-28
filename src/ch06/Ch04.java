package ch06;

import java.util.*;

class Ch04 {
    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> hm;
    String[] answer;
    int len;

    public void dfs() {
        if(tmp.size()==len){
            String Ts ="";
            for(char x:tmp)
                Ts+=x;
            res.add(Ts);
        }else{
            for(char x:hm.keySet()){
                if(hm.get(x)==0)
                    continue;
                tmp.addFirst(x);
                tmp.addLast(x);
                hm.put(x,hm.get(x)-2);
                dfs();
                tmp.pollFirst();
                tmp.pollLast();
                hm.put(x,hm.get(x)+2);
            }
        }
    }

    public String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        hm = new HashMap<>();
        len = s.length();

        for (char x : s.toCharArray()) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        int odd = 0;
        char ch = '#';

        for (char key : hm.keySet()) {
            if (hm.get(key) % 2 == 1) {
                ch = key;
                odd++;
            }
        }

        if (odd > 1) {
            return new String[]{};
        }

        if (ch != '#') {
            tmp.add(ch);
            hm.put(ch, hm.get(ch) - 1);
        }

        dfs();
        answer = new String[res.size()];

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch04 T = new Ch04();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
