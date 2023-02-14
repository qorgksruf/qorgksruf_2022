package 과제.쪽지보내기.Model;

public class Memo {
	
	private String mcontent;
	private Member sendm;
	private Member recvm;
	
	public Memo() {
	}

	public Memo(String mcontent, Member sendm, Member recvm) {
		this.mcontent = mcontent;
		this.sendm = sendm;
		this.recvm = recvm;
	}

	
	@Override
	public String toString() {
		return "Memo [mcontent=" + mcontent + ", sendm=" + sendm + ", recvm=" + recvm + "]";
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public Member getSendm() {
		return sendm;
	}

	public void setSendm(Member sendm) {
		this.sendm = sendm;
	}

	public Member getRecvm() {
		return recvm;
	}

	public void setRecvm(Member recvm) {
		this.recvm = recvm;
	}
	

	
}
