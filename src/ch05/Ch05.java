package ch05;

import java.util.*;

class Ch05 {

    static class Unit implements Comparable<Unit> {
        int num, attack;
        String team;

        public Unit(int num, String team, int attack) {
            this.num = num;
            this.team = team;
            this.attack = attack;
        }

        @Override
        public int compareTo(Unit o) {
            return o.attack - this.attack;
        }
    }

    public int[] solution(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Unit> units = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String team = students[i].split(" ")[0];
            int attack = Integer.parseInt(students[i].split(" ")[1]);
            units.add(new Unit(i, team, attack));
        }
        Collections.sort(units);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(units.get(i).attack==units.get(j).attack)
                    continue;
                if(units.get(i).team.equals(units.get(j).team))
                    continue;
                answer[units.get(i).num]+=units.get(j).attack;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
