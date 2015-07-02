package com.whitchsappweb

class Multimidia {
    String filename
    String fullPath
    Date uploadDate = new Date()

    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }

    @Override
    String toString() {
        return "${filename}, created in: ${uploadDate}"
    }
}
