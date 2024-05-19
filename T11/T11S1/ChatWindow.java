import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ChatWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String TITTLE = "Chat server";

    private final JButton btnStart;
    private final JButton btnStop;
    private final JTextArea log;

    public static void main(String[] args) {
        new ChatWindow();
    }

    private ChatWindow() {
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        log = new JTextArea();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle(TITTLE);
        //setLayout();
        add(btnStart);
        add(btnStop);
        add(log);
        
        setVisible(true);
    }
}
