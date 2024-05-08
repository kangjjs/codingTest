package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B20920 {

    static class Dictionaries implements Comparable<Dictionaries>{
        String word;
        int len, cnt;

        public Dictionaries(String word, int cnt) {
            this.word = word;
            this.len = word.length();
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Dictionaries o) {
            if(o.cnt==this.cnt&&o.len==this.len)
                return this.word.compareTo(o.word);
            if(o.cnt==this.cnt){
                return o.len - this.len;
            }
            return o.cnt-this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<Dictionaries> dictionaries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            hm.put(word,hm.getOrDefault(word,0)+1);
        }

        for(String word:hm.keySet()){
            if(word.length()<m)
                continue;
            dictionaries.add(new Dictionaries(word,hm.get(word)));
        }

        Collections.sort(dictionaries);
        StringBuilder sb = new StringBuilder();
        for(Dictionaries d : dictionaries){
            sb.append(d.word).append('\n');
        }

        System.out.print(sb);
    }
}
