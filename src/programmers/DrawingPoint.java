package programmers;

public class DrawingPoint {
    public long solution(int k, int d) {
        long answer = 0;
        long x = (long) d * d;
        for(int i=0;i<=d;i+=k){
            long y = (long) i*i;
            long t = (long) Math.sqrt(x-y);
            answer += (t/k)+1;
        }

        return answer;
    }
}
