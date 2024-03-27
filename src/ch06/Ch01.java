package ch06;

import java.util.ArrayList;
import java.util.Collections;

class Ch01 {

    int answer, m, target;
    ArrayList<Integer> nums;
    int[] check;
    boolean flag;

    public void DFS(int L, int number) {
        if (flag)
            return;
        if(L==m){
            if(number>target) {
                answer = number;
                flag = true;
            }
        }else{
            for (int i = 0; i < m; i++) {
                if(check[i]==0){
                    check[i]=1;
                    DFS(L+1,number*10+nums.get(i));
                    check[i]=0;
                }
            }
        }
    }

    public int solution(int n) {
        nums = new ArrayList<>();
        flag = false;
        answer = 0;
        target = n;
        int tmp = n;

        while (tmp > 0) {
            nums.add(tmp % 10);
            tmp /= 10;
        }
        m = nums.size();
        check = new int[nums.size()];

        Collections.sort(nums);
        DFS(0,0);

        if(!flag)
            return -1;
        return answer;
    }

    public static void main(String[] args) {
        Ch01 T = new Ch01();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
