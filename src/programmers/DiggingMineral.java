package programmers;

import java.util.*;

class DiggingMineral {

    static class Mineral implements Comparable<Mineral>{
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        @Override
        public int compareTo(Mineral m){
            return m.stone-this.stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {

        int[][] scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int pickCnt = Arrays.stream(picks).sum();
        List<Mineral> list = new ArrayList<>();

        for(int i=0;i<minerals.length;i+=5){
            if(pickCnt==0)
                break;
            int dia=0,iron=0,stone=0;
            for(int j=i;j<i+5;j++){
                if(j==minerals.length){
                    break;
                }
                int m = 0;
                if(minerals[j].equals("iron")){
                    m=1;
                }else if(minerals[j].equals("stone")){
                    m=2;
                }

                dia += scoreBoard[0][m];
                iron += scoreBoard[1][m];
                stone += scoreBoard[2][m];
            }
            list.add(new Mineral(dia,iron,stone));
            pickCnt--;
        }

        Collections.sort(list);

        int answer=0;
        for(Mineral m:list){
            if(picks[0]>0){
                picks[0]--;
                answer+=m.diamond;
                continue;
            }

            if(picks[1]>0){
                picks[1]--;
                answer+=m.iron;
                continue;
            }

            picks[2]--;
            answer+=m.stone;
        }

        return answer;
    }
}