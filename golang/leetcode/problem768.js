// 1,1,1,0,1,0,0,0,1,0
// 0,0,0,0,0,1,1,1,1,1

var maxChunksToSorted = function (arr) {
    const expectedArr = [...arr].sort((a, b) => a - b);
    let boundary = {
        min: {
            value: Infinity,
            count: Infinity
        },
        max: {
            value: -Infinity,
            count: Infinity
        }
    };
    let chunkCount = 0;

    for (let i = 0; i < arr.length; i++) {
        if (boundary.max.value < arr[i]) {
            boundary.max.value = arr[i];
            boundary.max.count = 1;
        } else if (boundary.max.value === arr[i]) {
            boundary.max.count++;
        }

        if (boundary.max.value === expectedArr[i]) {
            boundary.max.count--;
        }

        if (boundary.min.value > expectedArr[i]) {
            boundary.min.value = expectedArr[i];
            boundary.min.count = 1;
        } else if (boundary.min.value === expectedArr[i]) {
            boundary.min.count++;
        }

        if (boundary.min.value === arr[i]) {
            boundary.min.count--;
        }

        if (boundary.max.count === 0 && boundary.min.count === 0) {
            chunkCount++;
            boundary = {
                min: {
                    value: Infinity,
                    count: Infinity
                },
                max: {
                    value: -Infinity,
                    count: Infinity
                }
            };
        }
    }
    return chunkCount === 0 ? 1 : chunkCount;
};

console.log(maxChunksToSorted([1, 1, 1, 0, 1, 0, 0, 0, 1, 0]));
