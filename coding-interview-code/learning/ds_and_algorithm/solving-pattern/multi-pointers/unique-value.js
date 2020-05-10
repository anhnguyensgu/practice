function countUniqueValues(numbers){
  if (numbers.length == 0) return 0;
  let slow = 0;
  let fast = slow + 1;
  let count = 1;
  while(fast < numbers.length) {
    if (numbers[fast] !== numbers[slow]) {
      count++;
    }
    fast++;
    slow++;
  }
  return count;
}

console.log(countUniqueValues([1,1,1,1,1,2]));
console.log(countUniqueValues([1,2,3,4,4,4,7,7,12,12,13]));
console.log(countUniqueValues([-2,-1,-1,0,1]));