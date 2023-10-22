package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {

    static int n,m;
    static char[] c;
    static char[] ans;

    public boolean check(char [] a){
        int x=0,y=0;

        for (char value : a) {
            if (value == 'a' || value == 'o' || value == 'e' || value == 'u' || value == 'i')
                x++;
            else
                y++;
        }

        return x>=1&&y>=2;
    }

    public void solution(int l,int k) {
        if(l==n){
            if(check(ans)) {
                System.out.println(ans);
            }
        }else{
            for(int i=k;i<m;i++){
                ans[l]=c[i];
                solution(l+1,i+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        B1759 T = new B1759();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        c = new char[m];
        ans = new char[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            c[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(c);

        T.solution(0,0);
    }
}
