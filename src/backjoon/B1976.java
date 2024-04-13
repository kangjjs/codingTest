package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976 {

    static int[] unf;

    public static int Find(int v){
        if(v==unf[v])
            return v;
        return unf[v]=Find(unf[v]);
    }

    public static void Union(int x,int y){
        int fx = Find(x);
        int fy = Find(y);
        if(fx!=fy){
            unf[fx]=fy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        unf = new int[n+1];
        for(int i=0;i<=n;i++){
            unf[i]=i;
        }

        for (int i = 1; i <=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                if(Integer.parseInt(st.nextToken())==1){
                    Union(i,j);
                }
            }
        }

        StringTokenizer st =new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            if(Find(start)!=Find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
