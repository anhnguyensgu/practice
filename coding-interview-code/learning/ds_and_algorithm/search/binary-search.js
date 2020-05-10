function binarySeach(arr, target) {
  return binarySearchHelper(arr, target, 0, arr.length - 1);
}

function binarySearchHelper(arr, target, left, right) {
  if (left > right) return -1;
  const mid = Math.round((right + left) / 2);
  if(arr[mid] === target) return mid;
  if(arr[mid] > target) return binarySearchHelper(arr, target, left, mid - 1);
  if(arr[mid] < target) return binarySearchHelper(arr, target, mid + 1, right);
}

console.log(binarySeach([1,2,3,4,5,6,7], 7));