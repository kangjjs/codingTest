package programmers;

class Trio {

    static boolean[] check;
    static int ans;

    public void dfs(int sum,int l,int len,int s,int[] number){
        if(l==3){
            if(sum==0)
                ans++;
        }else{
            for(int i=s;i<len;i++){
                if(!check[i]){
                    check[i] = true;
                    dfs(sum+number[i],l+1,len,i,number);
                    check[i] = false;
                }
            }
        }
    }

    public int solution(int[] number) {
        int len = number.length;
        check = new boolean[len];
        ans = 0;
        dfs(0,0,len,0,number);
        return ans;
    }
}