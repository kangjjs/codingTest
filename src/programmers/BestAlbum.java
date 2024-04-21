package programmers;

import java.util.*;

class BestAlbum {

    static class Music implements Comparable<Music>{
        String genre;
        int play;

        public Music(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music m){
            return m.play-this.play;
        }
    }

    static class OrderMusic implements Comparable<OrderMusic>{
        String genre;
        int play;
        int idx;

        public OrderMusic(String genre, int play,int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }

        @Override
        public int compareTo(OrderMusic m){
            if(this.play==m.play)
                return this.idx-m.idx;
            return m.play-this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> time = new HashMap<>();
        int n = genres.length;
        for(int i=0;i < n ; i++){
            time.put(genres[i],time.getOrDefault(genres[i],0)+plays[i]);
        }
        ArrayList<Music> list = new ArrayList<>();

        for(String x : time.keySet()){
            list.add(new Music(x,time.get(x)));
        }

        Collections.sort(list);
        ArrayList<OrderMusic> om = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(Music m : list){
            for(int i=0; i< n;i++){
                if(m.genre.equals(genres[i])){
                    om.add(new OrderMusic(m.genre,plays[i],i));
                }
            }
            Collections.sort(om);
            if(om.size()>=2){
                ans.add(om.get(0).idx);
                ans.add(om.get(1).idx);
            }else{
                ans.add(om.get(0).idx);
            }

            om.clear();
        }

        int[] answer = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}