class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<List<Integer>> temp = new ArrayList<>();

        int st = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {

            int st2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end >= st2) {        // overlap
                end = Math.max(end, end2);
            } else {                 // no overlap
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(st);
                temp1.add(end);
                temp.add(temp1);

                st = st2;
                end = end2;
            }
        }

        // add the last merged interval
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(st);
        temp1.add(end);
        temp.add(temp1);

        int[][] res = new int[temp.size()][2];

        for (int i = 0; i < temp.size(); i++) {
            res[i][0] = temp.get(i).get(0);
            res[i][1] = temp.get(i).get(1);
        }

        return res;
       
    }
}