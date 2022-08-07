package com.foxesworld.btncreator;

import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AidenFox
 */
public class BtnCreator {

    public final static String btnDir = "/assets/buttons/";
    public final static String fontsDir = "/assets/fonts/";

    public static Button Button;
    public static ButtonStyle ButtonStyle;

    public BtnCreator(int x, int y, int w, int h, String fontName, String texture, String title, float fontSize, Color color, Align textAlign) {
        Button = new Button(texture);
        System.out.println("[" + title + "] PosX " + x + " PosY " + y + " With: " + w + " Height: " + h);
        ButtonStyle = new ButtonStyle(x, y, w, h, fontName, texture, fontSize, color, textAlign);
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

    public static Button getButton(Boolean display) {
        ButtonStyle.visible = display;
        try {
            ButtonStyle.apply(Button);
        } catch (IOException | FontFormatException ex) {
            Logger.getLogger(BtnCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Button;
    }
}
