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
    public static ButtonStyle button;

    public BtnCreator(int x, int y, int w, int h, String fontName, String texture, String text, float fontSize, Color color, boolean visible, Align textAlign) {
        
        try {
            button = new ButtonStyle(x, y, w, h, fontName, texture, fontSize, color, visible, textAlign) {
            };
            Button = new Button(text);
            button.apply(Button);
        } catch (IOException | FontFormatException ex) {
        }
    }
    
    public BtnCreator(Boolean visible) {
        try {
            button.visible = visible;
            button.apply(Button);
        } catch (IOException | FontFormatException ex) {}
    }

    public static Button getButton() {
        return Button;
    }
}
