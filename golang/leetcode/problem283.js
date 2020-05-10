var moveZeroes = function(nums, val) {
  let currentZero = 0;
  for(let i = 0; i < nums.length; i++) {
    if(nums[i] !== val) {
      currentZero++;
    }
  }
  return currentZero;
};

console.log(moveZeroes([0,1,0,3,12], 1));
