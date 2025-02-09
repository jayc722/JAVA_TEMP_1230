package broadcast_sample.swingGUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminPanel extends JFrame {
    private JTextField programNameField, timeField;
    private JButton addButton, updateButton, deleteButton, backButton;

    public AdminPanel(JFrame frame) {
        setTitle("관리자 모드");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(frame);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("프로그램명:"));
        programNameField = new JTextField();
        panel.add(programNameField);

        panel.add(new JLabel("방송 시간 (HH:MM):"));
        timeField = new JTextField();
        panel.add(timeField);

        addButton = new JButton("추가");
        updateButton = new JButton("수정");
        deleteButton = new JButton("삭제");
        backButton = new JButton("뒤로 가기");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(backButton);

        add(panel);

        addButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "프로그램 추가 완료!"));
        updateButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "프로그램 수정 완료!"));
        deleteButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "프로그램 삭제 완료!"));
        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}
