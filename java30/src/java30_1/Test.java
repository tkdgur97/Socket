package java30_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame implements ActionListener{
	
	JButton jb1 = new JButton("왼쪽으로");
	JButton jb2 = new JButton("오른쪽으로");
	JLabel jl;
	int count = 1;
	HashMap map;
	JPanel panel;
	public Test() {
		map = new HashMap();
		map.put(1, new ImageIcon("001.jpg"));
		map.put(2, new ImageIcon("002.jpg"));
		map.put(3, new ImageIcon("003.jpg"));
		map.put(4, new ImageIcon("004.jpg"));
		map.put(5, new ImageIcon("005.jpg"));
		
		
		
		
		panel = new JPanel();
		
		
		
		setLayout(new BorderLayout());
		
		//중앙에 사진 넣기
//		jl = new JLabel((ImageIcon)map.get(count));
//		add(jl, BorderLayout.CENTER);
		
		//위쪽에 버튼 붙이기
		add(panel, BorderLayout.NORTH);
		panel.add(jb1);
		panel.add(jb2);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//프레임 위치와 나타내기
		setBounds(700, 300, 500, 500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			if(count-1>0) {
				System.out.println("왼");
				count--;
				System.out.println(count);
				jl = new JLabel((ImageIcon)map.get(count));
				add(jl, BorderLayout.CENTER);
			}
		}
		
		if(e.getSource()==jb2) {
			if(count+1<6) {
				System.out.println("오");
				count++;
				System.out.println(count);
				jl = new JLabel((ImageIcon)map.get(count));
				
			}
		}
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
