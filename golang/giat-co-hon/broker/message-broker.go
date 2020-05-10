package broker

import (
	"github.com/gorilla/websocket"
	"fmt"
)

type MessageBroker struct {
	Subcribers map[*Subcriber]bool
	RegisterSubcriber chan *Subcriber
	UnregisterSubcriber chan *Subcriber
	BroadcastingMessage chan []byte
}

func NewMessageBroker() *MessageBroker{
	return &MessageBroker{
		BroadcastingMessage: make(chan []byte),
		RegisterSubcriber:   make(chan *Subcriber),
		UnregisterSubcriber: make(chan *Subcriber),
		Subcribers:          make(map[*Subcriber]bool),
	}
}

func (messageBroker *MessageBroker) addSubcriber(subcriberConnection websocket.Conn) {
}

func (messageBroker *MessageBroker) Run()  {
	for {
		select {
		case newSubcriber := <- messageBroker.RegisterSubcriber:
			fmt.Println("register!!!!!")
			messageBroker.Subcribers[newSubcriber] = true
		case removedSubcriber := <- messageBroker.UnregisterSubcriber:
			fmt.Println("unregister!!!!!")
			delete(messageBroker.Subcribers, removedSubcriber)
			close(removedSubcriber.Message)
		case broadcastingMessage := <- messageBroker.BroadcastingMessage:
			fmt.Println("broadcast!!!!!")
			for subcriber := range messageBroker.Subcribers {
				subcriber.Message <- broadcastingMessage
			}
		}
	}
}

func (messageBroker *MessageBroker) sendMessageToSubriber(message Message) {
	// for i := 0; i < len(messageBroker.Subcribers); i++ {
			//  _, _ , err := conn.ReadMessage()
			// if err != nil {
			// 		continue
			// }
			// messageBroker.Subcribers[i].WriteJSON(message)
	// }
}