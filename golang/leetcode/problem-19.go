package main

import "fmt"

type ListNode struct {
     Val int
     Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
    count := 0
    nNode := head
    for nNode != nil && count < n  {
        count++
        nNode = nNode.Next
    }
    if nNode == nil {
        head = head.Next
        return head
    }
    previous := head
    for nNode.Next != nil {
        nNode = nNode.Next
        previous = previous.Next
    }
    previous.Next = previous.Next.Next
    return head
}

func main() {
    // fifth := &ListNode{Val: 5}
    // fourth := &ListNode{Val: 4, Next: fifth}
    // third := &ListNode{Val: 3, Next: fourth}
    second := &ListNode{Val: 2, Next: nil}
    first := &ListNode{Val: 1, Next: second}

    head := removeNthFromEnd(first, 1)
    for head != nil {
        fmt.Println(head.Val)
        head = head.Next
    }
}