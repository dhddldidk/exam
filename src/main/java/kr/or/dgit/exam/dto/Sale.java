package kr.or.dgit.exam.dto;

public class Sale {
	private int no;
	private Product product;
	private int price;
	private int saleCnt;
	private int marginRate;
	private SaleDetail saleDetail;

	public Sale() {
		super();
	}

	
	
	public Sale(int no) {
		super();
		this.no = no;
	}



	public Sale(int no, Product product, int price, int saleCnt, int marginRate, SaleDetail saleDetail) {
		super();
		this.no = no;
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.saleDetail = saleDetail;
	}

	public Sale(Product product, int price, int saleCnt, int marginRate, SaleDetail saleDetail) {
		super();
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
		this.saleDetail = saleDetail;
	}

	public Sale(int no, Product product, int price, int saleCnt, int marginRate) {
		super();
		this.no = no;
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public Sale(Product product, int price, int saleCnt, int marginRate) {
		super();
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	public SaleDetail getSaleDetail() {
		return saleDetail;
	}

	public void setSaleDetail(SaleDetail saleDetail) {
		this.saleDetail = saleDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marginRate;
		result = prime * result + no;
		result = prime * result + price;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + saleCnt;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (marginRate != other.marginRate)
			return false;
		if (no != other.no)
			return false;
		if (price != other.price)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (saleCnt != other.saleCnt)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Sale [no=%s, product=%s, price=%s, saleCnt=%s, marginRate=%s, saleDetail=%s]", no,
				product, price, saleCnt, marginRate, saleDetail);
	}

}
