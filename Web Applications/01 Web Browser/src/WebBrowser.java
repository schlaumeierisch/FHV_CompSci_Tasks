import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class WebBrowser implements ActionListener {
    private JFrame _frame;
    private JLabel _label;
    private JTextField _textField;
    private JButton _button;

    public WebBrowser() {
        // create frame and set settings
        _frame = new JFrame("Web Browser");
        _frame.setSize(600, 75);
        _frame.setLocationRelativeTo(null);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.getContentPane().setLayout(new FlowLayout());

        // create elements (label, text field, button)
        _label = new JLabel("Enter URL:");
        _label.setPreferredSize(new Dimension(75, 25));

        _textField = new JTextField();
        _textField.setPreferredSize(new Dimension(350, 25));

        _button = new JButton("Search");
        _button.setPreferredSize(new Dimension(75, 25));
        _button.addActionListener(this);

        // add elements to frame
        _frame.getContentPane().add(_label);
        _frame.getContentPane().add(_textField);
        _frame.getContentPane().add(_button);

        _frame.setVisible(true);
    }


    // action when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        String textFieldValue = _textField.getText();

        // check if the entered URL is valid
        if (!textFieldValue.isEmpty() && textFieldValue.charAt(0) >= 'A' && textFieldValue.charAt(0) <= 'z') {
            // remove all irrelevant characters from the string
            textFieldValue = textFieldValue.replaceAll("http://", "");
            textFieldValue = textFieldValue.replaceAll("https://", "");

            // split string to get domain and URL path
            String[] textFieldValueSplitted = textFieldValue.split("/", 2);
            String domain = textFieldValueSplitted[0];
            String path = "";

            if (textFieldValueSplitted.length > 1) {
                path = textFieldValueSplitted[1];
            }

            // get address from domain and print connection process
            InetAddress address = null;
            try {
                address = InetAddress.getByName(domain);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }

            System.out.println("Connecting to Server " + domain + " at " + address.getHostAddress());

            try {
                // create socket
                Socket socket = new Socket(domain, 80);

                // send GET request (PrintWriter: write formatted data to a text-output stream)
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println("GET /" + path + " HTTP/1.1");
                printWriter.println("Host: " + domain);
                // with HTTP 1.0 the connection is closed by default, but with HTTP 1.1 this line is required, otherwise the programme hangs up (thanks to Ivo for the tip!)
                printWriter.println("Connection: Close");
                printWriter.println("");
                printWriter.flush();

                // read and print response: if status code is 200, only print entity (text after empty line); else print status code (BufferedReader: reads the text from an input stream)
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String output = bufferedReader.readLine();
                if (output.contains("200")) {
                    boolean printLines = false;
                    while ((output = bufferedReader.readLine()) != null) {
                        if (output.isEmpty()) {
                            printLines = true;
                        } else if (printLines) {
                            System.out.println(output);
                        }
                    }
                } else {
                    String[] outputSplitted = output.split(" ");
                    System.out.println("Status Code: " + outputSplitted[1]);
                }

                // close reader and writer
                bufferedReader.close();
                printWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("URL entered is not valid.");
        }
    }
}
