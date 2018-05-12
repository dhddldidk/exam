package kr.or.dgit.exam.ui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.exam.service.SaleService;
import kr.or.dgit.exam.table.AbstractTablePanel;
import kr.or.dgit.exam.table.SaleDatailTablePanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ProductMarginRankUi extends JFrame {

	private JPanel contentPane;
	private boolean flag;

	public ProductMarginRankUi() {
		initComponents();
	}
	
	public ProductMarginRankUi(boolean flag) {
		this.flag = flag;
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 898, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(flag?"판매금액 순위":"마진액 순위");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		AbstractTablePanel salePriceRankTable = new SaleDatailTablePanel();
		contentPane.add(salePriceRankTable);
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("isSalePrice", flag);
		salePriceRankTable.loadData(SaleService.getInstance().callSaleDetail(map));
	
	}

}
