package programmers;

    class WalkingPark {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            int n = park.length;
            int m = park[0].length();
            char[][] map =new char[n][m];
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};

            for(int i=0;i<n;i++){
                map[i]=park[i].toCharArray();
            }

            for(int i=0;i<n;i++){
                boolean flag = false;
                for(int j=0;j<m;j++){
                    if(map[i][j]=='S'){
                        answer[0]=i;
                        answer[1]=j;
                        flag=true;
                        break;
                    }
                }
                if(flag)
                    break;
            }

            for(String next:routes){
                char op = next.split(" ")[0].charAt(0);
                int cnt = Integer.parseInt(next.split(" ")[1]);

                if(op=='E'){
                    int nx = answer[0];
                    int ny = answer[1];
                    boolean flag =false;
                    for(int i=0;i<cnt;i++){
                        nx += dx[0];
                        ny += dy[0];

                        if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]=='X'){
                            flag=true;
                            break;
                        }
                    }
                    if(flag)
                        continue;
                    answer[0] = nx;
                    answer[1] = ny;
                }else if(op=='W'){
                    int nx = answer[0];
                    int ny = answer[1];
                    boolean flag =false;
                    for(int i=0;i<cnt;i++){
                        nx += dx[1];
                        ny += dy[1];

                        if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]=='X'){
                            flag=true;
                            break;
                        }
                    }
                    if(flag)
                        continue;
                    answer[0] = nx;
                    answer[1] = ny;
                }else if(op=='S'){
                    int nx = answer[0];
                    int ny = answer[1];
                    boolean flag =false;
                    for(int i=0;i<cnt;i++){
                        nx += dx[2];
                        ny += dy[2];

                        if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]=='X'){
                            flag=true;
                            break;
                        }
                    }
                    if(flag)
                        continue;
                    answer[0] = nx;
                    answer[1] = ny;
                }else if(op=='N'){
                    int nx = answer[0];
                    int ny = answer[1];
                    boolean flag =false;
                    for(int i=0;i<cnt;i++){
                        nx += dx[3];
                        ny += dy[3];

                        if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]=='X'){
                            flag=true;
                            break;
                        }
                    }
                    if(flag)
                        continue;
                    answer[0] = nx;
                    answer[1] = ny;
                }
            }

            return answer;
        }

    public static void main(String[] args) {
        WalkingPark t = new WalkingPark();
        for(int x:t.solution(new String[]{"SOO","OOO","OOO"},new String[]{"E 2","S 2","W 1"})){
            System.out.print(x+" ");
        }

        for(int x:t.solution(new String[]{"SOO","OXX","OOO"},new String[]{"E 2","S 2","W 1"})){
            System.out.print(x+" ");
        }

        for(int x:t.solution(new String[]{"OSO","OOO","OXO","OOO"},new String[]{"E 2","S 3","W 1"})){
            System.out.print(x+" ");
        }
    }
}
