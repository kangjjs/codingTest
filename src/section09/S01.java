package section09;

import java.util.*;

class People implements Comparable<People> {

    public int h;
    public int w;

    public People(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(People o) {
        return o.h-this.h;
    }
}

class S01 {

    public int solution(int n,ArrayList<People> arrayList){
        int answer=1;
        Collections.sort(arrayList);

        int max= arrayList.get(0).w;

        for(int i=1;i<n;i++){
            if(arrayList.get(i).w>max){
                max=arrayList.get(i).w;
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        S01 T = new S01();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<People> arrayList =new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            arrayList.add(new People(h,w));
        }

        System.out.print(T.solution(n,arrayList));
    }
}

