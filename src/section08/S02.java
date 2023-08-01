package section08;

    import java.util.Scanner;

    public class S02 {
        static int n, m,answer=Integer.MIN_VALUE;
        static int [] arr;

        public void solution(int l,int sum){
            if(sum>m)
                return;
            if(l==n){
                answer=Math.max(answer,sum);
                return;
            }else{
                solution(l+1,sum+arr[l]);
                solution(l+1,sum);
            }
        }

        public static void main(String[] args) {
            S02 T = new S02();
            Scanner kb = new Scanner(System.in);

            m = kb.nextInt();
            n = kb.nextInt();

            arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i]=kb.nextInt();
            }

            T.solution(0,0);
            System.out.print(answer);
        }
    }