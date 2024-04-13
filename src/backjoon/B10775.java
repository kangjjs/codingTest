package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10775 {

    static int[] unf;
    public static int find(int v){
        if(v==unf[v])
            return v;
        return unf[v]=find(unf[v]);
    }

    public static void Union(int x,int y){
        int fx = find(x);
        int fy = find(y);

        if(fx!=fy)
            unf[fx]=fy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        unf = new int[G+1];

        for(int i=1;i<=G;i++){
            unf[i]=i;
        }
        int ans =0;

        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);
            if(emptyGate != 0){
                ans++;
                Union(emptyGate,emptyGate-1);
            }else
                break;
        }

        System.out.println(ans);
    }
}
