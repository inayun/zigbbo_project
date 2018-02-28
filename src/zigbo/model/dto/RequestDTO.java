package zigbo.model.dto;

import java.util.Date;

public class RequestDTO {

	private int requestCode;
	private int itemCode; 
	private int memberCode;
	private int views;
	private Date uploadDate;
	private String progress; 
	private String location;
	
	public RequestDTO(int itemCode, int memberCode, String location) {
		//add��
		this.itemCode = itemCode;
		this.memberCode = memberCode;
		this.uploadDate = new Date(0);
		this.views = 0;
		this.progress = "W";
		this.location = location;
	}
	
	public RequestDTO(int requestCode, int itemCode, int memberCode, int views, Date uploadDate,  String progress, String location) {
		this.requestCode = requestCode;
		this.itemCode = itemCode;
		this.memberCode = memberCode;
		this.views = views;
		this.uploadDate = uploadDate;
		this.progress = progress;
		this.location = location;
	}

	public RequestDTO() {
		super();
	}

	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestDTO [requestCode=");
		builder.append(requestCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", memberCode=");
		builder.append(memberCode);
		builder.append(", views=");
		builder.append(views);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", uploadDate=");
		builder.append(uploadDate);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
