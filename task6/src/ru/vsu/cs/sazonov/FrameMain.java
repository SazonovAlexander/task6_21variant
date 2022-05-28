package ru.vsu.cs.sazonov;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JPanel defaultPanel;
    private JPanel ownPanel;
    private JTextArea queueOwn;
    private JSpinner spinnerKeyOwn;
    private JButton addButtonOwn;
    private JSpinner spinnerPriorityDefault;
    private JButton buttonAddDefault;
    private JTextArea extractValueOwn;
    private JButton buttonExtractOwn;
    private JSpinner spinnerValueDefault;
    private JTextArea extractValueDefault;
    private JButton extractButtonDefault;
    private JTextArea queueDefault;
    private JTextArea valueOwn;
    private JTextArea valueDefault;

    TreeMapPriorityQueue defaultQueue = new DefaultTreeMapPriorityQueue();
    TreeMapPriorityQueue ownQueue = new BSTreeMapPriorityQueue();


    public FrameMain() {
    this.setTitle("Приоритетная очередь");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        extractButtonDefault.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extractValueDefault.setText((String) defaultQueue.extract());
                queueDefault.setText(defaultQueue.toText());
            }
        });
        
        buttonAddDefault.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultQueue.insert ((Integer) spinnerPriorityDefault.getValue(), valueDefault.getText());
                valueDefault.setText("");
                spinnerPriorityDefault.setValue(0);
                queueDefault.setText(defaultQueue.toText());
            }
        });
        addButtonOwn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownQueue.insert((Integer) spinnerKeyOwn.getValue(), valueOwn.getText());
                valueOwn.setText("");
                spinnerKeyOwn.setValue(0);
                queueOwn.setText(ownQueue.toText());
            }
        });
        buttonExtractOwn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extractValueOwn.setText((String) ownQueue.extract());
                queueOwn.setText(ownQueue.toText());
            }
        });
    }
}
