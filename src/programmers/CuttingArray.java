package programmers;

public class CuttingArray {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];

        int j =0;
        for(long i=left;i<=right;i++){
            long x = i / n + 1;
            long y = i % n + 1;
            answer[j++] = (int) Math.max(x,y);
        }

        return answer;
    }
}
