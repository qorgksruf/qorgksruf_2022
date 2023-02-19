package MVC연습.Bank;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	String account;
	String pw;
	String name;
	String bankname;
	String money;
	
	Scanner scanner = new Scanner(System.in);
	ArrayList<Bank>bankDB = new ArrayList<>();
	
	
	
	
	public Bank() {
	}


	public Bank(String account, String pw, String name) {
		this.account = account;
		this.pw = pw;
		this.name = name;
	}

	public Bank(String account, String pw, String name, String bankname) {
		this.account = account;
		this.pw = pw;
		this.name = name;
		this.bankname = bankname;
	}
	
	
	public void add_account() {
		System.out.println("----------------------계좌생성--------------");
		System.out.println("1. 신한은행 2.국민은행 3.우리은행");
		int ch= scanner.nextInt();
		
		if(ch==1) {
			information(ch);
		}else if(ch==2) {
			information(ch);
			
		}else if(ch==3) {
			information(ch);
		}
	}//함수끝
	
	public void information(int ch) {
		System.out.println( "---------------계좌정보입력----------");
		System.out.println("계좌주입력;;;");
		String name= scanner.next();
		System.out.println("계좌비번입력;;;;");
		String pw=scanner.next();
		
		String account=Bank_check(ch);
		
		Bank bank = new Bank(name, pw, account);
		bankDB.add(bank);
		
		add_complet(ch);
		
	}
	
	//계좌번호생성
	public String Bank_check(int ch) {
		Random random = new Random();
		int nansoo1=random.nextInt(99);
		int nansoo2=random.nextInt(99);
		
		if(ch==1) {
			 return "03-"+nansoo1+"-"+nansoo2;
		}else if(ch==2) {
			return "04-"+nansoo1+"-"+nansoo2;
		}else if(ch==3) {
			return "05-"+nansoo1+"-"+nansoo2;
		}else {
			System.out.println("번호다시입력하세요");
		}
		
		return null;
	}
	
	//
	public void add_complet(  int ch) {
		String bank_name="";
		if(ch==1) {
			bank_name="신한";
		}else if(ch==2) {
			bank_name="국민";
		}else if(ch==3) {
			bank_name="우리";
		}
		
		bankDB.get(ch).bankname=bank_name;
		
		for(ch=0; ch<bankDB.size(); ch++) {
			if(bankDB.get(ch).account.equals(account)) {
				System.out.println("계좌생성완료");
				System.out.println("게좌주"+bankDB.get(ch).name);
				System.out.println("계좌번호"+bankDB.get(ch).account);
				System.out.println("은행"+bank_name);
				if(bankname.equals("신한")) {
					System.out.println("신한은행에 오신걸 환영합니다ㅣ");
				}else if(bankname.equals("국민")) {
					System.out.println("국민온걸환여");
				}else if(bankname.equals("우리")){
					System.out.println("우리온걸 축하");
				}
			}
		}
		
		
	}
	
	
	
}//class e
