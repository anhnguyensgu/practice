function validAnagram(first,second) {
  if(first.length !== second.length) return false;

  const counters = {};
  first.split("").forEach(letter => {
    counters[letter] = counters[letter] ? counters[letter] + 1 : 1;
  });
  
  for(let i = 0; i < second.length; i++) {
    if(!counters[second[i]]) return false;

    if(counters[second[i]] <= 0) return false;
    counters[second[i]]--;
  }

  return true;
}

function sameFrequency(n1, n2){
  return validAnagram(n1.toString(), n2.toString());
}


console.log(sameFrequency(34, 14));