package com.whitchsappweb

class Multimidia {
    String filename
    String fullPath
    MultimidiaType type
    Date uploadDate = new Date()

    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }


    def setFullPath(){
        switch (type){
            case MultimidiaType.AUDIO:
                fullPath = com.strings.Paths.uploadAudios + filename
                break;

            case MultimidiaType.VIDEO:
                fullPath = com.strings.Paths.uploadVideos + filename
                break;

            case MultimidiaType.PICTURE:
                fullPath = com.strings.Paths.uploadPictures + filename
                break;

            case MultimidiaType.PROFILE_PICTURE:
                fullPath = com.strings.Paths.uploadProfilePictures + filename
                break;
        }
    }

    @Override
    String toString() {
        return "${filename}, created in: ${uploadDate}"
    }
}
