function minSubArrayLen(arr, minValue) {
  let curSum = 0;
  let curIndex = 0;
  let curLen = 0;

  // while(curSum < minValue && curIndex < arr.length) {
  //   curSum += arr[curIndex++];
  //   curLen++;
  // }
  // if(curIndex >= arr.length) return 0;
  // while (curSum - arr[curIndex - curLen] >= minValue ) {
  //   curSum = curSum - arr[curIndex - curLen];
  //   curLen--;
  // }
  // console.log('tail: ',arr[curIndex - curLen]);
  // console.log('current sum', curSum);
  // console.log('current length', curLen);
  // console.log('-----');
  // for(let i = curIndex; i < arr.length; i++) {
  //   console.log('current sum:', curSum);
  //   curSum = curSum - arr[i - curLen] + arr[i];
  //   console.log('tail: ',arr[i - curLen]);
  //   console.log('current num:', arr[i]);
  //   console.log('next sum:', curSum);
  //   while (curSum - arr[curIndex - curLen + 1] >= minValue ) {
  //     curSum = curSum - arr[curIndex - curLen + 1];
  //     curLen--;
  //   }
  // }
  return curLen;
}

function minSubArrayLen2(nums, sum) {
  let slow = 0;
  let fast = 0;
  let total = 0;
  let minLen = Infinity;
  while (slow <= fast) {
    if (total < sum && fast < nums.length) {
      total += nums[fast];
      fast++;
    } else if (total >= sum) {
      minLen = Math.min(minLen, fast - slow)
      total -= nums[slow];
      slow++;
    } else {
      break;
    }
  }
  return minLen === Infinity ? 0 : minLen;
}

console.log(minSubArrayLen2([3,1,4,5], 9))
