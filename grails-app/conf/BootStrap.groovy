class BootStrap {
    def grailsApplication

    def init = { servletContext ->
        Util.checkdir(grailsApplication.config.uploadAudioFolder)
        Util.checkdir(grailsApplication.config.uploadVideoFolder)
        Util.checkdir(grailsApplication.config.uploadPictureFolder)
    }
    def destroy = {
    }
}
