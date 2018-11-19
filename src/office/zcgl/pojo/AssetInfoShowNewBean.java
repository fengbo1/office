package office.zcgl.pojo;

import java.util.List;

public class AssetInfoShowNewBean {
	private String name;
	private int namenum;
	private List<TypeAndNum>type;
	private List<ChuAndNum> chu;
	private List<Integer> status;
	private List<Integer> num;
	private List<SearchInfoBean> searchinfo;
	
	
	public List<SearchInfoBean> getSearchinfo() {
		return searchinfo;
	}
	public void setSearchinfo(List<SearchInfoBean> searchinfo) {
		this.searchinfo = searchinfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNamenum() {
		return namenum;
	}
	public void setNamenum(int namenum) {
		this.namenum = namenum;
	}

	public List<TypeAndNum> getType() {
		return type;
	}
	public void setType(List<TypeAndNum> type) {
		this.type = type;
	}

	public List<ChuAndNum> getChu() {
		return chu;
	}
	public void setChu(List<ChuAndNum> chu) {
		this.chu = chu;
	}
	public List<Integer> getStatus() {
		return status;
	}
	public void setStatus(List<Integer> status) {
		this.status = status;
	}
	public List<Integer> getNum() {
		return num;
	}
	public void setNum(List<Integer> num) {
		this.num = num;
	}

	
	
}
