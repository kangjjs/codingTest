package programmers;
import java.util.*;

public class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        int i = 1;
        while(i<=order.length){
            st.push(i++);
            while(!st.isEmpty()){
                if(st.peek()==order[idx]){
                    st.pop();
                    idx++;
                    answer++;
                }else
                    break;
            }
        }
        return answer;
    }
}
