package janken;

import java.util.Scanner;

public class ExeJanken {
	private static String MSG_JANKEN_START = "じゃんけんをしますか？（\"y\"を入力でスタート）";
	private static String MSG_ERR_NOT_Y = "y以外の入力は無効です。再度アプリケーションを実行してください。";
	private static String MSG_BATTLE_CALL1 = "最初はグー";
	private static String MSG_BATTLE_CALL2 = "じゃんけん";
	private static String MSG_SELECT_RSP = "出す手を選択（「グー（1）」「チョキ（2）」「パー（3）」から番号で選択）";
	private static String MSG_ERR_ILLEGAL_INPUT = "入力した文字数は無効です。再度アプリケーションを実行してください。";
	private static String MSG_ERR_NOT_FROM_1_TO_3 = "1〜3以外の入力は無効です。再度アプリケーションを実行してください。";
	private static String MSG_RST_AIK = "あいこ！もう一回！";
	private static String MSG_AIK_CALL1 = "あいこで。。。";
	private static String MSG_WIN = "あなたの勝ち！";
	private static String MSG_LOSE = "あなたの負け。。。";

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		String userIn;
		String tmpUserInRSPnum = null;
		int userRSP = 0;
		int appRSP = 0;
		boolean aikFlg = false;
		int battleCnt = 0;

		System.out.println(MSG_JANKEN_START);
		userIn = scanner.nextLine();

		if(!userIn.equals("y")) {
			System.out.println(MSG_ERR_NOT_Y);
			return;
		}

		System.out.println(MSG_BATTLE_CALL1);
		System.out.println(MSG_BATTLE_CALL2);
		System.out.println(MSG_SELECT_RSP);

		userRSP = setUserRSP(scanner, tmpUserInRSPnum);
		appRSP = setAppRSP(appRSP);

		// 勝敗を判定する処理
		while((!aikFlg && battleCnt == 0) || (aikFlg && battleCnt > 0)) {
			// あいこの判定
			if(userRSP == appRSP) {
				aikFlg = true;
				System.out.println(MSG_RST_AIK);

				System.out.println(MSG_AIK_CALL1);
				System.out.println(MSG_SELECT_RSP);

				userRSP = setUserRSP(scanner, tmpUserInRSPnum);
				appRSP = setAppRSP(appRSP);

				continue;
			}

			if((userRSP == 1 && appRSP == 2) || (userRSP == 2 && appRSP == 3) || (userRSP == 3 && appRSP == 1)) {
				// 勝ちの場合
				aikFlg = false;
				System.out.println(MSG_WIN);
			} else {
				// 負けの場合
				aikFlg = false;
				System.out.println(MSG_LOSE);
			}

			battleCnt++;

		}
	}

	// ユーザの入力値からユーザのじゃんけんの手を設定する
	private static int setUserRSP(Scanner scanner, String tmpUserInRSPnum) {
		tmpUserInRSPnum = scanner.nextLine();

		chkUserInput(tmpUserInRSPnum);

		return Integer.parseInt(tmpUserInRSPnum);
	}

	// ユーザの入力値が不正でないかを判定する
	private static void chkUserInput(String tmpUserInRSPnum) {
		if(!(tmpUserInRSPnum.length() == 1)) {
			System.out.println(MSG_ERR_ILLEGAL_INPUT);
			return;
		}

		if(!Character.isDigit(tmpUserInRSPnum.charAt(0))){
			System.out.println(MSG_ERR_NOT_FROM_1_TO_3);
			return;
		}

		if(Integer.parseInt(String.valueOf(tmpUserInRSPnum.charAt(0))) < 1 || Integer.parseInt(String.valueOf(tmpUserInRSPnum.charAt(0))) > 3) {
			System.out.println(MSG_ERR_NOT_FROM_1_TO_3);
			return;
		}

	}

	// アプリケーションのじゃんけんの手を設定する
	private static int setAppRSP(int appRSP) {
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

}
