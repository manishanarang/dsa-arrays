class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int i = 0; i<points.length; i++){
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new int[]{distance,i});
        }

        int result[][] = new int[k][2];
        for(int i = 0; i<k;i++){
            int index = pq.poll()[1];
            result[i] = points[index];
        }
        return result;
    }
}