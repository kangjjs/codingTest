package programmers;

public class Elevator {
    public int solution(int storey) {
        int ans = 0;
        while(storey>0){
            int digit = storey%10;
            storey = storey/10;

            if(digit == 5){
                if(storey % 10 >=5){
                    ans = ans+ (10 - digit);
                    storey++;
                }else{
                    ans = ans+ digit;
                }
            }else if(digit>5){
                ans = ans + (10 - digit);
                storey++;
            }else{
                ans = ans + digit;
            }
        }

        return ans;
    }
}
