package broadcast_sample.swingGUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SchedulePanel extends JFrame {
    private JComboBox<String> companyBox;
    private JTextArea scheduleArea;
    private JButton backButton;

    public SchedulePanel(JFrame parent) {
        setTitle("편성표 조회");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        companyBox = new JComboBox<>(new String[]{"KBS", "SBS", "MBC"});
        scheduleArea = new JTextArea("편성표 출력 영역");
        scheduleArea.setEditable(false);
        backButton = new JButton("뒤로 가기");

        panel.add(companyBox, BorderLayout.NORTH);
        panel.add(new JScrollPane(scheduleArea), BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);

        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}
