package programmers;

public class EscapeCommand {

    String answer="impossible";
    StringBuilder sb;
    char[] dir ={'d','l','r','u'};
    int[] dx = {1,0,0,-1};
    int[] dy = {0,-1,1,0};

    public int distance(int x,int y,int r,int c){
        return Math.abs(x-r)+Math.abs(y-c);
    }

    public void dfs(int l,int n,int m,int x,int y,int r,int c,int k){
        if(!answer.equals("impossible"))
            return;
        if((l+distance(x,y,r,c))>k)
            return;
        if(l==k){
            answer = sb.toString();
        }else{
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=1&&nx<=n&&ny>=1&&ny<=m){
                    sb.append(dir[i]);
                    dfs(l+1,n,m,nx,ny,r,c,k);
                    sb.delete(l,l+1);
                }
            }
        }
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int length = distance(x,y,r,c);
        if(length>k||(k-length)%2==1)
            return answer;
        sb = new StringBuilder();
        dfs(0,n,m,x,y,r,c,k);
        return answer;
    }
}
