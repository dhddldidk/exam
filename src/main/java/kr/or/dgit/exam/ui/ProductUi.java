package kr.or.dgit.exam.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfCnt;
	private JTextField tfMargin;
	private JTextField tfName;
	private JButton btnPrint1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUi frame = new ProductUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductUi() {
		initComponents();
	}
	private void initComponents() {
		setTitle("입력화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pContainer = new JPanel();
		contentPane.add(pContainer, BorderLayout.CENTER);
		pContainer.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel pLeft = new JPanel();
		pContainer.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pCode = new JPanel();
		pCode.setBorder(new EmptyBorder(5, 5, 5, 5));
		pLeft.add(pCode);
		pCode.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("제품코드 : ");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		pCode.add(lblCode);
		
		tfCode = new JTextField();
		pCode.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel pPrice = new JPanel();
		pPrice.setBorder(new EmptyBorder(5, 5, 5, 5));
		pLeft.add(pPrice);
		pPrice.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPrice = new JLabel("제품단가 : ");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		pPrice.add(lblPrice);
		
		tfPrice = new JTextField();
		pPrice.add(tfPrice);
		tfPrice.setColumns(10);
		
		JPanel pCnt = new JPanel();
		pCnt.setBorder(new EmptyBorder(5, 5, 5, 5));
		pLeft.add(pCnt);
		pCnt.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblCnt = new JLabel("판매수량 : ");
		lblCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		pCnt.add(lblCnt);
		
		tfCnt = new JTextField();
		pCnt.add(tfCnt);
		tfCnt.setColumns(10);
		
		JPanel pMargin = new JPanel();
		pMargin.setBorder(new EmptyBorder(5, 5, 5, 5));
		pLeft.add(pMargin);
		pMargin.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblMargin = new JLabel("마 진 율 : ");
		lblMargin.setHorizontalAlignment(SwingConstants.RIGHT);
		pMargin.add(lblMargin);
		
		tfMargin = new JTextField();
		pMargin.add(tfMargin);
		tfMargin.setColumns(10);
		
		JPanel pRight = new JPanel();
		pContainer.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pName = new JPanel();
		pName.setBorder(new EmptyBorder(5, 5, 5, 5));
		pRight.add(pName);
		pName.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblName = new JLabel("제 품 명 : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pName.add(lblName);
		
		tfName = new JTextField();
		pName.add(tfName);
		tfName.setColumns(10);
		
		JPanel pEmpty1 = new JPanel();
		pRight.add(pEmpty1);
		
		JPanel pEmpty2 = new JPanel();
		pRight.add(pEmpty2);
		
		JPanel pEmpty3 = new JPanel();
		pRight.add(pEmpty3);
		
		JPanel pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);
		
		JButton btnTyping = new JButton("입력");
		pBottom.add(btnTyping);
		
		btnPrint1 = new JButton("출력1");
		btnPrint1.addActionListener(this);
		pBottom.add(btnPrint1);
		
		JButton btnPrint2 = new JButton("출력2");
		pBottom.add(btnPrint2);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPrint1) {
			actionPerformedBtnPrint1(arg0);
		}
	}
	protected void actionPerformedBtnPrint1(ActionEvent arg0) {
		ProductMarginRankUi frame = new ProductMarginRankUi();
		frame.setVisible(true);
	}
}
