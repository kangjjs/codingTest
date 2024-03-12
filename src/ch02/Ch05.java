package ch02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Ch05 {
    public String solution(String[] votes, int k) {
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String vote : votes) {
            String x = vote.split(" ")[0];
            String y = vote.split(" ")[1];
            voteHash.putIfAbsent(x, new HashSet<String>());
            voteHash.get(x).add(y);
            candidate.put(y, candidate.getOrDefault(y, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for (String x : voteHash.keySet()) {
            int cnt = 0;
            for (String y : voteHash.get(x)) {
                if (candidate.get(y) >= k)
                    cnt++;
            }
            present.put(x, cnt);
            max = Math.max(max, cnt);
        }
        ArrayList<String> tmp = new ArrayList<>();

        for(String x : present.keySet()){
            if(present.get(x)==max){
                tmp.add(x);
            }
        }

        Collections.sort(tmp);
        answer = tmp.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
