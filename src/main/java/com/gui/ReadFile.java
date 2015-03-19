package com.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadFile extends JFrame implements ActionListener {

	public ReadFile() {
		JButton b = new JButton("浏览");
		Container con = this.getContentPane();
		con.add(b);
		b.addActionListener(this);
		this.setLocation(200, 300);
		this.setSize(300, 300);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ReadFile();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("图片文件",
				"jpg", "gif");
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Txt文件",
				"txt");
		chooser.setFileFilter(filter);
		chooser.setFileFilter(filter2);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("打开文件: " + chooser.getSelectedFile().getName());
			JOptionPane.showMessageDialog(this, "打开文件:"
					+ chooser.getSelectedFile().getName());

		}

	}
}