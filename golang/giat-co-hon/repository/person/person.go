package main

import (
	"fmt"
  "github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/postgres"
	
	"../../model"
)

type Product struct {
  gorm.Model
  Code string
  Price uint
}

func main() {
  db, err := gorm.Open("postgres", "host=localhost port=5432 user=postgres dbname=gorm password=123456 sslmode=disable search_path=myschema")
  if err != nil {
    panic(err)
  }
	defer db.Close()
	db.LogMode(true)
	db.AutoMigrate(&model.CreditCard{}, &model.User{})
  // Create
	// var product []Product
	// var count int
	// db.Create(&model.User{CreditCardId: 1})
	card := model.CreditCard{}
	card.ID = 1 
	var user model.User
	user = model.User{}
	user.ID = 1
	// user.ID = 1
	db.Model(&card).Related(&user, "CreditCard")
  // db.Find(&product).Count(&count) // find product with id 1
  // db.First(&product, "code = ?", "L1212") 
	// db.Find(&product).Count(&count)
	// fmt.Println(count)
	fmt.Println(user)
}