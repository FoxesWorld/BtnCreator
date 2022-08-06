package com.foxesworld.btncreator.func;

import static com.foxesworld.btncreator.BtnCreator.btnDir;
import static com.foxesworld.btncreator.BtnCreator.fontsDir;
import com.foxesworld.btncreator.Button;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author AidenFox
 */
public class Functions {

    public static BufferedImage fill(BufferedImage texture, int w, int h) {
        int sizex = texture.getWidth();
        int sizey = texture.getHeight();
        BufferedImage img = new BufferedImage(w, h, 2);
        for (int x = 0; x <= w / sizex; x++) {
            for (int y = 0; y <= h / sizey; y++) {
                img.getGraphics().drawImage(texture, x * sizex, y * sizey, null);
            }
        }
        return img;
    }

    public static BufferedImage loadImage(String name) {
        try {
            return ImageIO.read(Button.class.getResource(btnDir + name));
        } catch (IOException e) {
            return new BufferedImage(1, 1, 2);
        }
    }

    public static Font getFont(float size, String fontName) {
        Font font = null;
        try {
            font = Font.createFont(0, Button.class.getResourceAsStream(fontsDir + fontName + ".ttf")).deriveFont(size);
        } catch (FontFormatException | IOException ex) {
        }
        return font.deriveFont(size);
    }
}
