package com.foxesworld.btncreator;

import static com.foxesworld.btncreator.BtnCreator.btnDir;
import static com.foxesworld.btncreator.BtnCreator.fontsDir;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Button extends JButton implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private boolean entered = false;
    private boolean pressed = false;
    public BufferedImage defaultTX;
    public BufferedImage rolloverTX;
    public BufferedImage pressedTX;
    public BufferedImage lockedTX;

    public Button(String text) {
        addMouseListener(this);
        addMouseMotionListener(this);
        setText(text);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setFocusable(false);
        setCursor(Cursor.getPredefinedCursor(12));
    }

    @Override
    protected void paintComponent(Graphics maing) {
        Graphics2D g = (Graphics2D) maing.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        if (!isEnabled()) {
            g.drawImage(Button.genButton(w, h, this.lockedTX), 0, 0, w, h, null);
        }
        if (this.entered && !this.pressed) {
            g.drawImage(Button.genButton(w, h, this.rolloverTX), 0, 0, w, h, null);
        }
        if (!this.entered) {
            g.drawImage(Button.genButton(w, h, this.defaultTX), 0, 0, w, h, null);
        }

        if ((this.pressed) && (this.entered)) {
            this.entered = false;
            /*try {
                //new MusPlay("click.mp3");
            } catch (Exception e) {
            } */
            g.drawImage(Button.genButton(w, h, this.pressedTX), 0, 0, w, h, null);
            this.pressed = false;
        }
        g.dispose();
        super.paintComponent(maing);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.pressed = (!this.pressed);
        this.entered = true;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.entered = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.entered = false;
        repaint();
    }

    private static BufferedImage genButton(int w, int h, BufferedImage img) {
        BufferedImage res = new BufferedImage(w, h, 2);
        BufferedImage left = img.getSubimage(0, 0, img.getWidth() / 3, img.getHeight());
        BufferedImage center = img.getSubimage(img.getWidth() / 3, 0, img.getWidth() / 3, img.getHeight());
        BufferedImage right = img.getSubimage(img.getWidth() / 3 * 2, 0, img.getWidth() / 3, img.getHeight());
        res.getGraphics().drawImage(left, 0, 0, left.getWidth(), left.getHeight(), null);
        try {
            res.getGraphics().drawImage(fill(center, w - left.getWidth() - right.getWidth(), h), left.getWidth(), 0,
                    w - left.getWidth() - right.getWidth(), h, null);
        } catch (Exception e) {
        }
        res.getGraphics().drawImage(right, w - right.getWidth(), 0, right.getWidth(), h, null);
        return res;
    }

    private static BufferedImage fill(BufferedImage texture, int w, int h) {
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

    public static Font getFont(float size, String fontName) throws IOException, FontFormatException {
        Font font = Font.createFont(0, Button.class.getResourceAsStream(fontsDir + fontName + ".ttf")).deriveFont(size);
        return font.deriveFont(size);
    }
}
