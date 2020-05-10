var isToeplitzMatrix2 = function(matrix) {
    //move horizontal
    var width = matrix[0].length;
    var height = matrix.length;

    for(var i = 0 ; i < width; i++) {
      var row = 0, col = i;
      var currentValue = matrix[row++][col++]
      while(col < width && row < height) {
        if(currentValue != matrix[row][col]) {
          return false;
        }
        row++;
        col++;
      } 
    }
    //move vertical

    for(var i = 0 ; i < height; i++) {
      var row = i, col = 0;
      var currentValue = matrix[row++][col++]
      while(col < width && row < height) {
        if(currentValue != matrix[row][col]) {
          return false;
        }
        row++;
        col++;
      } 
    }

    return true;
};

var isToeplitzMatrix = function(matrix) {
  for (var i = 0; i < matrix.length; i++){
    for (var j = 0; j < matrix[0].length; j++){
        if ((i > 0 && j > 0) && (matrix[i][j] != matrix[i-1][j-1])){
            return false;
        }
    }   
} 
  return true;
};
// var matrix = [
//   [1,2,3,4],
//   [5,1,2,3],
//   [9,5,1,2]
// ];

console.log(isToeplitzMatrix([
  [1,2],
  [2,2]
]));
