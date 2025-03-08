class Solution {
    public int solution(int[][] sizes) {
        int maxX = Integer.MIN_VALUE; int maxY = Integer.MIN_VALUE;
        
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                //SWAP
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
            
            maxX = Math.max(maxX, sizes[i][0]);
            maxY = Math.max(maxY, sizes[i][1]);
            
        }
        
        
        return maxX * maxY;
    }
}