function isPalindrome(str) {
  const tail = str.length - 1;
  const head = 0;
  function recur(str, tail, head) {
    if (tail <= head) return true;
    return str[tail] === str[head] && recur(str, tail - 1, head + 1);
  }
  return recur(str, tail, head);
}

console.log(isPalindrome('foobar'));