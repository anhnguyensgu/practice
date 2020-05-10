package main

import "fmt"

func isBoomerang(points [][]int) bool {
	point1 := points[0]
	point2 := points[1]
	point3 := points[2]

	isSamePoint := func (p1 []int, p2 []int) bool{
		return p1[0] == p2[0] && p1[1] == p2[1]
	}

	isOnSameX := func (p1 []int, p2 []int) bool{
		return p1[0] == p2[0];
	}

	isOnSameY := func (p1 []int, p2 []int) bool{
		return p1[1] == p2[1];
	}

	isTraight := func (p1 []int, p2 []int, p3 []int) bool {
		return p2[0] - p1[0] == p3[0] - p2[0] && p2[1] - p1[1] == p3[1] - p2[1];
	}
	
	if isSamePoint(point1, point2) || isSamePoint(point1, point3) || isSamePoint(point2, point3) {
		return false;
	}

	if isOnSameX(point1, point2) && isOnSameX(point2, point3) {
		return false;
	}

	if isOnSameY(point1, point2) && isOnSameY(point2, point3) {
		return false;
	}

	if isTraight(point1, point2, point3) {
		return false;
	}

	return true;
}

func main() {
	fmt.Println(isBoomerang([][]int{ {1,1},{2,3},{2,2}}))
}