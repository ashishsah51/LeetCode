/**
 * @param {number[]} nums
 * @return {number[]}
 */
var separateDigits = function(nums) {
    let ans = [];
    for(let num of nums) {
        // let arr = separateNumber(num);
        // arr.reverse();
        // ans.push(...arr);
        let str = num + "";
        let len = str.length;
        for(let i=0; i<len; i++) {
            ans.push(Number(str[i]));
        }
    }
    return ans;
};

var separateNumber = function(num) {
    let arr = [];
    while(num > 0) {
        let digit = num % 10;
        arr.push(digit);
        num = Math.floor(num / 10);
    }
    return arr;
};