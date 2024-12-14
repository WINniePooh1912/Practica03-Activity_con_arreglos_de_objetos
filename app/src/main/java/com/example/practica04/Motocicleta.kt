package com.example.practica04

class Motocicleta {
    var model: String
    var price: Double
    var year: Int
    var brand: String

    // constructores
    constructor() {
        model = ""
        price = 0.0
        year = 0
        brand = ""
    }

    constructor(model: String, price: Double, year: Int, brand: String) {
        this.model = model
        this.price = price
        this.year = year
        this.brand = brand
    }
}