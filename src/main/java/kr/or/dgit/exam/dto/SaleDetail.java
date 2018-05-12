package kr.or.dgit.exam.dto;

public class SaleDetail {
	private int rank;
	private int supplyPrice;
	private int addTax;
	private int salePrice;
	private int marginPrice;

	public SaleDetail() {

	}

	public SaleDetail(int rank, int supplyPrice, int addTax, int salePrice, int marginPrice) {
		super();
		this.rank = rank;
		this.supplyPrice = supplyPrice;
		this.addTax = addTax;
		this.salePrice = salePrice;
		this.marginPrice = marginPrice;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public int getAddTax() {
		return addTax;
	}

	public void setAddTax(int addTax) {
		this.addTax = addTax;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}

	@Override
	public String toString() {
		return String.format("SaleDetail [rank=%s, supplyPrice=%s, addTax=%s, salePrice=%s, marginPrice=%s]", rank,
				supplyPrice, addTax, salePrice, marginPrice);
	}

}
