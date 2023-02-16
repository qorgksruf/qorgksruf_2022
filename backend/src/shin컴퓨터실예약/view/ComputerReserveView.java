package shin컴퓨터실예약.view;

import java.util.ArrayList;
import java.util.Scanner;

import shin컴퓨터실예약.model.Computer;
import shin컴퓨터실예약.model.Member;
import shin컴퓨터실예약.controller.ComputerReserveController;

public class ComputerReserveView {

	public static void main(String[] args) {
		ArrayList<Member> memberDb = new ArrayList<>();
		ArrayList<Computer> computerDb = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
	
		ComputerReserveController controller = new ComputerReserveController();
		
		controller.start();
	}

}
