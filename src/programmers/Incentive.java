package programmers;

import java.util.*;

public class Incentive {
    public int solution(int[][] scores) {
        int n = scores[0][0];
        int m = scores[0][1];

        Arrays.sort(scores,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else{
                return o2[0]-o1[0];
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        int max = scores[0][1];
        list.add(scores[0][0]+scores[0][1]);
        for(int i=1;i<scores.length;i++){
            if(max>scores[i][1]){
                if(scores[i][0]==n&&scores[i][1]==m)
                    return -1;
            }
            else{
                max = scores[i][1];
                list.add(scores[i][0]+scores[i][1]);
            }
        }

        int ans = 1;
        list.sort(Comparator.reverseOrder());
        for(int x:list){
            if(x>n+m)
                ans++;
            else
                break;
        }

        return ans;
    }
}
