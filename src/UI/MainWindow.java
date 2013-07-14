package UI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame {
  //Creates the Main Window for the UI

  private MainWindow() {
    //obtain window bounds
    Rectangle windowBounds;
    windowBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

    //create window
    //create menu bar
    setLayout(new BorderLayout());
    JMenuBar menu = new JMenuBar();
    menu.setOpaque(true);
    menu.setPreferredSize(new Dimension((int) windowBounds.getWidth(), 20));

    JMenu file = new JMenu("file");
    JMenuItem close = new JMenuItem("close");
    JMenuItem import_p = new JMenuItem("import points");
    JMenuItem import_e = new JMenuItem("import edges");

    //on close press close window
    close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }
    });

    import_p.addActionListener(new ActionListener() {
      final JFileChooser chooser = new JFileChooser();

      public void actionPerformed(ActionEvent e) {
        chooser.setFileFilter(new FileNameExtensionFilter("Point files only", "pnt"));
        int chosen = chooser.showOpenDialog(MainWindow.this);
        //open file
        if (chosen == JFileChooser.APPROVE_OPTION) {
          //process file
          process(chooser.getSelectedFile());
        }
      }
    });

    import_e.addActionListener(new ActionListener() {
      final JFileChooser chooser = new JFileChooser();

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        chooser.setFileFilter(new FileNameExtensionFilter("Edge files only", "edg"));
        int chosen = chooser.showOpenDialog(MainWindow.this);
        //open file
        if (chosen == JFileChooser.APPROVE_OPTION) {
          //process file
          process(chooser.getSelectedFile());
          //noinspection UnusedAssignment
          final ImportProcessBar importProcessBar = new ImportProcessBar(chooser.getSelectedFile());
        }
      }

    });

    file.add(import_p);
    file.add(import_e);
    file.addSeparator();
    file.add(close);

    menu.add(file);

    //add help menu
    JMenu help = new JMenu("help");
    JMenuItem help_contents = new JMenuItem("contents");
    JMenuItem about = new JMenuItem("about");

    help.add(help_contents);
    help.add(about);

    menu.add(help);

    //add menu to panel
    add(menu, BorderLayout.NORTH);


    //add a side pane
    JPanel sidePane = new JPanel();
    sidePane.setPreferredSize(new Dimension(200, (int) (windowBounds.getHeight() - menu.getHeight())));
    sidePane.setBorder(BorderFactory.createLineBorder(Color.black));
    add(sidePane, BorderLayout.WEST);


    //add a panel
    JPanel mainPanel = new JPanel();
    mainPanel.setPreferredSize(new Dimension((int) (windowBounds.getWidth() - 210), (int) (windowBounds.getHeight() - menu.getHeight())));
    mainPanel.setBackground(Color.blue);
    add(mainPanel);

    //set properties of main window
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("comp-geo");
    setSize(800, 600);
    setLocationRelativeTo(null);
    setVisible(true);

  }

  public static void main(String[] args) {
    //noinspection UnusedAssignment
    MainWindow mw = new MainWindow();
  }

  /* TODO: write code for processing files into data structures */
  private static void process(File file) {
    if (file.getName().endsWith(".pnt")) {
      //  TODO: process point file
    } else if (file.getName().endsWith(".edg")) {
      //  TODO: process edge file
    }
  }
}
