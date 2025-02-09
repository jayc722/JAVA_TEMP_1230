package broadcast_sample.swingGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SchedulePanel extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> companyBox;
    private JTextArea scheduleArea;
    private JButton backButton;
    private List<Company> companies;
    
    public SchedulePanel(JFrame frame) {
        setTitle("편성표 조회");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        companyBox = new JComboBox<>(new String[]{"KBS", "SBS", "MBC"});
        scheduleArea = new JTextArea("편성표 출력");
        scheduleArea.setEditable(false);
        backButton = new JButton("뒤로 가기");

        panel.add(companyBox, BorderLayout.NORTH);
        panel.add(new JScrollPane(scheduleArea), BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);

        backButton.addActionListener(e -> dispose());

        setVisible(true);
    }

	public SchedulePanel(JFrame mainFrame, List<Company> comList, List<String> companys) {
	       setTitle("편성표 조회");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        companies = comList;
	        
	        if (companies == null) {
	            JOptionPane.showMessageDialog(this, "저장된 방송사가 없습니다.");
	            dispose();
	            return;
	        }
	        String[] companyNames = companies.stream().map(Company::getCompanyName).toArray(String[]::new);
	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());

	        companyBox = new JComboBox<>(companyNames);
	        scheduleArea = new JTextArea("편성표 출력 ");
	        scheduleArea.setEditable(false);
	        backButton = new JButton("뒤로 가기");

	        panel.add(companyBox, BorderLayout.NORTH);
	        panel.add(new JScrollPane(scheduleArea), BorderLayout.CENTER);
	        panel.add(backButton, BorderLayout.SOUTH);

	        add(panel);

	        // 방송사 선택
	        companyBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateScheduleDisplay();
	            }
	        });

	        // 뒤로 가기
	        backButton.addActionListener(e -> dispose());

	        // 초
	        updateScheduleDisplay();

	        setVisible(true);
	    }    private void updateScheduleDisplay() {
	        int selectedIndex = companyBox.getSelectedIndex();
	        if (selectedIndex < 0) return;

	        Company selectedCompany = companies.get(selectedIndex);
	        StringBuilder scheduleText = new StringBuilder();

	        scheduleText.append("방송사: ").append(selectedCompany.getCompanyName()).append("\n");
	        scheduleText.append("================================\n");

	        if (selectedCompany.getList().isEmpty()) {
	            scheduleText.append("등록된 프로그램이 없습니다.\n");
	        } else {
	            for (TimeTable program : selectedCompany.getList()) {
	                scheduleText.append(program.toString()).append("\n");
	            }
	        }

	        scheduleArea.setText(scheduleText.toString());
	    }
	
}
