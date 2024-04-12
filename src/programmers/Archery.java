package programmers;

class Archery {
    static int maxDiff;
    static int[] answer,Lion;
    static void dfs(int n,int[] info,int s,int L){
        if(n==L){
            int sumL = 0,sumA=0;

            for(int i=0;i<11;i++){
                if(info[i]==0 && Lion[i]==0)
                    continue;
                if(info[i]>=Lion[i])
                    sumA+=(10-i);
                else
                    sumL+=(10-i);
            }



            if(sumL>sumA){
                int diff = sumL - sumA;
                if(diff>maxDiff){
                    maxDiff=diff;
                    answer=Lion.clone();
                }else if(diff == maxDiff){
                    for(int i=10;i>=0;i--){
                        if(answer[i]>Lion[i])
                            break;
                        else if(answer[i]<Lion[i]){
                            answer=Lion.clone();
                        }
                    }
                }
            }
        }else{
            for(int i=s;i<11;i++){
                if(Lion[i]>info[i])
                    continue;
                Lion[i]++;
                dfs(n,info,i,L+1);
                Lion[i]--;
            }
        }
    }

    public int[] solution(int n, int[] info) {
        Lion = new int[11];
        answer = new int[11];
        maxDiff =0;
        dfs(n,info,0,0);
        return maxDiff==0 ? new int[]{-1}:answer;
    }
}