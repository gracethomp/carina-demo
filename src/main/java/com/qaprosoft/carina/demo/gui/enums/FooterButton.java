package com.qaprosoft.carina.demo.gui.enums;

public enum FooterButton {
    HOME(0), NEWS(1), REVIEWS(2), COMPARE(3);

    private final int value;

    FooterButton(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
