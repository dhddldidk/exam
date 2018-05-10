package kr.or.dgit.exam.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kr.or.dgit.exam.table.ProductMarginTable;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ProductMarginRankUi extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public ProductMarginRankUi() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pmTitle = new JPanel();
		contentPane.add(pmTitle, BorderLayout.NORTH);
		pmTitle.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblMarginRank = new JLabel("마 진 액 순 위");
		lblMarginRank.setFont(new Font("굴림", Font.PLAIN, 30));
		lblMarginRank.setHorizontalAlignment(SwingConstants.CENTER);
		pmTitle.add(lblMarginRank);
		
		ProductMarginTable pmMiddle = new ProductMarginTable();
		contentPane.add(pmMiddle, BorderLayout.CENTER);
		
		JPanel pmTotal = new JPanel();
		contentPane.add(pmTotal, BorderLayout.SOUTH);
		pmTotal.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
