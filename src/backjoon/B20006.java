package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20006 {
    static class Room{
        int level;
        int count;
        ArrayList<Player> players = new ArrayList<>();

        public Room(int level,Player player){
            this.level = level;
            this.players.add(player);
            this.count = 1;
        }
    }

    static class Player implements Comparable<Player>{

        int level;
        String name;

        public Player(int level,String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return (this.name).compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Room> dq = new ArrayDeque<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean check = false;

            for(Room room:dq){
                if(Math.abs(level-room.level)<=10 & room.count < m){
                    room.players.add(new Player(level,name));
                    room.count+=1;
                    check = true;
                    break;
                }
            }

            if(!check){
                dq.addLast(new Room(level,new Player(level,name)));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Room room:dq){
            if(room.count == m){
                sb.append("Started!").append('\n');
            }else{
                sb.append("Waiting!").append('\n');
            }

            Collections.sort(room.players);

            for (int i = 0; i < room.players.size(); i++) {
                sb.append(room.players.get(i).level).append(" ").append(room.players.get(i).name).append('\n');
            }
        }
        System.out.print(sb);
    }
}
