function fib(number) {
  if (number === 0) return 0;
  if(number === 1 || number === 2) return 1;
  return fib(number - 1) + fib(number - 2);
}



console.log(fib(10));
console.log(fib(28));
console.log(fib(35));