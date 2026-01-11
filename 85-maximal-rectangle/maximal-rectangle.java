class Solution {
    public int maximalRectangle(char[][] matrix) {
         if (matrix.length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] h) {
        int n = h.length;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : h[i];
            while (!stack.isEmpty() && curr < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}