package section06;

import java.util.*;

class Point implements Comparable<Point>{

    public int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x==o.x)
            return this.y-o.y;
        else
            return this.x-o.x;
    }
}
class S07 {

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Point> arrayList =new ArrayList<>();

        for(int i=0;i<n;i++){
            int x=kb.nextInt();
            int y=kb.nextInt();
            arrayList.add(new Point(x,y));
        }

        Collections.sort(arrayList);

        for(Point p: arrayList){
            System.out.println(p.x+" "+p.y);
        }
    }
}

