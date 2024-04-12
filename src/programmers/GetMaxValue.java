package programmers;

class GetMaxValue {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k;
        int idx = 0;

        for(int i=0;i<len;i++){
            int max = 0;
            for(int j=idx; j<=i+k; j++){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }

            answer.append(max);
        }

        return answer.toString();
    }
}
