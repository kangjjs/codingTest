package ch02;

import java.util.*;

class Ch05 {
    public String solution(String[] votes, int k) {
        String answer = " ";

        HashMap<String, HashSet<String>> hm = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String vote : votes) {
            String a = vote.split(" ")[0];
            String b = vote.split(" ")[1];

            hm.putIfAbsent(a, new HashSet<String>());
            hm.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for (String a : hm.keySet()) {
            int cnt = 0;

            for (String b : hm.get(a)) {
                if (candidate.get(b) >= k)
                    cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp =new ArrayList<>();
        for(String name : present.keySet()){
            if(present.get(name)==max)
                tmp.add(name);
        }

        tmp.sort(String::compareTo);
        answer=tmp.get(0);

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