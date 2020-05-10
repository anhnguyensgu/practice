package main

import "fmt"

/*
M[i][j]: max profit of i-th transaction from day 0 to day j
M[i][j] = max(M[i][j - 1], max(M[i - 1][k] + p[j] - p[k])), k from 0 to j - 1
        = max(M[i][j - 1], p[j] + max(M[i - 1][k] - p[k]))
        = max(M[i][j - 1], p[j] + tmp);
    tmp = Math.max(tmp, M[i - 1][j] - p[j]);
optimization: space O(m*n) -> O(n)
*/

func maxProfit(prices []int) int {
		max := func(a int, b int) int {
			if a > b {
				return a
			}
			return b
			// return a
		}

		profit := make([][]int, 3);
		for i:= 0; i < len(profit); i++ {
			profit[i] = make([]int, len(prices));
		}

		for i:= 1; i < 3; i++ {
			tmp := profit[i][0] - prices[0]
			for j:= 1; j < len(profit[i]); j++ {
				// max(1,2)
				profit[i][j] = max(profit[i][j - 1], max(profit[i - 1][j] + prices[j] - prices[j - 1]));
				tmp = max(profit[i][j])
			}
		}
		return profit[2][len(prices) - 1]
}

func main() {
	fmt.Println(maxProfit([]int{1,2,3}))
}