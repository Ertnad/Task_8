package ru.vsu.sc.tretyakov_d_s;

import java.util.Locale;
import ru.vsu.sc.tretyakov_d_s.Utils.SwingUtils;

public class GuiMain {

    public static void main(String[] args) throws Exception {
        winMain();
    }

    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);

        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

}