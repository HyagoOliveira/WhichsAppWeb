import com.strings.Paths

class BootStrap {
    def init = { servletContext ->
        Util.checkdir(Paths.uploadAudios)
        Util.checkdir(Paths.uploadPictures)
        Util.checkdir(Paths.uploadProfilePictures)
        Util.checkdir(Paths.uploadVideos)
    }
    def destroy = {
    }
}
