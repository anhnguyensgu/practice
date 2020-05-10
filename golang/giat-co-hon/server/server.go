package server

import (
	"github.com/gin-gonic/gin"
	"github.com/gorilla/websocket"
	// "github.com/google/uuid"
	"net/http"
	"fmt"
	"../broker"
	// person2 "../repository/person"
)

type person struct {
	Name string
	Age  int
}

type Message struct {
	Id string
	Name string
	Body string
	Time int64
}

var wsupgrader = websocket.Upgrader{
	ReadBufferSize:  1024,
	WriteBufferSize: 1024,
}
var sub []*websocket.Conn
func subcribeTopic(w http.ResponseWriter, r *http.Request, messageBroker *broker.MessageBroker) {
	conn, err := wsupgrader.Upgrade(w, r, nil)
	if err != nil {
		// log.Println(err)
		return
	}
	client := &broker.Subcriber{Hub: messageBroker, Conn: conn, Message: make(chan []byte, 256)}
	client.Hub.RegisterSubcriber <- client
	go client.WriteMessage()
}

func CreateServer() {
	router := gin.Default()
	messageBroker := broker.NewMessageBroker()
	go messageBroker.Run()
	router.LoadHTMLFiles("server/index.html")
	router.GET("/aaa", func(context *gin.Context) {
		context.HTML(200, "index.html", gin.H{"title": "abc"})
	})

	router.GET("/ping", func(c *gin.Context) {
		// fmt.Println("connection number: %d", len(sub))
		// for i:=0; i < len(sub); i++ {
		// 	sub[i].WriteJSON(person{"aaaa", 1})
		// }
		// c.JSON(200, gin.H{
		// 	"message": "pong",
		// })
		messageBroker.BroadcastingMessage <- []byte("broadcasting")
	})

	router.GET("/ws", func(c *gin.Context) {
		fmt.Println("register");
		subcribeTopic(c.Writer, c.Request, messageBroker)
	})
	router.Run(":12312")
}