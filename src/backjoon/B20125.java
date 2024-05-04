package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = x.charAt(j);
            }
        }

        int heartX = 0, heartY = 0, leftArm = 0, rightArm = 0, leftLeg = 1, rightLeg = 1, back = 0, backX = 0, backY = 0;
        boolean findHead = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!findHead && map[i][j] == '*') {
                    findHead = true;
                    heartX = i + 1;
                    heartY = j;
                    break;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{heartX, heartY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] == 0)
                break;
            if (map[cur[0]][cur[1] - 1] == '*') {
                q.offer(new int[]{cur[0], cur[1] - 1});
                leftArm++;
            }
        }

        q.offer(new int[]{heartX, heartY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] == n - 1)
                break;
            if (map[cur[0]][cur[1] + 1] == '*') {
                q.offer(new int[]{cur[0], cur[1] + 1});
                rightArm++;
            }
        }

        q.offer(new int[]{heartX, heartY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            backX = cur[0];
            backY = cur[1];
            if (map[cur[0] + 1][cur[1]] == '*') {
                q.offer(new int[]{cur[0] + 1, cur[1]});
                back++;
            }
        }

        int leftLegX = backX+1,leftLegY=backY-1;
        q.offer(new int[]{leftLegX,leftLegY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0]==n-1)
                break;
            if (map[cur[0] + 1][cur[1]] == '*') {
                q.offer(new int[]{cur[0] + 1, cur[1]});
                leftLeg++;
            }
        }

        int rightLegX = backX+1,rightLegY=backY+1;
        q.offer(new int[]{rightLegX,rightLegY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0]==n-1)
                break;
            if (map[cur[0] + 1][cur[1]] == '*') {
                q.offer(new int[]{cur[0] + 1, cur[1]});
                rightLeg++;
            }
        }
        String sb = (heartX + 1) + " " + (heartY + 1) + '\n' +
                leftArm + " " + rightArm + " " + back + " " + leftLeg + " " + rightLeg;
        System.out.println(sb);
    }
}
