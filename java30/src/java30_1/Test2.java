package java30_1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test2 extends JFrame implements ActionListener {

	JButton jb1 = new JButton("왼쪽으로");
	JButton jb2 = new JButton("오른쪽으로");
	int count = 1;
	JLabel jl = new JLabel();
	JLabel jl2 = new JLabel("" + count);
	HashMap map;

	public Test2() {
		map = new HashMap();
		map.put(1, new ImageIcon("001.jpg"));
		map.put(2, new ImageIcon("002.jpg"));
		map.put(3, new ImageIcon("003.jpg"));
		map.put(4, new ImageIcon("004.jpg"));
		map.put(5, new ImageIcon("005.jpg"));

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		// 중앙에 사진 넣기
		getContentPane().add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
		jl.setIcon(((ImageIcon) map.get(1)));
		panel2.add(jl);
		panel2.add(jl2);
		// 위쪽에 버튼 붙이기
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.add(jb1);
		panel.add(jb2);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jb1.setEnabled(false);

		// 프레임 위치와 나타내기
		setBounds(700, 300, 500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			if (count - 1 > 0) {
				count--;
				jl.setIcon((ImageIcon) map.get(count));
				jl2.setText("" + count);
				if (count == 1) {
					jb1.setEnabled(false);
				} else {
					jb1.setEnabled(true);
				}
				jb2.setEnabled(true);
			}
		}

		if (e.getSource() == jb2) {
			if (count + 1 < 6) {
				count++;
				jl.setIcon((ImageIcon) map.get(count));
				jl2.setText("" + count);
				jb1.setEnabled(true);
				if (count == 5) {
					jb2.setEnabled(false);
				} else {
					jb2.setEnabled(true);
				}
			}
		}

	}

	public static void main(String[] args) {
		new Test2();
	}

}
