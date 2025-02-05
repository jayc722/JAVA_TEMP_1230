package day022.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex01_Swing {

	
	//jdk 기본 제공 기능->따로설치할 필요 x
	//오래된 기능이라 찾기는 쉽지만 기능은 좀 떨어짐
	//gui환경 구축에 사용(컴포넌트로 구성)
	public static void main(String[] args) {

		/* 컴포넌트 구성
		 * 	-메인창
		 * 		-JFrame
		 * 	-버튼
		 * 		-JButton
		 * 	-텍스트	
		 * 		-JLabel
		 * 	
		 * 	-텍스트입력창
		 *		-한줄
		 *			-JTextField
		 *		-여러줄
		 *			-JTextArea
		 * 	
		 */
		
		/*
		 * 패널
		 * 	
		 * 	-컴포넌트를 묶어서 관리
		 * 	-
		 * 
		 */
		
		
		JFrame frame = new JFrame("애플리케이션 예제");
		
		frame.setLayout(new FlowLayout());		//이건 나중에 설명 -> 버튼 라벨 배치
		
		frame.setSize(400,500);	//프레임 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기 버튼
		
		JButton btn = new JButton("버튼");			//만들기
		//frame.add(btn);								//화면에 추가
		
		JLabel label = new JLabel("라벨");
		//frame.add(label);					//배치 설정을 안해서 버튼을 가림
		
		//JTextField textField = new JTextField("텍스트");
		JTextField textField = new JTextField(30);	//글자 30개 들어가는 30줄행 만들기
		//frame.add(textField);

		JTextArea textArea = new JTextArea(20, 30);		//20x30 입력가능한 텍스트에리어
		textArea.append("안녕하세요\n");
		textArea.append("제 이름은 홍길동 입니다.\n");
		textArea.setEditable(true);		//수정이 가능한지
		textArea.setEditable(false);		//읽기 전용
		//frame.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(btn);
		panel.add(label);
		panel.add(textField);
		panel.add(textArea);
		
		frame.add(panel);	//보여지는건 각각 add하는거랑 동일. 묶어서 
		
		
		frame.setVisible(true);			//화면에 보여줄지 말지
		
		
		
	}

}
