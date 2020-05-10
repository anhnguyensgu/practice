package main

import (  
		"fmt"
		"sync"
		"time"
		"./service"
)

var wg sync.WaitGroup

func hello() {  
		a := 2;
		a += 2;
		fmt.Println("Hello world goroutine")
		time.Sleep(2 * time.Second)
}
func main() { 
	service.SomeThing()
	wg.Add(5)
	for i := 0; i < 5; i++ {
		go hello()
	} 
	wg.Done()
	time.Sleep(2 * time.Second)
  fmt.Println("main function")
}