package ru.vsu.cs.sazonov;

import java.awt.EventQueue;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.Locale;
import java.util.PriorityQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import ru.vsu.cs.util.SwingUtils;


public class Main {

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();


        Locale.setDefault(Locale.ROOT);

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtils.setDefaultFont("Arial", 20);

        EventQueue.invokeLater(() -> {
            try {
                JFrame frameMain = new FrameMain();
                frameMain.setVisible(true);
                frameMain.setExtendedState(MAXIMIZED_BOTH);
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }
}

