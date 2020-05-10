package main

import (
	"fmt" 
	"time"
)

type myType struct {
	value int
}

func (mt myType) reset() {
	mt.value = 0
}

func (mt *myType) resetPtr() {
	mt.value = 0
}

func reset2(mt *myType) {
	fmt.Println("abc", &(mt.value));
	mt.value = 0;
}

func main() {
	mt := myType{
		value: 1,
	}
	fmt.Println("initial", mt.value)

	fmt.Println("abc", &(mt.value));
	reset2(&mt);
	fmt.Println("after reset", mt.value)

	mt.resetPtr()
	fmt.Println("after resetPtr", mt.value)

	time.Sleep(100 * time.Second)
}