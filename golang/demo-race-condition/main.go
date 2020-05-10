package main

import (
  "fmt"
  "sync"
  "time"
)

var (
  sheepChannel = make(chan int)
  waitGroup    sync.WaitGroup
)

type sheepManager struct {
  sheepCount int
}

func (sm *sheepManager) incrementAndReport(i int) {
  defer waitGroup.Done()
  //time.Sleep(1000 * time.Millisecond)
  sm.sheepCount++
  fmt.Println("index ", i, ": ", sm.sheepCount)
  sheepChannel <- sm.sheepCount

}

func runWithoutRace() {
  sm := sheepManager{sheepCount: 0}
  waitGroup.Add(10)
  for i := 0; i < 10; i++ {
    go sm.incrementAndReport(i)
    fmt.Println("running index ", i)
    sm.sheepCount = <-sheepChannel
  }
  waitGroup.Wait()
}

func (sm *sheepManager) incrementAndReportWithRace(i int) {
  sm.sheepCount = sm.sheepCount + 1
  if i%2 == 0 {
    time.Sleep(1000 * time.Microsecond)
  }
  fmt.Println("index ", i, ": ", sm.sheepCount)
  waitGroup.Done()
}

func runWithRace() {
  sm := sheepManager{sheepCount: 0}
  waitGroup.Add(10)
  for i := 0; i < 10; i++ {
    go sm.incrementAndReportWithRace(i)
  }
  waitGroup.Wait()
}

func main() {
  runWithoutRace()
}
