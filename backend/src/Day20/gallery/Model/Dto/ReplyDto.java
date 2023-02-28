package Day20.gallery.Model.Dto;

public class ReplyDto {
	
		private int rno;
		private String   rcontent ;
		private String    rdate	;
		private int    tindex;	
		private String  mid;  	
		private int   bno;
		
		public ReplyDto() {

		}

		public ReplyDto(int rno, String rcontent, String rdate, int tindex, String mid, int bno) {
			this.rno = rno;
			this.rcontent = rcontent;
			this.rdate = rdate;
			this.tindex = tindex;
			this.mid = mid;
			this.bno = bno;
		}

		@Override
		public String toString() {
			return "ReplyDto [rno=" + rno + ", rcontent=" + rcontent + ", rdate=" + rdate + ", tindex=" + tindex
					+ ", mid=" + mid + ", bno=" + bno + "]";
		}

		public int getRno() {
			return rno;
		}

		public void setRno(int rno) {
			this.rno = rno;
		}

		public String getRcontent() {
			return rcontent;
		}

		public void setRcontent(String rcontent) {
			this.rcontent = rcontent;
		}

		public String getRdate() {
			return rdate;
		}

		public void setRdate(String rdate) {
			this.rdate = rdate;
		}

		public int getTindex() {
			return tindex;
		}

		public void setTindex(int tindex) {
			this.tindex = tindex;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		
}
