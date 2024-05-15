import javax.swing.*;
import java.awt.*;

public class HeartFrame extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private static final String HEART = "\u2764";
    private static final String SPACE = " ";
    private final JLabel label;
    private boolean isHeart = true;

    public HeartFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        label = new JLabel();
        setTitle("\u4F60\u88AB\u9A97\u4E86\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8");
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 200));
        label.setForeground(Color.RED);
        add(label);


        // 启动线程，每隔0.1秒切换一次爱心和空格
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isHeart) {
                    label.setText(SPACE);
                    isHeart = false;
                } else {
                    label.setText(HEART);
                    isHeart = true;
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        HeartFrame frame = new HeartFrame();
        frame.setVisible(true);
    }
}

