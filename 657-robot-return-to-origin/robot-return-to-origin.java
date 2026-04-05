class Solution {
    public boolean judgeCircle(String moves) {
        int cUp=0 ,cDown=0;
        int cLeft=0,cRight=0;

        if(moves.length() < 2) return false;

        for(int i=0; i<moves.length(); i++){
            int ch=moves.charAt(i);
            if(ch=='U'){
                cUp++;
            }else if(ch=='D'){
                cDown++;
            
            }else if(ch=='L'){
                cLeft++;
            }else{
                cRight++;
            }
        }

        if((cUp==cDown) && (cLeft==cRight))  return true;
        return false;
    }
}