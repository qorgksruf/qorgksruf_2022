package Day19.EX6;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

	
		Music music = new Music();	//음악스레드
		Movie movie = new Movie();	//영화스레드

		
		while(true) {
			System.out.println("1.음악재생 2.영화재생;;;");
			int ch = scanner.nextInt();
			if(ch==1 && musicState ==false) {
				// 만약에 1버늘 입력하면서 음악재생 꺼져있으면 재생
				music.start();		//음악스레드 시작
				music.stop=true;	//음악재생 여부 true
			
			//만약에 1번 입력하면서 음악재생 켜져있으면 중지
			}else if(ch==1 && music.stop == true) {
					// 음악재생 여부 false
					music.stop = false;		//음악재생 여부 false
					music = new Music();	// 음악스레드 초기화	
			
			//만약에 2번 입력하면서 영화재생 꺼져 있으면 재생		
			}else if(ch==2 && movie.stop == false) {
				movie.start();
				movie.stop = true;
				
			//만약에 2번 입력하면서 영화재생 켜져있으면 중지		
			}else if ( ch==2 && movie.stop == true) {
				movie.stop = false;
				movie = new Movie();
			}
		}
	}
}
