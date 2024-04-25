package programmers;

public class Fatigue {
    static int[] check;
    static int answer;

    static void dfs(int[][] dungeons, int h, int cnt){
        for(int i=0;i<dungeons.length;i++){
            if(check[i]==0 && h>=dungeons[i][0]){
                check[i] = 1;
                dfs(dungeons,h-dungeons[i][1],cnt+1);
                check[i] = 0;
            }

            answer =Math.max(answer,cnt);
        }
    }

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        check = new int[dungeons.length];
        dfs(dungeons,k,0);
        return answer;
    }
}
