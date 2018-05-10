package kr.or.dgit.exam.table;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.exam.dto.Sale;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

public class ProductMarginTable extends JPanel {

	private JTable table;
	private int supplyPriceTotal;
	private int taxTotal;
	private int sellingPriceTotal;
	private int marginPriceTotal;

	public ProductMarginTable() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDatas();
		scrollPane.setViewportView(table);
	}

	private void loadDatas() {
		NonEditableModel model = new NonEditableModel(getRows(), getColumNames());
		table.setModel(model);
		setAlignWidth();

	}

	private Object[] getColumNames() {

		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

	private Object[][] getRows() {
		Object[][] rows = null;

		supplyPriceTotal = 0;
		taxTotal = 0;
		sellingPriceTotal = 0;
		marginPriceTotal = 0;

		try {
			List<Sale> list = ManagementDao.getInstance().selectItemByAllRank();
			rows = new Object[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				rows[i] = list.get(i).toArray();
				supplyPriceTotal += list.get(i).getSupplyprice();
				taxTotal += list.get(i).getTax();
				sellingPriceTotal += list.get(i).getSellingprice();
				marginPriceTotal += list.get(i).getMarginprice();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;

	}

	private void setAlignWidth() {
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		tableCellWidth(200, 300, 400, 300, 200, 400, 400, 400, 300, 400);

	}

	private void tableCellAlign(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	private void tableCellWidth(int... width) {
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	public Object[] getTotal() {
		return new String[] { String.format("%,d", supplyPriceTotal), String.format("%,d", taxTotal),
				String.format("%,d", sellingPriceTotal), String.format("%,d", marginPriceTotal) };
	}
}
