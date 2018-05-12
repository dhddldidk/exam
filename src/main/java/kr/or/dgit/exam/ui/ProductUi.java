package kr.or.dgit.exam.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.exam.dto.Product;
import kr.or.dgit.exam.dto.Sale;
import kr.or.dgit.exam.service.ProductService;
import kr.or.dgit.exam.service.SaleService;

public class ProductUi extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfCnt;
	private JTextField tfMargin;
	private JTextField tfName;
	private JButton btnPrint1;
	private ProductService pService;
	private SaleService sService;
	private JButton btnTyping;
	private JButton btnPrint2;
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
		pService = ProductService.getInstance();
		sService = SaleService.getInstance();
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
		tfCode.addFocusListener(this);
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
		
		btnTyping = new JButton("입력");
		btnTyping.addActionListener(this);
		pBottom.add(btnTyping);
		
		btnPrint1 = new JButton("출력1");
		btnPrint1.addActionListener(this);
		pBottom.add(btnPrint1);
		
		btnPrint2 = new JButton("출력2");
		btnPrint2.addActionListener(this);
		pBottom.add(btnPrint2);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPrint2) {
			actionPerformedBtnPrint2(arg0);
		}
		if (arg0.getSource() == btnTyping) {
			actionPerformedBtnTyping(arg0);
		}
		if (arg0.getSource() == btnPrint1) {
			actionPerformedBtnPrint1(arg0);
		}
	}
	protected void actionPerformedBtnPrint1(ActionEvent arg0) {
		ProductMarginRankUi frame = new ProductMarginRankUi(true);
		frame.setVisible(true);
	}
	public void focusGained(FocusEvent arg0) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == tfCode) {
			focusLostTfCode(e);
		}
	}
	protected void focusLostTfCode(FocusEvent e) {
		if(!(tfCode.getText().equals(""))){
			String code = tfCode.getText();
			Product product = new Product();
			product.setCode(code);
			product = pService.selectItemByCode(product);
			tfName.setText(product.getName());
			tfName.setEnabled(false);
			tfName.setFocusable(false);
		}
	}
	protected void actionPerformedBtnTyping(ActionEvent e) {
		if(!(isEmpty())) {
			String code = tfCode.getText();
			String name = tfName.getText();
			int price = Integer.parseInt(tfPrice.getText());
			int saleCnt = Integer.parseInt((tfCnt.getText()));
			int marginRate = Integer.parseInt(tfMargin.getText());
			
			Sale sale = new Sale(new Product(code),price,saleCnt,marginRate);
			sService.insertProduct(sale);
			clearItem();
		}else {
			JOptionPane.showMessageDialog(null, "모든 항목을 입력해주세요");
		}
	}

	private boolean isEmpty() {
		return tfCode.getText().equals("")|| tfName.getText().equals("")||
				tfPrice.getText().equals("")||tfCnt.getText().equals("")||
				tfMargin.getText().equals("");
	}

	private void clearItem() {
		tfCode.setText("");
		tfName.setText("");
		tfPrice.setText("");
		tfCnt.setText("");
		tfMargin.setText("");
	}
	protected void actionPerformedBtnPrint2(ActionEvent arg0) {
		ProductMarginRankUi frame = new ProductMarginRankUi(false);
		frame.setVisible(true);
	}
}
