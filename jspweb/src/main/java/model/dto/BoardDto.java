package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bdate;
	private int bview;
	private int bup;
	private int bdown;
	private int mno;
	private int cno;
	
	//빈생성자
	public BoardDto() {
		super();
	}
	
	//추가출력용생성자
	private String mid;	//작성자 아이디
	private String mimg;//작성자 프로필 이미지
	private int rcount;	//댓글개수

	
	
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
	}
	//업데이트용 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		
		//오늘날짜표기 
		Date date = new Date();
			System.out.println(date);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		
		//만약에 오늘 날짜와 작성일과 동일하면 [split("")[1]: 시간 ]
		if( now.split("")[0].equals(bdate.split(" ")[0] ) ) {
			this.bdate=bdate.split("")[1];
		}else {
			this.bdate=bdate.split("")[0];
		}
	}

	public BoardDto(String btitle, String bcontent, String bfile, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}

	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public String getBfile() {
		return bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public int getBview() {
		return bview;
	}

	public int getBup() {
		return bup;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", bup=" + bup + ", bdown=" + bdown + ", mno=" + mno
				+ ", cno=" + cno + ", mid=" + mid + "]";
	}

	public int getBdown() {
		return bdown;
	}

	public int getMno() {
		return mno;
	}

	public int getCno() {
		return cno;
	}

	public String getMid() {
		return mid;
	}
	
	//풀생성자는 기본으로 생성

	//내가 쓸 등록욕생성자

	//출력용생성자 하나 만듬

	//

	
	
}
