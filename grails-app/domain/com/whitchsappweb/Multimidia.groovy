package com.whitchsappweb

class Multimidia {

    byte[] data
    MultimidiaType type

    static constraints = {
        //maxSize: 200K
        data(maxSize:204800, type:'blob')
    }
}
