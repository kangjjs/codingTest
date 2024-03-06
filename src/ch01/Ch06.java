package ch01;

class Ch06 {

    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int x : arr) {
            if (min > x) {
                min = x;
            }
        }

        return min;
    }

    public boolean isUnique(int[] arr) {
        int cnt = 0;
        int min = findMin(arr);
        for (int x : arr) {
            if (x == min)
                cnt++;
        }

        return cnt != 1;
    }

    public int findIndex(int[] arr) {
        int min = findMin(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min)
                return i;
        }
        return 0;
    }

    public int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1)
                continue;
            if (isUnique(fruit[i]))
                continue;
            for (int j = i + 1; j < n; j++) {
                if (ch[j] == 1)
                    continue;
                if (isUnique(fruit[j]))
                    continue;
                int a = findIndex(fruit[i]);
                int b = findIndex(fruit[j]);

                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        ch[i] = 1;
                        fruit[i][a]++;
                        fruit[i][b]--;
                        ch[j] = 1;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        break;
                    }
                }
            }
        }

        for (int[] x : fruit) {
            answer += findMin(x);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch06 T = new Ch06();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
