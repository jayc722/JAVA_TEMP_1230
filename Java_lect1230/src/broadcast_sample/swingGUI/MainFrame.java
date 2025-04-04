package broadcast_sample.swingGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
    private JButton loginButton, guestButton, exitButton;

    public MainFrame() {
        setTitle("방송 편성표 시스템");
        setLayout(new FlowLayout());	
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        loginButton = new JButton("로그인");
        guestButton = new JButton("로그인 없이 조회");
        exitButton = new JButton("종료");

        mainPanel.add(loginButton);
        mainPanel.add(guestButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        // 버튼 이벤트 리스너
        loginButton.addActionListener(e -> {
        	new LoginPanel(this);
        });
        guestButton.addActionListener(e -> {
        	//new SchedulePanel(this);
        });
        exitButton.addActionListener(e -> {
        	System.out.println("종료");
        	exitProgram();
        	
        });

        setVisible(true);
    }
    
    public MainFrame(List<Company> comList, List<User> userList, List<String> companys) {
        setTitle("방송 편성표 시스템");
        setLayout(new FlowLayout());	
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        loginButton = new JButton("로그인");
        guestButton = new JButton("로그인 없이 조회");
        exitButton = new JButton("종료");

        mainPanel.add(loginButton);
        mainPanel.add(guestButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        // 버튼 이벤트 리스너
        loginButton.addActionListener(e -> {
        	new LoginPanel(this,comList, userList, companys);
        });
        guestButton.addActionListener(e -> {
        	
        	new SchedulePanel(this, comList);
        	//new SchedulePanel(this);			//
        });
        exitButton.addActionListener(e -> {
        	System.out.println("종료");
        	exitProgram();
        	
        });

        setVisible(true);
	}

	private void exitProgram() {
        int result = JOptionPane.showConfirmDialog(this, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
