import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Frequency array to keep track of elements remaining in the suffix
        int[] freq = new int[Math.max(n, maxVal) + 2];
        for (int num : nums) {
            freq[num]++;
        }

        // Determine the initial MEX of the entire array
        int mex = 0;
        while (freq[mex] > 0) {
            mex++;
        }

        List<Integer> result = new ArrayList<>();
        
        // Optimization: use a step/token array to avoid re-allocating a visited array
        int[] visited = new int[freq.length];
        int stepToken = 0;
        
        int i = 0;
        while (i < n) {
            if (mex == 0) {
                // If MEX is 0, we can only get 0s from here onwards. 
                // We consume 1 element at a time to maximize the length of the result.
                result.add(0);
                freq[nums[i]]--;
                i++;
            } else {
                result.add(mex);
                int nextMex = mex;
                int distinctCount = 0;
                stepToken++;

                // Find the shortest prefix containing all elements from 0 to mex - 1
                while (i < n && distinctCount < mex) {
                    int num = nums[i];
                    freq[num]--;
                    
                    if (num < mex) {
                        if (visited[num] != stepToken) {
                            visited[num] = stepToken;
                            distinctCount++;
                        }
                        // If this was the last copy of 'num' in the entire remaining array,
                        // the next global MEX cannot exceed this 'num'.
                        if (freq[num] == 0) {
                            nextMex = Math.min(nextMex, num);
                        }
                    }
                    i++;
                }
                // Update the current MEX for the next iteration
                mex = nextMex;
            }
        }

        // Convert List<Integer> to primitive int[] array
        int[] resArray = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            resArray[j] = result.get(j);
        }
        return resArray;
    }
}