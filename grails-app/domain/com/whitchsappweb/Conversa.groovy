package com.whitchsappweb

class Conversa {
    Usuario destinatario
    static belongsTo = [remetente: Usuario]
    static hasMany = [mensagens: Mensagem]

    static constraints = {
        mensagens nullable: true
    }
}
