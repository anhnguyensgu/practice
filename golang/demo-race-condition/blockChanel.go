package main

import (
  "fmt"
  "time"
)

func square(c chan int) {
  fmt.Println("[square] reading: ")
  num := <-c
  fmt.Println("[square] end")
  c <- num * num
  fmt.Println("[square] end function")
}

func cube(c chan int) {
  fmt.Println("[cube] reading: ")
  // block
  num := <-c
  fmt.Println("[cube] end")
  c <- num
  fmt.Println("[cube] end function")
}

func main() {
  fmt.Println("[main] main() started")

  squareChan := make(chan int)
  cubeChan := make(chan int)

  go square(squareChan)
  go cube(cubeChan)

  testNum := 3
  fmt.Println("[main] sent testNum to squareChan")

  // main blocking here
  time.Sleep(2 * time.Second)
  squareChan <- testNum

  fmt.Println("[main] resuming")
  fmt.Println("[main] sent testNum to cubeChan")

  cubeChan <- testNum

  fmt.Println("[main] resuming")
  fmt.Println("[main] reading from channels")

  squareVal, cubeVal := <-squareChan, <-cubeChan
  sum := squareVal + cubeVal

  fmt.Println("[main] sum of square and cube of", testNum, " is", sum)
  fmt.Println("[main] main() stopped")
}
