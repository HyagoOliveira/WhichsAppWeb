package com.strings
/**
 * Created by Hyago on 01/07/2015.
 */

class Paths {

    static def root={
        return new File('.').getCanonicalPath()
    }

    static def uploadProfilePictures={
        return root + '/multimidia/profile/prictures/'
    }

    static def uploadPictures={
        return root + '/multimidia/prictures/'
    }

    static def uploadAudios={
        return root + '/multimidia/audios/'
    }

    static def uploadVideos={
        return root + '/multimidia/videos/'
    }
}
