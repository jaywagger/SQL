package jdbt.dept;

import java.sql.Date;

public class DeptDTO {
	private int deptNum;
	private String id;
	private String title;
	private String content;
	private Date writeDate;
	private int hit;
	
	public DeptDTO() {
	}
	//insert¿ë
	public DeptDTO(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	//select¿ë
	public DeptDTO(int deptNum, String id, String title, String content, Date writeDate, int hit) {
		super();
		this.deptNum = deptNum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + deptNum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", writeDate=" + writeDate + ", hit=" + hit + "]";
	}
	
	public int getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
