package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[n+1];
        for(int i=1;i<=n;i++){
            int counts = Integer.parseInt(st.nextToken());
            for(int j=1;j<=n;j++){
                if(counts==0){
                    if(line[j]==0){
                        line[j]=i;
                        break;
                    }
                }else if(line[j]==0){
                    counts--;
                }
            }
        }

        for(int i=1;i<=n;i++){
            System.out.print(line[i]+" ");
        }
    }
}
