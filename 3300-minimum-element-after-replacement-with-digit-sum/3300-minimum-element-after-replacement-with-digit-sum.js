/**
 * @param {number[]} nums
 * @return {number}
 */
var minElement = function(nums) {
    let minNum = Number.MAX_SAFE_INTEGER;

    for(let num of nums) {
        minNum = Math.min(minNum, getDigitSum(num));
    }
    return minNum;
};

var getDigitSum = function(num) {
    let sum = 0;
    for(let c of num.toString()) {
        sum += Number(c);
    }
    return sum;
}