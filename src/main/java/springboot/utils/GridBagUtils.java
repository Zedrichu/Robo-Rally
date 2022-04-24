package springboot.utils;

import java.awt.*;

public class GridBagUtils {
    public static GridBagConstraints constraint(int x, int y, int inset) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(inset,inset,inset,inset);
        return c;
    }
}
