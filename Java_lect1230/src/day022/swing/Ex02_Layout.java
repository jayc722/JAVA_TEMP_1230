package day022.swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex02_Layout {
	public static void main(String[] args) {
		
		
		/*
		 * FlowLayout
		 * 	-기본 레이아웃, 왼->우 정렬
		 * 
		 * BorderLayout
		 * 	-상/하/좌/우/가운데 배치 가능
		 * 
		 * GridLayout
		 * 	-격자로 표를 만들고 표에 맞게 배치
		 * 
		 * BoxLayout
		 * 	-세로 또는 가로로 정렬
		 * 
		 * GridBagLayout
		 * 	-격자에서 자유로은 배치 가능
		 * 
		 * null Layout
		 * 	-x,y좌표를 지정해서 직접 배치(비추천, 하나하나 일일히 넣어야)
		 */
		
		//sampleBorderLayout();
		
		//sampleGridLayout();
		
		//sampleBoxLayout();
		
		//sampleNullLayout();
		
		sampleGridBagLayout();
		
		
		
		
		
		
	}
		
		private static void sampleGridBagLayout() {
			JFrame frame = new JFrame("Layout 예제");
			frame.setLayout(new GridBagLayout());
			
			frame.setSize(500, 500);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;	//셀 전부 채우기
			gbc.weightx = 1.0;	//버튼 가로로 꽉차게
			gbc.weighty = 1.0;	//버튼 세로로 꽉차게
			
			
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1; 	//너비
			frame.add(new JButton("1"), gbc);	//gbc정보를 넘겨줌
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 2;
			frame.add(new JButton("2"), gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.gridwidth = 1;			
			frame.add(new JButton("3"), gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			frame.add(new JButton("4"), gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			frame.add(new JButton("5"), gbc);

			frame.setVisible(true);
		
	}

		private static void sampleNullLayout() {
			JFrame frame = new JFrame("Layout 예제");
			frame.setLayout(null); 				//null로 만들기
			frame.setSize(500, 500);
			
			JButton btn = new JButton("버튼");
			btn.setBounds(50,50,200,200);		//여기만 빼고
			frame.add(btn);
			frame.setVisible(true);
	}

		private static void sampleBoxLayout() {
			JFrame frame = new JFrame("Layout 예제");
			frame.setSize(500, 500);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			panel.add(new JButton("상"));
			panel.add(new JButton("하"));
			panel.add(new JButton("좌"));
			panel.add(new JButton("우"));
			panel.add(new JButton("중"));

			frame.add(panel);
			frame.setVisible(true);
			
		
	}

		private static void sampleGridLayout() {
			JFrame frame = new JFrame("Layout 예제");
			//지정한 격자보다 컨텐츠가 작으면 격자가 줄어들수 있음
			frame.setLayout(new GridLayout(4, 4));
			
			frame.setSize(500, 500);
			frame.add(new JButton("1"));
			frame.add(new JButton("2"));
			frame.add(new JButton("3"));
			frame.add(new JButton("4"));
			frame.add(new JButton("5"));
			frame.add(new JButton("6"));
			frame.add(new JButton("7"));

			frame.setVisible(true);
		
	}
		
		
		
		
		public static void sampleBorderLayout() {
		JFrame frame = new JFrame("Layout 예제");
		frame.setLayout(new BorderLayout());
		
		frame.setSize(500, 500);
		frame.add(new JButton("상"), BorderLayout.NORTH);
		frame.add(new JButton("하"), BorderLayout.SOUTH);
		frame.add(new JButton("좌"), BorderLayout.WEST);
		frame.add(new JButton("우"), BorderLayout.EAST);
		frame.add(new JButton("중"), BorderLayout.CENTER);

		frame.setVisible(true);
		}
	
}
