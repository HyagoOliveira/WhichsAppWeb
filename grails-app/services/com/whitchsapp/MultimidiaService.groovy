package com.whitchsapp

import com.whitchsappweb.Multimidia

class MultimidiaService {

    def grailsApplication

    private static final okimage = ['image/png', 'image/jpeg', 'image/gif']

    def save(def file) {
        def path = ''
        if(okimage.contains(file.getContentType()))
            path = grailsApplication.config.uploadPictureFolder
        else {
            flash.message = "Tipo de multimidia não aceito"
            render(view:'create')
            return
        }

        //TODO
        //outros ifs

        if(file.empty) {
            flash.message = "File cannot be empty"
        } else {
            def multimidiaInstance = new Multimidia()
            multimidiaInstance.filename = file.originalFilename
            multimidiaInstance.fullPath = path + multimidiaInstance.filename
            file.transferTo(new File(multimidiaInstance.fullPath))

            if (!multimidiaInstance.save(flush: true)) {
                flash.message = "Erro ao salvar"
            }

            return multimidiaInstance
        }
    }
}
