class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        
        for(int i = 0; i<position.length;i++){
            cars.add(new int[]{position[i], speed[i]});
        }
        
        cars.sort((a,b)->b[0]-a[0]);

        int result = 0;
        double prevTime = 0.0;
        
        for(int i = 0; i<cars.size();i++){
            int pos = cars.get(i)[0];
            int sp = cars.get(i)[1];
            double time = (double) (target-pos)/sp;
            
            if(time>prevTime){
                result++;            
                prevTime=time;
            }
        }
        return result;
    }
}