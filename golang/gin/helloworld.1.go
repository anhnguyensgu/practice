package main

import (
	"fmt"
	"testing"
	"runtime"
	"time"
)

type BigStruct struct {
	value int
	stuff [1000000]int
}

// func create() *BigStruct {
// 	return &BigStruct{}
// }

// func call(b *BigStruct) {
// 	_ = b.value
// }

// func create() BigStruct {
// 	return BigStruct{}
// }

// func call(b BigStruct) {
// 	_ = b.value
// }

// func create() BigStruct {
// 	return BigStruct{}
// }

// func call(b BigStruct) {
// 	go func() {
// 		_ = b.value
// 	}()
// }

func create() *BigStruct {
	return &BigStruct{}
}

func call(b *BigStruct) {
	_ = b.value
}

func main() {
	// benchmark multiple times for benchstat
	time.Sleep(100 * time.Second)
	fmt.Println(runtime.NumCPU())
	for i := 0; i < 5; i++ {
		result := testing.Benchmark(func(b *testing.B) {
			big := create()

			b.ResetTimer()
			for i := 0; i < b.N; i++ {
				call(big)
			}
		})

		fmt.Printf("BenchmarkCall\t%s\t%s\n",
			result, result.MemString())
	}
}