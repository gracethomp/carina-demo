package com.qaprosoft.carina.demo.gui.enums;

public enum HeaderButton {
    HOME(0), NEWS(1), REVIEWS(2), VIDEOS(3);

    private final int value;

    HeaderButton(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
