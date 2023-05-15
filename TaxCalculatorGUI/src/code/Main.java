import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    private JButton BtnStart;

    public Main() {
        setTitle("Tax Calculator");
        setSize(600, 600);
        setLocationRelativeTo(null); // 窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗口图标
        ImageIcon icon = new ImageIcon("src\\pic\\TaxIcon.jpg");
        setIconImage(icon.getImage());
        // 添加背景图片
        ImageIcon bgImage = new ImageIcon("src\\pic\\background.jpg");
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, 800, 600);
        getContentPane().add(bgLabel);

        // 添加按钮
        BtnStart = new JButton("开始计算");
        BtnStart.setBounds(250, 300, 100, 20);
        BtnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 点击按钮打开新窗口
                new TableDemo().setVisible(true);
                setVisible(false);
            }
        });
        bgLabel.add(BtnStart, new GridBagConstraints()); // 将按钮添加到label中，并且居中显示
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }

    }
