package jp.co.internous.youjustjewelry.dto;
/**
 * LoginDTO ログインディーティーオークラス
 * @author Y.Gouda
 * @since 2015/4/9
 * @version 1.0
 */
public class LoginDTO {
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * firstName	名前
	 * userId		ユーザーID
	 * userPass		ユーザーパスワード
	 */
	private String firstName;
	private String userId;
	private String userPass;
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return userId 必ずユーザーIDを返す
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param userId ユーザーIDを格納した変数
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return userPass 必ずユーザーパスワードを返す
	 */
	public String getUserPass() {
		return userPass;
	}
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param userPass	ユーザーパスワードを格納した変数
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return firstName 必ず名前を返す
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param firstName 名前を格納した変数
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
