package com.whitchsappweb

public  enum MultimidiaType {
    VIDEO('Video'),
    AUDIO('Audio'),
    PICTURE('Picture')

    String type

    MultimidiaType(String type) {
        this.type = type
    }

    @Override
    String toString() {
        return [VIDEO, AUDIO, PICTURE]
    }
}
