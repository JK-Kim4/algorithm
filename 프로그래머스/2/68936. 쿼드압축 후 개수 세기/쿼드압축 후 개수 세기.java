class Solution {
    
    public static class Count {
        public final int zero;
        public final int one;
        
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        public Count add(Count count) {
            return new Count(zero + count.zero, one + count.one);
        }
    }
    
    public Count compress(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        
        //탈출 조건
        for (int i = offsetX; i < offsetX + size; i++) {
            for (int j = offsetY; j < offsetY + size; j++) {
                if (arr[i][j] != arr[offsetX][offsetY]) {
                    return compress(offsetX, offsetY, size/2, arr)
                        .add(compress(offsetX+size/2, offsetY, size/2, arr))
                        .add(compress(offsetX, offsetY+size/2, size/2, arr))
                        .add(compress(offsetX+size/2, offsetY+size/2, size/2, arr));
                }
            }
        }
        
        if (arr[offsetX][offsetY] == 1) {
            return new Count(0, 1);
        }
        
        return new Count(1, 0);
    }
    
    public int[] solution(int[][] arr) {
        Count result = compress(0, 0, arr.length, arr);
        return new int[]{result.zero, result.one};
    }
}