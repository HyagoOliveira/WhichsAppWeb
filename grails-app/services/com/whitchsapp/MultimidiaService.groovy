package com.whitchsapp

import com.whitchsappweb.Multimidia
import com.whitchsappweb.MultimidiaType

class MultimidiaService {



    def save(def file, MultimidiaType type) {

        if(file.empty) {
            flash.message = "File cannot be empty"
        } else {
            def multimidiaInstance = new Multimidia()
            multimidiaInstance.filename = file.originalFilename
            multimidiaInstance.type = type
            multimidiaInstance.setFullPath()

            file.transferTo(new File(multimidiaInstance.fullPath))

            if (!multimidiaInstance.save(flush: true)) {
                flash.message = "Erro ao salvar"
            }

            return multimidiaInstance
        }
    }
}
