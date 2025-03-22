package janken;

import java.util.Scanner;

public class ExeJanken {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		String userIn;
		String tmpUserInRSPnum = null;
		int userRSP = 0;
		int appRSP = 0;
		boolean rst;
		String msg = null;

		System.out.println(Const.MSG_JANKEN_START);
		userIn = scanner.nextLine();

		if(!userIn.equals("y")) {
			System.out.println(Const.MSG_ERR_NOT_Y);
			System.exit(1);
		}

		System.out.println(Const.MSG_BATTLE_CALL1);
		System.out.println(Const.MSG_BATTLE_CALL2);
		System.out.println(Const.MSG_SELECT_RSP);

		// ユーザとアプリケーションが出す手を設定する
		userRSP = SetUserRSP(scanner, tmpUserInRSPnum);
		appRSP = SetAppRSP(appRSP);

		// じゃんけんの勝敗を判定する
		rst = LgcJanken(userRSP, appRSP, scanner, tmpUserInRSPnum);

		// 出力するメッセージを設定する
		if(rst) {
			msg = Const.MSG_WIN;
		} else {
			msg = Const.MSG_LOSE;
		}

		System.out.println(msg);

	}

	// ユーザの入力値からユーザのじゃんけんの手を設定する
	private static int SetUserRSP(Scanner scanner, String tmpUserInRSPnum) {
		tmpUserInRSPnum = scanner.nextLine();

		ChkUserInput(tmpUserInRSPnum);

		return Integer.parseInt(tmpUserInRSPnum);
	}

	// ユーザの入力値が不正でないかを判定する
	private static void ChkUserInput(String tmpUserInRSPnum) {
		if(!(tmpUserInRSPnum.length() == 1)) {
			System.out.println(Const.MSG_ERR_ILLEGAL_INPUT);
			System.exit(1);
		}

		if(!Character.isDigit(tmpUserInRSPnum.charAt(0))){
			System.out.println(Const.MSG_ERR_NOT_FROM_1_TO_3);
			System.exit(1);
		}

		if(Integer.parseInt(String.valueOf(tmpUserInRSPnum.charAt(0))) < 1
				|| Integer.parseInt(String.valueOf(tmpUserInRSPnum.charAt(0))) > 3) {
			System.out.println(Const.MSG_ERR_NOT_FROM_1_TO_3);
			System.exit(1);
		}

	}

	// アプリケーションのじゃんけんの手を設定する
	private static int SetAppRSP(int appRSP) {
		double appRSPnum = 0;

		while(appRSPnum == 0) {
			appRSPnum = Math.floor(Math.random() * 10);
		}

		appRSP = 0;
		if(appRSPnum >= 1 && appRSPnum <= 3) {
			appRSP = 1;
		} else if(appRSPnum >= 4 && appRSPnum <= 6) {
			appRSP = 2;
		} else if(appRSPnum >= 7 && appRSPnum <= 9) {
			appRSP = 3;
		}

		return appRSP;

	}

	// じゃんけんの勝敗を判定する
	private static boolean LgcJanken(int userRSP, int appRSP, Scanner scanner, String tmpUserInRSPnum) {
		boolean aikFlg = false;
		int battleCnt = 0;
		boolean rst = false;

		while((!aikFlg && battleCnt == 0) || (aikFlg && battleCnt > 0)) {
			// あいこの判定
			if(userRSP == appRSP) {
				aikFlg = true;
				System.out.println(Const.MSG_RST_AIK);

				System.out.println(Const.MSG_AIK_CALL1);
				System.out.println(Const.MSG_SELECT_RSP);

				userRSP = SetUserRSP(scanner, tmpUserInRSPnum);
				appRSP = SetAppRSP(appRSP);

				continue;
			}

			if((userRSP == 1 && appRSP == 2)
					|| (userRSP == 2 && appRSP == 3)
					|| (userRSP == 3 && appRSP == 1)) {
				// 勝ちの場合
				aikFlg = false;
				rst = true;
			} else {
				// 負けの場合
				aikFlg = false;
			}

			battleCnt++;

		}

		return rst;
	}

}
