package Arrays.ProblemSet.Easy.LeetCode;

public class ReplaceElementsWithTheGreatestElementsOnRight {
    public static int[] replaceElements(int[] arr) {

        int[] ans = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(i == arr.length -1){
                ans[i] = -1;
                continue;
            }

            int maxEle = arr[i+1];
            for(int j = i + 1; j < arr.length; j++){
                maxEle = Math.max(maxEle, arr[j]);
            }
            ans[i] = maxEle;
        }

        return ans;

    }

    public static void main(String[] args){
        int[] arr = {17,18,5,4,6,1};
        int[] ans = replaceElements(arr);

        for(int ele : ans) System.out.print(ele + " ");
    }
}
