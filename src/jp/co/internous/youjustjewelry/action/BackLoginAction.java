package jp.co.internous.youjustjewelry.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * BackLoginAction ログイン画面へ戻る為のアクション
 * @author T.Okamoto
 * @since 2015/4/10
 * @version 1.0
 */
public class BackLoginAction extends ActionSupport {
	/**
	 * 実行メソッド
	 * @author T.Okamoto
	 * @since 2015/4/10
	 * @return SUCCESS 必ずSUCCESSを返す
	 */
	public String execute(){
		return SUCCESS;
	}

}
