package broadcast_sample.swingGUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminPanel extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField  companyNameField, programNameField, timeField;
    private JButton addButton, updateButton, deleteButton, backButton;

    public AdminPanel(JFrame frame) {  //기본생성자(테스트용)
        setTitle("관리자 모드");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("방송사:"));
        companyNameField = new JTextField();
        panel.add(companyNameField);
        
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

        addButton.addActionListener(e -> {
        	
        JOptionPane.showMessageDialog(this, "프로그램 추가");
        });
        updateButton.addActionListener(e -> {
        JOptionPane.showMessageDialog(this, "프로그램 수정");
        });
        deleteButton.addActionListener(e -> {
        	
        JOptionPane.showMessageDialog(this, "프로그램 삭제");
        });
        
        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}
