package model.dto;

import java.util.ArrayList;

public class infoDto {
	private int page; //현재 페이지
	private int listsize; //페이지당 게시물을 표시할 개수
	private int startrow;	//현재 페이지에서 시작되는 게시물 번호
	private int totalsize;	//총 게시물수
	private int totalpage;	//총 페이지수
	private int btnsize;	//페이지별 최대 페이징버튼 수
	private int startbtn;	//페이지별 시작 페이징버튼 번호
	private int endbtn;	//페이지별 끝 페이징버튼의 번호
	
	//!! 게시물 목록이 필요함
	private ArrayList<MemberDto> MemberList;	//출력할 데이터[게시물]리스트	

	
	
	

	public infoDto(int page, int listsize, int startrow, int totalsize, int totalpage, int btnsize, int startbtn,
			int endbtn, ArrayList<MemberDto> memberList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnsize = btnsize;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		MemberList = memberList;
	}

	public infoDto() {
		super();
	}

	public int getPage() {
		return page;
	}

	@Override
	public String toString() {
		return "infoDto [page=" + page + ", listsize=" + listsize + ", startrow=" + startrow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", btnsize=" + btnsize + ", startbtn=" + startbtn
				+ ", endbtn=" + endbtn + ", MemberList=" + MemberList + "]";
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getBtnsize() {
		return btnsize;
	}

	public void setBtnsize(int btnsize) {
		this.btnsize = btnsize;
	}

	public int getStartbtn() {
		return startbtn;
	}

	public void setStartbtn(int startbtn) {
		this.startbtn = startbtn;
	}

	public int getEndbtn() {
		return endbtn;
	}

	public void setEndbtn(int endbtn) {
		this.endbtn = endbtn;
	}

	public ArrayList<MemberDto> getMemberList() {
		return MemberList;
	}

	public void setMemberList(ArrayList<MemberDto> memberList) {
		MemberList = memberList;
	}

	



}
