package model.dto;

import java.util.ArrayList;

public class pageDto {
	private int page; //현재 페이지
	private int listsize; //페이지당 게시물을 표시할 개수
	private int startrow;	//현재 페이지에서 시작되는 게시물 번호
	private int totalsize;	//총 게시물수
	private int totalpage;	//총 페이지수
	
	//!! 게시물 목록이 필요함
	ArrayList<BoardDto>boardList;	//출력할 데이터[게시물]리스트	

	public pageDto(int page, int listsize, int startrow, int totalsize, int totalpage, ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.boardList = boardList;
	}

	public pageDto() {
		super();
	}

	public int getPage() {
		return page;
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

	public ArrayList<BoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDto> boardList) {
		this.boardList = boardList;
	}
	
}
