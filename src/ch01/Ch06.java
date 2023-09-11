package ch01;

class S06 {

    public int findMin(int[] fruit) {
        int min = Integer.MAX_VALUE;

        for (int x : fruit) {
            min = Math.min(x, min);
        }

        return min;
    }

    public int findMinIndex(int[] fruit) {
        int min = findMin(fruit);

        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i] == min)
                return i;
        }

        return 0;
    }

    public boolean boolMin(int[] fruit) {
        int min = findMin(fruit);
        int count = 0;

        for (int x : fruit) {
            if (x == min)
                count++;
        }

        return count != 1;
    }

    public int solution(int[][] fruits) {
        int answer = 0;
        int n = fruits.length;
        int[] ch = new int[n];

        for (int i = 0; i < n; i++) {
            if (ch[i] == 1)
                continue;
            if (boolMin(fruits[i]))
                continue;
            for (int j = i + 1; j < n; j++) {
                if (ch[j] == 1)
                    continue;
                if (boolMin(fruits[j]))
                    continue;
                int x = findMinIndex(fruits[i]);
                int y = findMinIndex(fruits[j]);

                if (x != y && fruits[i][y] > 0 && fruits[j][x] > 0) {
                    if (fruits[i][x]+1<=fruits[i][y]-1 && fruits[j][y]+1<=fruits[j][x]-1) {
                        fruits[i][x]++;
                        fruits[i][y]--;
                        fruits[j][y]++;
                        fruits[j][x]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }

        for (int[] fruit : fruits) {
            answer += findMin(fruit);
        }

        return answer;
    }

    public static void main(String[] args) {
        S06 T = new S06();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}