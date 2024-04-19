package programmers;

import java.util.*;

public class NotSameNum {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()){
                st.push(arr[i]);
                list.add(arr[i]);
                continue;
            }

            if(st.peek()==arr[i])
                continue;
            else{
                st.push(arr[i]);
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}