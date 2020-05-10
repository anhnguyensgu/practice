package model

import "github.com/jinzhu/gorm"

type Item struct {
  gorm.Model
  Quantity int
}

type Inventory struct {
  gorm.Model
  product Item `gorm:"foreignkey:ID"`
}

type CreditCard struct {
  gorm.Model
  Number   string
  UserName string
  UserID int
}

type User struct {
  gorm.Model
  CreditCard CreditCard `gorm:"foreignkey:UserName"`
  // CreditCardId int
}