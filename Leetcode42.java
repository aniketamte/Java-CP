
public class Leetcode42 {
    //Leetcode 42 : Trapping Rain Water
    //11-03-2025

       public static int trap(int[] height) {
        int n = height.length;

        int LeftMax[] = new int[n];
        LeftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            LeftMax[i] = Math.max(height[i], LeftMax[i - 1]);
        }

        int RightMax[] = new int[n];
        RightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            RightMax[i] = Math.max(height[i], RightMax[i + 1]);
        }

        int TrappedWater = 0;
        for (int i = 0; i < n; i++) {
            int WaterLevel = Math.min(LeftMax[i], RightMax[i]);
            TrappedWater += WaterLevel - height[i];
        }

        return TrappedWater;
    }

    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
