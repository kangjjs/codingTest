package section07;

import java.util.*;

class S08 {

    static int n, m;
    static int[] ch;
    int[] dis = {-1, 1, 5};
    Queue<Integer> queue =new LinkedList<>();

    public int solution(int n,int m) {

        int l=0;
        ch[n]=1;
        queue.offer(n);

        while(!queue.isEmpty()){
            int len=queue.size();

            for(int i=0;i<len;i++){
                int x= queue.poll();

                for(int j=0;j<3;j++){
                    int nx=x+dis[j];

                    if(nx==m)
                        return l+1;
                    if(nx>=1&&nx<=10000&&ch[nx]==0){
                        ch[nx]=1;
                        queue.offer(nx);
                    }
                }
            }

            l++;
        }

        return 0;
    }


    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();

        ch = new int[10001];
        System.out.print(T.solution(n,m));
    }
}
