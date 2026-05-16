/**
 * @param {number} n
 * @param {number[]} cuts
 * @return {number}
 */
var minCost = function(n, cuts) {
    cuts.sort((a, b) => a - b);
    let dp = new Map();

    function solve(l, r) {
        if(l >= r) return 0;
        let key = `${l},${r}`;
        if(dp.has(key)) return dp.get(key);

        let ans = Number.MAX_SAFE_INTEGER;

        for(let cut of cuts) {
            if(l < cut && r > cut) {
                let val = solve(l, cut) + solve(cut, r) + (r - l);
                ans = Math.min(ans, val);
            }
        }

        if(ans === Number.MAX_SAFE_INTEGER) {
            ans = 0;
        }

        dp.set(key, ans);

        return ans;
    }

    return solve(0, n);
};