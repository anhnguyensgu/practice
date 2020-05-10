var removeDuplicates = function(nums) {
  let slow = 0;
  let count = 1;
  for (let i = 1; i < nums.length; i++) {
    if (nums[slow] === nums[i]) {
      if (count === 1) {
        slow++;
        nums[slow] = nums[i];
        count = 2;
      }
    } else if (nums[slow] !== nums[i]) {
      nums[++slow] = nums[i];
      count = 1;
    }
  }
  return slow + 1;
};
// console.log(removeDuplicates([0,0,0,0,0,0,0,1,1,1,1,2,3,3]));
// console.log(removeDuplicates([0,0,1,1,2]));
// console.log(removeDuplicates([0, 0, 1, 1, 2, 2]));
console.log(removeDuplicates([0, 0, 0, 0, 0 ,1, 1]));
