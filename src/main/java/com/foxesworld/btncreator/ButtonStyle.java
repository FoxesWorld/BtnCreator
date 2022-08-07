package com.foxesworld.btncreator;

import static com.foxesworld.btncreator.func.Functions.getFont;
import static com.foxesworld.btncreator.func.Functions.loadImage;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.SwingConstants;

public class ButtonStyle {

    public int xPos = 0;
    public int yPos = 0;
    public int width = 0;
    public int height = 0;
    public String fontName;
    public float fontSize = 1F;
    public Color color;
    public boolean visible = false;
    public Align align;
    public BufferedImage texture;

    public ButtonStyle(int x, int y, int w, int h, String fontName, String texture, float fontSize, Color color, boolean visible, Align textAlign) {
        this.xPos = x;
        this.yPos = y;
        this.width = w;
        this.height = h;
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.color = color;
        this.visible = visible;
        this.align = textAlign;
        this.texture = loadImage(texture);
    }
    
    public ButtonStyle(boolean visible){
        this.visible = visible;
    }

    public void apply(Button button) throws IOException, FontFormatException {
        button.setVisible(visible);
        button.setBounds(xPos, yPos, width, height);
        button.setForeground(color);
        button.setFont(getFont(fontSize, fontName));
        button.setHorizontalAlignment(align == Align.LEFT ? SwingConstants.LEFT : align == Align.CENTER ? SwingConstants.CENTER : SwingConstants.RIGHT);
        int i = texture.getHeight() / 4;

        button.defaultTX = texture.getSubimage(0, 0, texture.getWidth(), i);
        button.rolloverTX = texture.getSubimage(0, i, texture.getWidth(), i);
        button.pressedTX = texture.getSubimage(0, i * 2, texture.getWidth(), i);
        button.lockedTX = texture.getSubimage(0, i * 3, texture.getWidth(), i);
    }
    
    public void setPosition(){
    
    }
}
