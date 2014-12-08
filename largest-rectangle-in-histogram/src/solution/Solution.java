package solution;

import java.util.Stack;

//-> http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
public class Solution {
 public int largestRectangleArea(int[] height) {
     if (height.length == 0) return 0;
     if (height.length == 1) return height[0];
     Stack<Integer> stack = new Stack<Integer>();
     int res = Integer.MIN_VALUE;
     for (int i = 0; i < height.length; i++) {
         if (stack.empty() || height[i] >= height[stack.peek()]) {
             stack.push(i);
         } else {
             while (!stack.empty() && height[i] < height[stack.peek()]) {
                 int x = stack.pop();
                 int leftIndex = stack.empty() ? 0 : stack.peek()+1;
                 int rightIndex = i-1;
                 res = Math.max(res, height[x] * (rightIndex - leftIndex + 1));
             }
             stack.push(i);
         }
     }
     while (!stack.empty()) {
         int x = stack.pop();
         int leftIndex = stack.empty() ? 0 : stack.peek()+1;
         int rightIndex = height.length-1;
         res = Math.max(res, height[x] * (rightIndex - leftIndex + 1));
     }
     return res;
 }
}