/**
 * @param {string} word
 * @return {number}
 */
var numberOfSpecialChars = function(word) {

    let frqOfUpperCase =
        new Array(26).fill(-1);

    let frqOfLowerCase =
        new Array(26).fill(-1);

    let n = word.length;

    for(let i = 0; i < n; i++) {

        let ch = word[i];

        if(ch >= 'a' && ch <= 'z') {

            let idx =
                ch.charCodeAt(0) -
                'a'.charCodeAt(0);

            frqOfLowerCase[idx] = i;

        } else {

            let idx =
                ch.charCodeAt(0) -
                'A'.charCodeAt(0);

            if(frqOfUpperCase[idx] == -1) {

                frqOfUpperCase[idx] = i;
            }
        }
    }

    let cnt = 0;

    for(let i = 0; i < 26; i++) {

        if(
            frqOfLowerCase[i] != -1 &&
            frqOfUpperCase[i] != -1 &&
            frqOfLowerCase[i] <
            frqOfUpperCase[i]
        ) {

            cnt++;
        }
    }

    return cnt;
};