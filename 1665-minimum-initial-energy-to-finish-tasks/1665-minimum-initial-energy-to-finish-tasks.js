/**
 * @param {number[][]} tasks
 * @return {number}
 */
var minimumEffort = function(tasks) {
    let arr = [];
    let n = tasks.length;

    let max = 0;
    let sum = 0;
    for(let i=0; i<n; i++) {
        max = Math.max(max, tasks[i][1]);
        sum += tasks[i][0];
        arr.push([
            tasks[i][0],
            tasks[i][1],
            tasks[i][1] - tasks[i][0]
        ]);
    }

    arr.sort((a, b) => {
        if(a[2] === b[2]) {
            return b[1] - a[1];
        } else {
            return b[2] - a[2];
        }
    });

    let l = max;
    let r = sum + max;
    let = res = r;
    while(l<=r) {
        mid = Math.floor((l+r)/2);
        if(check(mid, arr)) {
            res = mid;
            r = mid-1;
        } else {
            l = mid+1;
        }
    }
    return res;
};
var check = function(energy, arr) {
    for(let x of arr) {
        if(x[1] > energy) return false;
        energy -= x[0];
    }
    return true;
}