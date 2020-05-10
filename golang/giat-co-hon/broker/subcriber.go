package broker

import (
	"github.com/gorilla/websocket"
	"fmt"
	"time"
)

type Subcriber struct {
	Hub *MessageBroker
	Conn *websocket.Conn
	Message chan []byte
}

type Message struct {
	Id string
	Name string
	Body string
	Time int64
}

func (sub *Subcriber) WriteMessage() {
	ticker := time.Tick(10 * time.Second)
	defer func() {
		sub.Conn.Close()
	}()
	for {
		select {
			case message, ok := <- sub.Message:
				fmt.Println("write message to: ", sub.Hub.);
				if !ok {
					sub.Conn.WriteMessage(websocket.CloseMessage, []byte{})
					return
				}

				w, err := sub.Conn.NextWriter(websocket.TextMessage)
				if err != nil {
					return
				}
				w.Write(message)

				// Add queued chat messages to the current websocket message.
				n := len(sub.Message)
				for i := 0; i < n; i++ {
					// w.Write(newline)
					w.Write(<-sub.Message)
				}

				if err := w.Close(); err != nil {
					return
				}
			case <-ticker:
				fmt.Println("heart beat")
				if err := sub.Conn.WriteMessage(websocket.PingMessage, nil); err != nil {
					fmt.Println("disconnected")
					s := sub.Hub.Subcribers
					delete(sub.Hub.Subcribers, sub)
					fmt.Println("remove client: ", s);
					return
				}
		}
	}
}