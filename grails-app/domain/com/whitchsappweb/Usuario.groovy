package com.whitchsappweb

class Usuario {
    String apelido
    Multimidia picture

    static hasMany = [contatos: Usuario]

    static constraints = {
        apelido unique: true, maxSize: 15, nullable: false
        picture nullable: true
        contatos nullable: true
    }

    @Override
    String toString() {
        return "Usuario: $apelido"
    }
}
