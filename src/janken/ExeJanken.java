package janken;

import java.util.Scanner;

public class ExeJanken {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("じゃんけんをしますか？");
		Scanner scanner = new Scanner(System.in);
		String userIn = scanner.nextLine();

		if(!userIn.equals("y")) {
			System.out.println("y以外の入力は無効です。再度アプリケーションを実行してください。");
			return;
		}

		System.out.println("最初はグー");
		System.out.println("じゃんけん");

		System.out.println("出す手を選択（「グー（1）」「チョキ（2）」「パー（3）」から番号で選択）");
		String tmpUserInRSPnum = scanner.nextLine();

		if(!(tmpUserInRSPnum.length() == 1)) {
			System.out.println("入力した文字数は無効です。再度アプリケーションを実行してください。");
			return;
		}

		int userRSP;

		if(!Character.isDigit(tmpUserInRSPnum.charAt(0))){
			System.out.println("1〜3以外の入力は無効です。再度アプリケーションを実行してください。");
			return;
		}

		if(Integer.parseInt(String.valueOf(tmpUserInRSPnum.charAt(0))) < 1 || Integer.parseInt(String.valueOf(tmpUserInRSPnum.charAt(0))) > 3) {
			System.out.println("1〜3以外の入力は無効です。再度アプリケーションを実行してください。");
			return;
		}

		userRSP = Integer.parseInt(tmpUserInRSPnum);

		double appRSPnum = Math.floor(Math.random() * 10);
	}

}
