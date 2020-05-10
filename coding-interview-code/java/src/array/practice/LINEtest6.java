package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class LINEtest6 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] token = input.split(" ");
    double A = Integer.valueOf(token[0]) / 2.0;
    int H = Integer.valueOf(token[1]);

    double squareA = A * A * 1.0;
    double squareH = H * H * 1.0;

    double a = 1 / ((1/squareA) + (1/squareH));
    System.out.println(String.format("%.4f", Math.sqrt(a)));
  }
}
