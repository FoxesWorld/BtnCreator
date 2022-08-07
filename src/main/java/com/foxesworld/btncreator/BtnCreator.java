package com.foxesworld.btncreator;

import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 *
 * @author AidenFox
 */
public class BtnCreator {

    public final static String btnDir = "/assets/buttons/";
    public final static String fontsDir = "/assets/fonts/";

    public static Button Button;
    public static ButtonStyle ButtonStyle;

    public BtnCreator(int x, int y, int w, int h, String fontName, String texture, String title, float fontSize, Color color, boolean visible, Align textAlign) {
        Button = new Button(texture);
        ButtonStyle = new ButtonStyle(x, y, w, h, fontName, texture, fontSize, color, visible, textAlign);
        try {
            Button.setText(title);
            ButtonStyle.apply(Button);
        } catch (IOException | FontFormatException ex) {
        }
    }

    public BtnCreator(Boolean visible) {
        try {
            ButtonStyle.visible = visible;
            ButtonStyle.apply(Button);
        } catch (IOException | FontFormatException ex) {
        }
    }

    public BtnCreator(String btnText) {
        try {
            Button.setText(btnText);
            ButtonStyle.apply(Button);
        } catch (IOException | FontFormatException ex) {
        }
    }

    public BtnCreator(int x, int y, int w, int h) {
        try {
            ButtonStyle.xPos = x;
            ButtonStyle.yPos = y;
            ButtonStyle.width = w;
            ButtonStyle.height = h;
            ButtonStyle.apply(Button);
        } catch (IOException | FontFormatException ex) {
        }
    }

    public static Button getButton() {
        return Button;
    }
}
