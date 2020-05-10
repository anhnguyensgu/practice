let smallestRepunitDivByK = function (K) {
  //find smallest number containing only digit '1' and divisible by K
  let N = 1;
  if (K % 2 === 0 || K % 5 === 0) {
    return -1;
  }

  let count = 1;
  while (N % K !== 0) {
    console.log('aaa ', N * 10 + 1);
    N = (N * 10 + 1) % K;
    console.log(N);
    count++;
  }
  console.log('answer:', N % K);
  return count;
};

console.log(smallestRepunitDivByK(9));