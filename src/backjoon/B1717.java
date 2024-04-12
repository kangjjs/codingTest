package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {

    static int[] unf;
    public static int Find(int v){
        if(v==unf[v])
            return v;
        return unf[v]=Find(unf[v]);
    }

    public static void Union(int a,int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)
            unf[fb]=fa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int i=0;i<n+1;i++){
            unf[i]=i;
        }
        StringBuilder sb =new StringBuilder();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x==0){
                Union(y,z);
            }else{
                int fy = Find(y);
                int fz = Find(z);
                if(fy==fz) {
                    sb.append("yes\n");
                } else
                    sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}
