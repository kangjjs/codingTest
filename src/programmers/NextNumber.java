package programmers;

public class NextNumber {
    public int solution(int[] common) {
        int d = 0,ans=0;
        if(common[1]-common[0]==common[2]-common[1]){
            d = common[1]-common[0];
            ans = common[common.length-1] + d;
        }else if(common[1]/common[0]==common[2]/common[1]){
            d = common[1]/common[0];
            ans = common[common.length-1] * d;
        }

        return ans;
    }
}
