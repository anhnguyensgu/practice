/*
* [1, 2, 5, -7, 2, 3]
*
* */

function maxSet(A) {
    var result = [];
    var maxSum = -Infinity;
    var curSubArray = [];
    var curSum = 0;
    var i = 0;
    do {
        if (A[i] < 0) {
            if (curSum === maxSum) {
                if (curSubArray.length !== result.length && curSubArray.length >= 2) {
                    result = curSubArray;
                }
            } else if (curSum > maxSum) {
                result = curSubArray;
                maxSum = curSum;
            }
            curSubArray = [];
            curSum = 0;
        } else {
            curSubArray.push(A[i]);
            curSum += A[i];
        }
        i++;
    } while (i < A.length);

    if (curSum === maxSum) {
        if (curSubArray.length !== result.length && curSubArray.length >= 2) {
            result = curSubArray;
        }
    } else if (curSum > maxSum) {
        result = curSubArray;
    }
    return result;
}
console.log(maxSet([0, 0, -1, 0]));
