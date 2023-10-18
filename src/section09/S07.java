package section09;

import java.util.*;

class Edges implements Comparable<Edges> {

    public int a, b, c;

    public Edges(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Edges o) {
        return this.c - o.c;
    }
}

class S07 {

    static int n, m;
    static int[] unf;

    public static int find(int v) {
        if (v == unf[v])
            return v;
        else
            return unf[v] = find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb)
            unf[fa] = fb;
    }

    public static void main(String[] args) {
        S07 T = new S07();
        Scanner kb = new Scanner(System.in);
        ArrayList<Edges> arrayList = new ArrayList<>();
        n = kb.nextInt();
        m = kb.nextInt();
        unf= new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arrayList.add(new Edges(a, b, c));
        }
        int answer = 0;
        Collections.sort(arrayList);

        for (Edges edges : arrayList) {
            int fv1 = find(edges.a);
            int fv2 = find(edges.b);
            if (fv1 != fv2) {
                answer += edges.c;
                Union(edges.a, edges.b);
            }
        }

        System.out.print(answer);
    }
}