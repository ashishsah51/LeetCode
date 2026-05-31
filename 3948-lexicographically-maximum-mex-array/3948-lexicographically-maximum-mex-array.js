/**
 * @param {number[]} nums
 * @return {number[]}
 */
var maximumMEX = function(nums) {
    let n = nums.length, maxVal = 0;
    for(let num of nums) {
        maxVal = Math.max(maxVal, num);
    }
    let size = Math.max(maxVal, n) + 2;
    let frq = new Array(size).fill(0);
    
    for(let num of nums) {
        frq[num]++;
    }

    let mex = 0;
    while(frq[mex] > 0) mex++;

    let res = [];

    let vis = new Array(size).fill(0);
    let step = 0, i=0;
    while(i<n) {
        if(mex === 0) {
            res.push(0);
            frq[nums[i]]--;
            i++;
        } else {
            let nextMex = mex;
            res.push(mex);
            let distinctCnt = 0;
            step++;
            
            while(i<n && distinctCnt < mex) {
                frq[nums[i]]--;
                let num = nums[i];
                if(nums[i] < mex) {
                    if(vis[num] != step) {
                        vis[num] = step;
                        distinctCnt++;
                    }

                    if(frq[num]==0) {
                        nextMex = Math.min(nextMex, num);
                    }
                }
                i++;
            }
            mex = nextMex;
        }
    }
    return res;

};