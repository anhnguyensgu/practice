function findLongestSubstring(str) {
    let counter = {};
    let fast = 0;
    let slow = 0;
    let len = -Infinity;
    while (fast < str.length) {
        if (counter[str[fast]] !== undefined) {
            len = Math.max(fast - slow, len);
            slow = counter[str[fast]] + 1;
            fast = counter[str[fast]] + 1;
            counter = {};
        } else {
            counter[str[fast]] = fast;
            fast++;
        }
    }
    return Math.max(fast - slow, len);
}
console.log(findLongestSubstring('thisishowwedoit'));
