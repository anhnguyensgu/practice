const helper = function(nums, left, right) {
  console.log('start end', left, right);
  const mid = Math.floor(left + (right - left) / 2);
  if(left >= right) return left;
  console.log('mid', mid);

  if (nums[mid] > nums[mid+1]) {
      console.log(left, mid);
      return helper(nums, left, mid);
  }
  console.log(mid + 1, right);
  return helper(nums, mid + 1, right);
}

var findPeakElement = function(nums) {
  return helper(nums, 0, nums.length-1);
};

console.log(findPeakElement([1,2,3,1,5,6,1]));