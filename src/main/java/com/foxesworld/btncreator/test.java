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

    //public static ButtonStyle ButtonStyle = new ButtonStyle(65, 60, 200, 47, "test", "test.png", 12F, Color.decode("#a39595"), true, Align.LEFT);
    //public static ButtonStyle ButtonStyle2 = new ButtonStyle(65, 110, 200, 47, "test", "test.png", 12F, Color.decode("#a39595"), true, Align.LEFT);
    //public static Button      Button = new Button("Hello");
    //public static Button      Button2 = new Button("Hello");
    public static Button BtCrt = new BtnCreator(65, 60, 200, 47, "test", "test.png", "Click me", 12F, Color.decode("#a39595"), Align.LEFT).getButton(true);
    public static Button BtCrt2 = new BtnCreator(65, 110, 200, 47, "test", "test.png", "Hello", 12F, Color.decode("#a39595"), Align.LEFT).getButton(true);

    protected JLabel description;
    Integer num = 0;

    /*JPanel*/
    public static JPanel panel;
    private static final Integer WINDOWHEIGHT = 160;
    private static final Integer WINDOWWIDTH = 360;

    public static void main(String[] args) throws IOException, FontFormatException {;
        test test = new test();
    }

    public test() throws IOException, FontFormatException {
        BtCrt.addActionListener(this);
        BtCrt2.addActionListener(this);
        this.description = new JLabel("Buttons generated!");
        this.description.setFont(Functions.getFont(13, "test"));
        this.description.setBounds(50, 20, 240, 23);

        this.screen();
    }

    private void screen() {
        this.setTitle("BtnGenerator by AidenFox");
        setResizable(false);
        test.panel = new JPanel() {
            @Override
            public void paintComponent(Graphics gmain) {
                Graphics2D g = (Graphics2D) gmain;
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(Color.decode("#a27250"));
                g.fillRect(0, 0, WINDOWWIDTH, WINDOWHEIGHT);

                //Desc
                g.setFont(Functions.getFont(3, "test"));
                panel.add(description);
                panel.add(BtCrt);
                panel.add(BtCrt2);
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
        num += 1;
        String text;
        if (e.getSource() == BtCrt) {
            description.setText(num + " Amount of pressed");
        }

        if (e.getSource() == BtCrt2) {
            if (num % 2 == 0) {
                text = "Aiden";
            } else {
                text = "Fox";
            }
            BtCrt2 = new BtnCreator(text).getButton(true);
        }

    }
}
