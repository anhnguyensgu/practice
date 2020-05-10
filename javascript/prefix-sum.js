function solution() {
    const input = [0,9,2,7,4,5,6,3,8,1,10];
    const prefixSum = [];
    let currentSum = 0;
    for (let i = 0; i < input.length; i++) {
        currentSum += input[i];
        prefixSum[i] = currentSum;
    }
    console.log(prefixSum[6] - prefixSum[3]);
    console.log(prefixSum[6] - prefixSum[3]);
};

solution();
