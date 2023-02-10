package dev.abdujabbor.homework25loginregistercontact.models

class Usercha{
    var id:Int? = null
    var name:String? = null
    var password:String? = null


    constructor(id: Int?, name: String?, password: String?) {
        this.id = id
        this.name = name
        this.password = password

    }

    constructor( name: String?, password: String?) {
        this.name = name
        this.password = password

    }
}