package programmers;

public class Bandage {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int cnt;
        for(int i=0;i<attacks.length;i++){
            if (i != 0) {
                cnt = attacks[i][0] - attacks[i - 1][0] - 1;
                int x = cnt / bandage[0];
                health += (x * bandage[2]) + (bandage[1] * cnt);
                if (health >= maxHealth)
                    health = maxHealth;
            }
            health -= attacks[i][1];
            if(health<=0){
                return -1;
            }
        }

        return health;
    }
}
