package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ImportProcessBar extends JFrame implements ActionListener {
  //GUI components
  private JButton cancel_button;
  private JButton close_button;
  private JProgressBar progressBar;

  //Processing components
  private File importing_file;
  private int file_length;
  private BufferedInputStream bufferedInputStream;

  public ImportProcessBar(File importing_file) {
    //build processing data
    this.importing_file = importing_file;
    try {
      this.file_length = file_lines();
      this.bufferedInputStream = new BufferedInputStream(new FileInputStream(this.importing_file));
    } catch (IOException e) {
      e.printStackTrace();
    }
    //build GUI components
    this.progressBar = new JProgressBar(0, this.file_length);
    this.cancel_button = new JButton("Cancel");
    this.close_button = new JButton("Close");

    GroupLayout layout = new GroupLayout(this.getContentPane());
    this.getContentPane().setLayout(layout);

    //add processing to each component

    //TODO: add processing to progress bar component

    //TODO: add processing to cancel_button

    //TODO: add processing to close_button

    //add GUI components to layout
    this.add(this.progressBar);
    this.add(this.cancel_button);
    this.add(this.close_button);

    //do layout work
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                  .addComponent(this.progressBar)
                                  .addGroup(layout.createSequentialGroup()
                                                .addComponent(this.cancel_button)
                                                .addComponent(this.close_button))
    );


    layout.setVerticalGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(this.progressBar)
                                .addGap(50)
                                .addGroup(layout.createParallelGroup()
                                              .addComponent(this.cancel_button)
                                              .addComponent(this.close_button))
    );

    this.setSize(400, 200);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setTitle("Importing " + this.importing_file.getName());
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

  }

  private int file_lines() throws IOException {
    InputStream inputStream = new BufferedInputStream(new FileInputStream(this.importing_file));
    try {
      byte[] c = new byte[1024];
      int lines = 0;
      int readChars = 0;
      boolean empty = true;
      while ((readChars = inputStream.read(c)) != -1) {
        empty = false;
        for (int i = 0; i < readChars; ++i) {
          if (c[i] == '\n') {
            lines++;
          }
        }
      }
      return lines;
    } finally {
      inputStream.close();
    }
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    //TODO: write code for actionPerformed in UI.ImportProcessBar
  }
}
