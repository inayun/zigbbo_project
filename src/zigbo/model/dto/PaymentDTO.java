package zigbo.model.dto;

public class PaymentDTO {

	private int paymentCode; //�Է�X
	private int sellingCode; //� �ǸŸ�
	private int memberCode; //� ȸ���� ���Ÿ� �ϸ�
	private String address; //�ֹ����� ����
	
	public PaymentDTO() {}
	
	public PaymentDTO(int sellingCode, int memberCode, String address) {
		this.sellingCode = sellingCode;
		this.memberCode = memberCode;
		this.address = address;
	}
	public PaymentDTO(int paymentCode, int sellingCode, int memberCode, String address) {
		this.paymentCode = paymentCode;
		this.sellingCode = sellingCode;
		this.memberCode = memberCode;
		this.address = address;
	}
	
	public int getPaymentCode() {
		return paymentCode;
	}
	
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	
	public int getSellingCode() {
		return sellingCode;
	}
	
	public void setSellingCode(int sellingCode) {
		this.sellingCode = sellingCode;
	}
	
	public int getMemberCode() {
		return memberCode;
	}
	
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentDTO [paymentCode=").append(paymentCode).append(", sellingCode=").append(sellingCode)
				.append(", memberCode=").append(memberCode).append(", address=").append(address).append("]");
		return builder.toString();
	}
	
}
