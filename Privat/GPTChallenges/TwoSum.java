public class TwoSum {
    
    public static int[] twoSum(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] != arr[j]) && (arr[i] + arr[j]) == sum) {
                    System.out.println(arr[i] + "+" + arr[j] + "=" + sum);
                   return new int[]{arr[i], arr[j]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[Integer.parseInt(args[0])];
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            arr[i] = i;
        }
        twoSum(arr, Integer.parseInt(args[1]));
    }
}
