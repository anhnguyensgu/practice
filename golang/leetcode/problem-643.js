var findMaxAverage_old = function(nums, k) {
  var tail = k - 1;
  var head = 0;
  var sumAll = function (arr, h, t) {
    var sum = 0;
    while(h <= t) {
      sum += arr[h];
      h++;
    }
    return sum;
  }
  
  var max = sumAll(nums, head, tail);
  while(tail !== nums.length) {
    var curSum = sumAll(nums, head, tail);
    max = curSum > max ? curSum : max;
    head++;
    tail++;
  }
  return max/k;
};

var findMaxAverage = function(nums, k) {
  let tail = k - 1;
  let head = 0;
  let max = 0;
  for(let i = head; i <= tail; i++) {
    max += nums[i];
  }
  var headValue = nums[head++];
  tail++;
  var curSum = max;
  while(tail !== nums.length) {
    curSum = curSum - headValue + nums[tail];
    max = curSum > max ? curSum : max;
    headValue = nums[head++];
    tail++;
  }
  return max/k;
};

var array = [11, -6, 2, 4, -10, 12];
var k = 3;
console.log(findMaxAverage(array, k));
console.log(findMaxAverage_old(array, k));
/*
basic case 
  input [1,12,-5,-6,50,3], k = 4
  output 12 - 5 - 6 -50 = 51

  input [11, -6, 2, 4, -10, 12] k = 3
  output 11 - 6 + 2 = 7, 7 - 11 + 4 = 0, 0 - 10 + 6 = -4, -4 - 2 + 12 = 6

*/