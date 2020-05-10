package linkedList

import "fmt"

type Node struct {
  Value int
  Next  *Node
}

type LinkedList struct {
  head *Node
}

func (list *LinkedList) Traversal() (node *Node) {
  cur := list.head
  for cur != nil {
    fmt.Println(cur.Value)
    cur = cur.Next
  }
  return cur
}

func (list *LinkedList) InsertAtBeginning(insertedNode *Node) {
  insertedNode.Next = list.head
  list.head = insertedNode
}

func (list *LinkedList) InsertAtTheEnd(insertedNode *Node) {
  // duplicate code but refactor later
  tail := list.head
  for tail.Next != nil {
    tail = tail.Next
  }
  tail.Next = insertedNode
}

func (list *LinkedList) InsertAfter(insertedNode *Node, index int) {
  currentIndex := 0
  currentNode := list.head
  //find the previous node
  for currentNode.Next != nil && index != currentIndex {
    currentIndex++
    currentNode = currentNode.Next
  }
  insertedNode.Next = currentNode.Next
  currentNode.Next = insertedNode
}

func (list *LinkedList) InsertBefore(insertedNode *Node, index int) {
  currentIndex := 0
  currentNode := list.head
  if index == 0 {
    list.InsertAtBeginning(insertedNode)
    return
  }
  //find the previous node
  for currentNode.Next != nil && index-1 != currentIndex {
    currentIndex++
    currentNode = currentNode.Next
  }
  //problem with index = 0
  insertedNode.Next = currentNode.Next
  currentNode.Next = insertedNode
}

func (list *LinkedList) DeleteNode(node *Node) {
  if (node.Next == nil) {
    node = nil
  }
  node.Value = node.Next.Value
  node.Next = node.Next.Next
}

func (list *LinkedList) PrintMiddle() {
  fastPointer := list.head
  currentPointer := list.head
  for fastPointer != nil {
    if fastPointer.Next == nil {break}
    fastPointer = fastPointer.Next.Next
    currentPointer = currentPointer.Next
  }
  fmt.Println(currentPointer.Value);
}