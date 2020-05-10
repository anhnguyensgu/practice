function maxSubarraySum(arr, size) {
  if(size > arr.length) return null;

  let currentSum = 0;
  let maxSum = currentSum;
  for(let i = 0; i < size; i++) {
    currentSum += arr[i];
  }
  for(let i = size ; i < arr.length; i++) {
    currentSum = currentSum - arr[i - size] + arr[i];
    maxSum = Math.max(maxSum, currentSum);
  }
  return maxSum;
}

console.log(maxSubarraySum([1,4,2,10,23,3,1,0,20], 2))