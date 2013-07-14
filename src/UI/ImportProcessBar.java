package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class ImportProcessBar extends JFrame implements ActionListener {

  //Processing components
  private final File importing_file;
  private int file_length;

  public ImportProcessBar(File importing_file) {
    //build processing data
    this.importing_file = importing_file;
    try {
      this.file_length = file_lines();
      //noinspection UnusedAssignment
      BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.importing_file));
    } catch (IOException e) {
      e.printStackTrace();
    }
    //build GUI components
    JProgressBar progressBar = new JProgressBar(0, this.file_length);
    JButton cancel_button = new JButton("Cancel");
    JButton close_button = new JButton("Close");

    GroupLayout layout = new GroupLayout(this.getContentPane());
    this.getContentPane().setLayout(layout);

    //add processing to each component

    //TODO: add processing to progress bar component

    //TODO: add processing to cancel_button

    //TODO: add processing to close_button

    //add GUI components to layout
    this.add(progressBar);
    this.add(cancel_button);
    this.add(close_button);

    //do layout work
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                  .addComponent(progressBar)
                                  .addGroup(layout.createSequentialGroup()
                                                .addComponent(cancel_button)
                                                .addComponent(close_button))
    );


    layout.setVerticalGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(progressBar)
                                .addGap(50)
                                .addGroup(layout.createParallelGroup()
                                              .addComponent(cancel_button)
                                              .addComponent(close_button))
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
      int readChars;
      while ((readChars = inputStream.read(c)) != -1) {
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
