var removeDuplicates = function(nums) {
  let slow = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== nums[i + 2] || i + 2 >= nums.length) {
      nums[slow++] = nums[i];
    }
  }
  return slow;
};

var removeDuplicates2 = function(nums, dup) {
  let slow = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== nums[i + dup] || i + dup >= nums.length) {
      nums[slow++] = nums[i];
    }
  }
  return slow;
};
console.log(removeDuplicates([0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 3]));
console.log(removeDuplicates([0, 0, 1, 1, 2]));
console.log(removeDuplicates([0, 0, 1, 1, 2, 2]));
console.log(removeDuplicates2([0, 0, 0, 0, 0, 1, 1], 1));

console.log([][3]);

//      *
//0, 0, 1, 0, 1, 1, 1, 1, 1
//               ^

//   *
//0, 1 , 1 , 1, 1, 1
//   ^

//  *
//0 1 1 1
//      ^