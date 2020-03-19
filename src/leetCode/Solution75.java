package leetCode;

public class Solution75 {

    public void sortColors(int[] nums) {

        int[] data = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0 && nums[i] <= 2);
            data[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < data[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < data[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < data[2]; i++) {
            nums[index++] = 2;
        }


    }

    public static void main(String[] args) {


    }
}
