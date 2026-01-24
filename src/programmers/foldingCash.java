package programmers;

public class foldingCash {
    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            int walletX = wallet[0];
            int walletY = wallet[1];
            int billX = bill[0];
            int billY = bill[1];

            while(true){
                if(check(walletX,walletY,billX,billY))
                    break;
                if(billX>=billY)
                    billX/=2;
                else
                    billY/=2;
                answer++;
            }

            return answer;
        }

        static boolean check(int wX,int wY,int bX,int bY){
            if(wX>=bX && wY>=bY)
                return true;
            if(wX>=bY && wY>=bX)
                return true;
            return false;
        }
    }
}
