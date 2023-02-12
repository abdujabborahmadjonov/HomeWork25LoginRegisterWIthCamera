package dev.abdujabbor.homework25loginregistercontact.models

class User {
    var id: Int? = null
    var name: String? = null
    var password: String? = null
    var number: String? = null
    var image: String? = null

    constructor(id: Int?, name: String?, password: String?, number: String?, image: String?) {
        this.id = id
        this.name = name
        this.password = password
        this.number = number
        this.image = image
    }

    constructor(name: String?, password: String?, number: String?, image: String?) {
        this.name = name
        this.password = password
        this.number = number
        this.image = image
    }
}