/*
[1,3],[6,9] insert [2, 5] => [1,5],[6,9]
overlap -> [1,3] [0, 4]-> [0,4]
[1,3] [2,4] -> [1,4]
[1,3] [0,2] -> [0,3]

* */
function insert(A, B) {
    function isOverlap(interval, interval2) {
        if (interval2[0] > interval[1]) return false;
        if (interval2[1] < interval[0]) return false;
        return true;
    }

    function merge(interval, interval2) {
        interval[0] = Math.min(interval[0], interval2[0]);
        interval[1] = Math.max(interval[1], interval2[1]);
        return interval;
    }

    var curInterval = B;
    var isFound = false;
    // var cur = 0;
    var result = []
    for(var i = 0; i < A.length; i++) {
        if (isOverlap(A[i], curInterval)) {
            curInterval = merge(A[i], curInterval);
            isFound = true;
        } else {
            if (isFound === true) result.push(curInterval);
            result.push(A[i]);
            if (curInterval[0] > A[i][1]) result.push(curInterval);
        }
    }
    // result.push(curInterval);
    // for(i; i< A.length ;i++) {
    //     result.push(A[i]);
    // }
    return result;
}

console.log(insert([[1, 2], [8, 10]], [3, 6]));
