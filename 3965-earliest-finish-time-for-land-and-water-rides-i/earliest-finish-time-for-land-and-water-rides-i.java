class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;

        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int time=landStartTime[i]+landDuration[i];
            for(int j=0; j<m; j++){
                if(waterStartTime[j]>=time){
                    
                    min=Math.min(min,waterStartTime[j]+waterDuration[j]);
                }else{
                    min=Math.min(min,time+waterDuration[j]);
                }
            }
        }
        
        for(int i=0; i<m; i++){
            int time=waterStartTime[i]+waterDuration[i];
            for(int j=0; j<n; j++){
                if(landStartTime[j]>=time){
                    
                    min=Math.min(min,landStartTime[j]+landDuration[j]);
                }else{
                    min=Math.min(min,time+landDuration[j]);
                }
            }
        }

        
        

        return min;
        

        
    }
}