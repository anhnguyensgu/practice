function checkPair(numbers, k) {
  let head = 0;
  let tail = numbers.length - 1;
  while (head < tail) {
    let result = numbers[head] + numbers[tail];
    if (result < k) {
      head ++;
    } else if (result > k) {
      tail--;
    } else {
      return true;
    }
  }
  return false;
}

console.log(checkPair([-3,0,1,2], 5));