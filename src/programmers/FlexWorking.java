package programmers;

public class FlexWorking {
    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int size = timelogs[0].length;
            int result =0;

            for(int i=0;i<schedules.length;i++){
                int a = schedules[i]%100;
                int b = schedules[i]/100;
                int limit;
                if(a>=50)
                    limit = (b+1)*100+(a+10)%60;
                else
                    limit = schedules[i]+10;
                int s = startday;
                boolean flag = true;
                for(int j=0;j<size;j++){
                    if(s>=6){
                        if(s==7)
                            s=1;
                        else
                            s++;
                    }else{
                        if(timelogs[i][j]>limit){
                            flag = false;
                            break;
                        }
                        s++;
                    }
                }

                if(flag)
                    result++;
            }

            return result;
        }
    }
}
