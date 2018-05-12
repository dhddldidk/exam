package kr.or.dgit.exam.table;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

import kr.or.dgit.exam.service.SaleService;

public class SaleDatailTablePanel extends AbstractTablePanel {

	
	
	public SaleDatailTablePanel() {
		// TODO Auto-generated constructor stub
	}

	public SaleDatailTablePanel (boolean isSalePrice) {
		super(isSalePrice?"판매금액 순위":"마진액 순위");
	}
	
	@Override
	protected void setAlignWith() {
		tableCellAlignment(SwingConstants.CENTER, 0,1,2,8);
		tableCellAlignment(SwingConstants.RIGHT, 3,4,5,6,7,9);
		tableSetWidth(100,100,150,100,100,150,150,150,100,150);

	}

	@Override
	protected Object[][] toArray(List<? extends ToArray> items) {
		Object[][] results = new Object[items.size()+1][];
		for(int i=0; i<items.size(); i++) {
			results[i] = items.get(i).toArray();
			
		}
		results[items.size()]=getTotal();
		System.out.println(Arrays.deepToString(results)+"dfdfsafdsfsfdsdfddsdssdfsfd");
		return results;
	}

	private Object[] getTotal() {
		List<Map<String, Object>> res = SaleService.getInstance().callGetTotal();
		Map<String, Object> maps = res.get(0);
		
		String[] total = new String[10];
		total[0]="합계";
		Arrays.fill(total, 1,4,"");
		total[5]=String.format("%,.0f", maps.get("supplyPrice"));
		total[6]=String.format("%,.0f", maps.get("addTax"));
		total[7]=String.format("%,.0f", maps.get("salePrice"));
		total[8]="";
		total[9]=String.format("%,.0f", maps.get("marginPrice"));
		System.out.println(Arrays.toString(total)+"마진액 찍어보기");
		return total;
	}

	@Override
	public void setColumnNames() {
		colNames = new String[] {"순위","제품코드","제품명","제품단가","판매수량","공급가액","부가세액","판매금액","마진율","마진액"};
		
	}
}
