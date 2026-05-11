class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        List<Integer> ansList=new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> temp=new ArrayList<>();
            int num=nums[i];
            if(num>=10){
                while(num>0){
                    int digit=num%10;
                    temp.add(0,digit);
                    num=num/10;

                }

            }else{
                temp.add(num);
            }
            ansList.addAll(temp);
        }

        int len=ansList.size();
        int[] answer=new int[len];
        int k=0;
        for(int num : ansList){
            answer[k++]=num;
        }

        return answer;
    }
}