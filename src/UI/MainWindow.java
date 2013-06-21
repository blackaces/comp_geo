package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame {
  //Creates the Main Window for the UI

  public MainWindow() {
    //create window
    //create menu bar
    setLayout(new FlowLayout());
    JMenuBar menu = new JMenuBar();
    menu.setOpaque(true);
    menu.setPreferredSize(new Dimension(800,20));

    JMenu file = new JMenu("file");
    JMenuItem close = new JMenuItem("close");
    JMenuItem new_item = new JMenuItem("new");

    //on close press close window
    close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }
    });

    file.add(new_item);
    file.add(close);

    menu.add(file);
    add(menu);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("comp-geo");
    setSize(800,600);
    setVisible(true);

  }

  public static void main(String[] args) {
        MainWindow mw = new MainWindow();
  }
}
