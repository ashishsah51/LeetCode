/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {

    let n = prices.length;
    let buy = -prices[0];
    let sell = 0;
    let cool = 0;

    for(let price of prices) {
        let prevSell = sell;
        buy = Math.max(buy, cool-price);
        sell = Math.max(sell, buy+price);
        cool = prevSell;
    }
    return sell;
};