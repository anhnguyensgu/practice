function isSubsequence(sub, str) {
  let subIndex = 0;
  let mainIndex = 0;
  while (subIndex < sub.length && mainIndex < str.length) {
    if (sub[subIndex] === str[mainIndex]) {
      console.log(sub[subIndex]);
      subIndex++;
    }
    mainIndex++;
  }

  if (subIndex === sub.length) return true;
  return false;
}

console.log(isSubsequence('sing', 'sting'))