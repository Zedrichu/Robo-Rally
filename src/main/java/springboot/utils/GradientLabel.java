package springboot.utils;


import javax.swing.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JLabel;


public class GradientLabel extends JLabel {
        // ------------------------------ FIELDS ------------------------------

        private Color start;
        private Color end;

        // --------------------------- CONSTRUCTORS ---------------------------

        public GradientLabel(String text) {
            super(text);

            start = Color.LIGHT_GRAY;
            end = getBackground();
        }

        public GradientLabel(String text, Color start, Color end) {
            super(text);
            this.start = start;
            this.end = end;
        }

        // -------------------------- OTHER METHODS --------------------------

        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();

            // Create the gradient paint
            GradientPaint paint = new GradientPaint(0, 0, start, width, height, end,
                    true);

            // we need to cast to Graphics2D for this operation
            Graphics2D g2d = (Graphics2D) g;

            // save the old paint
            Paint oldPaint = g2d.getPaint();

            // set the paint to use for this operation
            g2d.setPaint(paint);

            // fill the background using the paint
            g2d.fillRect(0, 0, width, height);

            // restore the original paint
            g2d.setPaint(oldPaint);

            super.paint(g);
        }
}

