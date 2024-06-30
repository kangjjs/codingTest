package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2304 {

    static class Pillar implements Comparable<Pillar>{
        int pos,height;

        public Pillar(int pos,int height){
            this.pos=pos;
            this.height=height;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.pos-o.pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pillar> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Pillar(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int a = 0;
        int pivot = 0;

        for (int i = 0; i < n; i++) {
            if(list.get(pivot).height<list.get(i).height)
                pivot = i;
        }

        int highIndex = 0;
        for (int i = 0; i <= pivot ; i++) {
            if(list.get(highIndex).height<=list.get(i).height){
                a += (list.get(i).pos - list.get(highIndex).pos) * list.get(highIndex).height;
                highIndex = i;
            }
        }

        highIndex = n - 1;
        for (int i = n-1; i >=pivot ; i--) {
            if(list.get(highIndex).height <= list.get(i).height){
                a += (list.get(highIndex).pos-list.get(i).pos) * list.get(highIndex).height;
                highIndex = i;
            }
        }

        a+=list.get(pivot).height;
        System.out.println(a);
    }
}
