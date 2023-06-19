package ch01;

public class Ch06 {
    public int getMin(int [] fruit){
        int min=51;
        for (int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }

    public boolean boolMin(int [] fruit){
        int min=getMin(fruit);
        int count=0;
        for(int x:fruit){
            if(min==x)
                count++;
        }
        return count==1;
    }

    public int minIndex(int[] fruit){
        int min=getMin(fruit);
        if(boolMin(fruit)){
            for(int i=0;i<fruit.length;i++){
                if(min==fruit[i])
                    return i;
            }
        }

        return 0;
    }

    public int solution(int[][] fruit){
        int answer = 0;

        int n=fruit.length;
        int [] check=new int[n];

        for(int i=0;i<n;i++){
            if(check[i]==1)
                continue;
            if(!boolMin(fruit[i]))
                continue;
            for(int j=i+1;j<n;j++){
                if(check[j]==1)
                    continue;
                if(!boolMin(fruit[j]))
                    continue;
                int x=minIndex(fruit[i]);
                int y=minIndex(fruit[j]);

                if(x!=y){
                    if(fruit[i][x]+1<=fruit[i][y]-1&&fruit[j][y]+1<=fruit[j][x]-1){
                        fruit[i][x]++;
                        fruit[i][y]--;
                        fruit[j][x]--;
                        fruit[j][y]++;
                        check[i]=1;
                        check[j]=1;
                        break;
                    }
                }
            }
        }

        for(int []x:fruit){
            answer+=getMin(x);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch06 T = new Ch06();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
