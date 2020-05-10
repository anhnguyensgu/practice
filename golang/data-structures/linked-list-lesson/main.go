package main

import (
  "fmt"
  . "./linked"
)

func main() {
  list := LinkedList{}
  list.Traversal()

  // fmt.Println("insert a new node at the beginning")
  list.InsertAtBeginning(&Node{Value: 0})
  // list.Traversal()

  // fmt.Println("insert a new node at the end")
  list.InsertAtTheEnd(&Node{Value: 2})
  // list.Traversal()

  // fmt.Println("insert a new node at the given index")
  removedNode := &Node{Value: -1};
  list.InsertBefore(removedNode, 0)
  list.InsertBefore(&Node{Value: 1}, 2)
  list.InsertAfter(&Node{Value: -3}, 1)
  list.InsertBefore(&Node{Value: -300}, 2)
  // list.Traversal()

  // fmt.Println("Delete a given node")
  // list.DeleteNode(removedNode)
  list.Traversal()
  fmt.Println("Print middle node")
  list.PrintMiddle()
}
