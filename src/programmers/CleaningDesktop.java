package programmers;

public class CleaningDesktop {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rux = Integer.MIN_VALUE;
        int ruy = Integer.MIN_VALUE;

        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    lux = Math.min(lux,i);
                    luy = Math.min(luy,j);
                    rux = Math.max(rux,i);
                    ruy = Math.max(ruy,j);
                }
            }
        }

        return new int[]{lux,luy,rux+1,ruy+1};
    }
}
