/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let n = nums.length;
    let l = 0, r = n-1;
    while(l<r) {
        mid = Math.floor((l+r) / 2);
        if(nums[mid] > nums[n-1]) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return nums[l];
};