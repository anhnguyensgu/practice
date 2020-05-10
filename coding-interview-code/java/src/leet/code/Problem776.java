package leet.code;

public class Problem776 {
  public static void main(String[] args) {
    System.out.println();
  }

  public boolean isToeplitzMatrix(int[][] matrix) {
    int width = matrix[0].length;
    int height = matrix.length;

    for(int i = 0 ; i < width; i++) {
      int row = 0, col = i;
      int currentValue = matrix[row++][col++];
      while(col < width && row < height) {
        if(currentValue != matrix[row][col]) {
          return false;
        }
        row++;
        col++;
      }
    }
    //move vertical

    for(int i = 0 ; i < height; i++) {
      int row = i, col = 0;
      int currentValue = matrix[row++][col++];
      while(col < width && row < height) {
        if(currentValue != matrix[row][col]) {
          return false;
        }
        row++;
        col++;
      }
    }

    return true;
  }
}
