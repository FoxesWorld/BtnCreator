package com.foxesworld.btncreator;

import com.foxesworld.btncreator.func.Functions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author AidenFox
 */
public class test extends JFrame implements ActionListener {

    public static BtnCreator btn;
    public static Button Button;
    protected JLabel description;
    Integer num = 0;

    /*JPanel*/
    public static JPanel panel;
    private static final Integer WINDOWHEIGHT = 160;
    private static final Integer WINDOWWIDTH = 360;

    public static void main(String[] args) throws IOException, FontFormatException {
        btn = new BtnCreator(65, 80, 200, 47, "test", "test.png", "Java&Swing", 12F, Color.decode("#a39595"), true, Align.LEFT);
        Button = BtnCreator.getButton();
        test test = new test();
    }

    public test() throws IOException, FontFormatException {
        this.description = new JLabel("Button generated!");
        this.description.setFont(Functions.getFont(14, "test"));
        this.description.setBounds(50, 50, 240, 23);
        Button.addActionListener(test.this);
        this.screen();
    }

    private void screen() {
        this.setTitle("BtnGenerator");
        setDefaultCloseOperation(3);
        setResizable(false);
        test.panel = new JPanel() {
            @Override
            public void paintComponent(Graphics gmain) {
                Graphics2D g = (Graphics2D) gmain;
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //g.drawImage(bgImg, 0, 0, this.getWidth(), this.getHeight(), (ImageObserver) null);
                g.setColor(Color.decode("#a27250"));
                g.fillRect(0, 0, WINDOWWIDTH, WINDOWHEIGHT);

                //Desc
                g.setFont(Functions.getFont(3, "test"));
                //g.setColor(descColor);
                //g.drawString(description, 30, 90);
                panel.add(description);
                panel.add(Button);
            }
        };
        test.panel.setPreferredSize(new Dimension(WINDOWWIDTH, WINDOWHEIGHT));
        add(test.panel, "Center");
        pack();
        setLocationRelativeTo(null);
        validate();
        repaint();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        num+=1;
        description.setText(num +" Times pressed");
    }
}
