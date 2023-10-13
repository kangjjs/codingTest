package section06;

import java.util.*;

class S06 {

    public int[] solution(int n, int[] arr) {
        int [] answer = new int[2];
        int [] tmp = Arrays.copyOf(arr,arr.length);
        Arrays.sort(tmp);

        int cnt=0;

        for(int i=0;i<n;i++){
            if(tmp[i]!=arr[i]) {
                answer[cnt] = i + 1;
                cnt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
