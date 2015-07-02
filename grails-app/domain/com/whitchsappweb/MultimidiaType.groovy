package com.whitchsappweb

public  enum MultimidiaType {
    VIDEO('Video'),
    AUDIO('Audio'),
    PICTURE('Picture'),
    PROFILE_PICTURE('Profile_Picture')

    String type

    MultimidiaType(String type) {
        this.type = type
    }

    @Override
    String toString() {
        return [VIDEO, AUDIO, PICTURE, PROFILE_PICTURE]
    }
}
