/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isGood = function(nums) {
    nums.sort((a, b) => a-b);
    let n = nums.length;
    if(n==1) return false;
    let i=0;
    let prev = 0;
    while(i<n-1) {
        if(prev+1 != nums[i]) return false;
        prev = nums[i];
        i++;
    }
    return nums[i]==nums[i-1];
};