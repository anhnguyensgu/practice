function power(baseNumber, powerNumber) {
  if (powerNumber === 0) return 1;
  return baseNumber * power(baseNumber, powerNumber - 1);
}

console.log(power(2,2));
console.log(power(2,0));
/*
2 ^ 3 = 2 * 2 ^ 2
            2 * 2
*/