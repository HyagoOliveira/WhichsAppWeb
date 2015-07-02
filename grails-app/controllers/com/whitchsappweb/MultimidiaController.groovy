package com.whitchsappweb

import org.springframework.dao.DataIntegrityViolationException

class MultimidiaController {

    def multimidiaService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def create() {
        [multimidiaInstance: new Multimidia(params)]
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [multimidiaInstanceList: Multimidia.list(params), multimidiaInstanceTotal: Multimidia.count()]
    }


    def upload() {
        def file = request.getFile('file')
        multimidiaService.save(file)
        redirect (action:'list')
    }

    def download(long id) {
        Multimidia multimidiaInstance = Multimidia.get(id)
        if ( multimidiaInstance == null) {
            flash.message = "Multimidia File not found."
            redirect (action:'list')
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${multimidiaInstance.filename}\"")
            def file = new File(multimidiaInstance.fullPath)
            def fileInputStream = new FileInputStream(file)
            def outputStream = response.getOutputStream()
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fileInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush()
            outputStream.close()
            fileInputStream.close()
        }
    }

    def delete(Long id) {
        def multimidiaInstance = Multimidia.get(id)
        if (!multimidiaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'multimidia.label', default: 'Multimidia'), id])
            redirect(action: "list")
            return
        }

        try {
            multimidiaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'multimidia.label', default: 'Multimidia'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'multimidia.label', default: 'Multimidia'), id])
            redirect(action: "show", id: id)
        }
    }
}
