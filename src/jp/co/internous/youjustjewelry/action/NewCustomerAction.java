package jp.co.internous.youjustjewelry.action;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.internous.youjustjewelry.dao.NewCustomerDAO;
import jp.co.internous.youjustjewelry.dao.TicketInfoDAO;
import jp.co.internous.youjustjewelry.dto.TicketInfoDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 新規登録する為のアクションクラス
 * @author Y.Narita
 * @since 2015/04/11
 * @version 1.0
 */
public class NewCustomerAction extends ActionSupport implements SessionAware{
	/**
	 * @author Y.Narita
	 * @since 2015/04/11
	 * notice          エラー通知
	 * userId          ユーザーID
	 * userPass        ユーザーパス
	 * userPassRekey   ユーザーパス再確認
	 * lastName        苗字
	 * firstName       名前
	 * userMail        ユーザーメール
	 * gender          性別
	 * birthday        生年月日
	 * userIp          ユーザーIP
	 * registerDate    登録日時
	 * updateDate      ユーザー情報の更新日時
	 * deleteDate      ユーザー情報の削除日時
	 * date            ユーザー情報
	 * zipcode         郵便番号
	 * prefecture      都道府県
	 * citytown        市区町村
	 * houseNumber     番地
	 * result          実行結果を返す
	 * session         セッション
	 * ticketInfo      セッションに登録されている商品情報
	 * numberList      選択できる商品枚数
	 */
	private String notice;
	private String userId;
	private String userPass;
	private String userPassRekey;
	private String lastName;
	private String firstName;
	private String userMail;
	private int gender;
	private String birthday;
	private String userIp;
	private String registerDate;
	private String updateDate;
	private String deleteDate;
	private String date;
	private String zipcode;
	private String prefecture;
	private String citytown;
	private String houseNumber;
	public String result;
	private Map<String,Object>session;
	public List<TicketInfoDTO> ticketInfo = new ArrayList<TicketInfoDTO>();
	public List<Integer> numberList = new ArrayList<Integer>();
	/**
	 * ユーザーIP取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return ipAddress ユーザーのIPアドレスを返す
	 */
	public String getUserIP() {
		InetAddress addr;
		String ipAddress = null;
		try {
			addr = InetAddress.getLocalHost();
			ipAddress = addr.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ipAddress;
	}
	/**
	 *  顧客情報をDBに格納するメソッド
	 *  @author Y.Narita
	 *  @since 2015/04/11
	 *  @return result IDとPassが正しければSUCCESSを返す
	 *  @throws Exception
	 *  @see NewCustomerDAO
	 *  @see TicketInfoDAO
	 */
	public String execute() throws Exception {
		NewCustomerDAO newCustomerDao = new NewCustomerDAO();
		setUserIp(getUserIP());
		boolean checkID = newCustomerDao.isCheckID(getUserId());
		boolean checkPass = newCustomerDao.isCheckPassword(userPass, userPassRekey);

		if(checkID){
			if(checkPass){
				newCustomerDao.insertCustomerAddress(
						getUserId(),getZipcode(),getPrefecture(),getCitytown(),getHouseNumber());
				newCustomerDao.insertCustomerInfo(
						getUserId(),getUserPass(),getLastName(),getFirstName(),getUserMail(),getGender(),
						getBirthday(),getUserIP(),getRegisterDate(),getRegisterDate(),getDeleteDate());

				setNotice(null);
				result = SUCCESS;
			}else{
				result = ERROR;
				setNotice("パスワードが正しくありません。再度入力してください");
			}
		}else {
			result = ERROR;
			setNotice("すでにIDが登録されています。再度入力してください");
		}

		session.put("user_name", firstName);
		TicketInfoDAO ticketInfoDao = new TicketInfoDAO();
		ticketInfo = ticketInfoDao.select();
		session.put("ticket_info", ticketInfo);
		for(Integer i = 1; i < 21; i++){
			numberList.add(i);
		}
		session.put("numberList", numberList);
		session.put("user_id", userId);
		session.put("user_ip", userIp);
		return result;
	}
	/**
	 * エラー通知取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return notice
	 */
	public String getNotice() {
		return notice;
	}
	/**
	 * エラー通知登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param notice エラー通知
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	/**
	 * ユーザーID取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return userId 取得したユーザーIDを返す
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * ユーザーID登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param userId ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * ユーザーパス取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return userPass 取得したユーザーパスを返す
	 */
	public String getUserPass() {
		return userPass;
	}
	/**
	 * ユーザーパス登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param userPass ユーザーパス
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	/**
	 * ユーザーパス再確認取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return userPassRekey 取得した確認用ユーザーパスを返す
	 */
	public String getUserPassRekey() {
		return userPassRekey;
	}
	/**
	 * ユーザーパス再確認登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param userPassRekey ユーザーパス再確認
	 */
	public void setUserPassRekey(String userPassRekey) {
		this.userPassRekey = userPassRekey;
	}
	/**
	 * 苗字取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return lastName 取得した苗字を返す
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 苗字登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param lastName 苗字
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 名前取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return firstName 取得した名前を返す
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 名前登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param firstName 名前
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * ユーザーメール取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return userMail 取得したユーザーメールを返す
	 */
	public String getUserMail() {
		return userMail;
	}
	/**
	 * ユーザーメール登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param userMail ユーザーメール
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	/**
	 * 性別取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return gender 取得した性別を返す
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * 性別登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param gender 性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * 生年月日取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return birthday 取得した生年月日を返す
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 生年月日登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param birthday 生年月日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * ユーザーIP取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return userIp 取得したユーザーIPを返す
	 */
	public String getUserIp() {
		return userIp;
	}
	/**
	 * ユーザーIP登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param userIp ユーザーIP
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	/**
	 * 登録日時取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return registerDate 取得した登録日時を返す
	 */
	public String getRegisterDate() {
		return registerDate;
	}
	/**
	 * 登録日時登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param registerDate 登録日時
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * ユーザー情報の更新日時取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return updateDate 取得したユーザー情報の更新日時を返す
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * ユーザー情報の更新日時登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param updateDate ユーザー情報の更新
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * ユーザー情報の削除日時取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return deleteDate 取得したユーザー情報の削除日時を返す
	 */
	public String getDeleteDate() {
		return deleteDate;
	}
	/**
	 * ユーザー情報の削除日時登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param deleteDate ユーザー情報の削除
	 */
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	/**
	 * ユーザー情報取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return date 取得したユーザー情報を返す
	 */
	public String getDate() {
		return date;
	}
	/**
	 * ユーザー情報の登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param date ユーザー情報
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 郵便番号取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return zipcode 取得した郵便番号を返す
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 郵便番号登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param zipcode 郵便番号
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 都道府県取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return prefecture 取得した都道府県を返す
	 */
	public String getPrefecture() {
		return prefecture;
	}
	/**
	 * 都道府県登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param prefecture 都道府県
	 */
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	/**
	 * 市区町村取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return citytown 取得した市区町村を返す
	 */
	public String getCitytown() {
		return citytown;
	}
	/**
	 * 市区町村登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param citytown 市区町村
	 */
	public void setCitytown(String citytown) {
		this.citytown = citytown;
	}
	/**
	 * 番地取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return houseNumber 取得した番地を返す
	 */
	public String getHouseNumber() {
		return houseNumber;
	}
	/**
	 * 番地登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param houseNumber 番地
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * セッション取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return session 取得したセッションを返す
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * セッション登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * セッションに登録されている商品情報取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return ticketInfo 取得したセッションに登録されている商品情報を返す
	 */
	public List<TicketInfoDTO> getTicketInfo() {
		return ticketInfo;
	}
	/**
	 * セッションに登録されている商品情報登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param ticketInfo セッションに登録されている商品情報
	 */
	public void setTicketInfo(List<TicketInfoDTO> ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	/**
	 * 選択できる商品枚数取得メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @return numberList 取得した選択できる商品枚数を返す
	 */
	public List<Integer> getNumberList() {
		return numberList;
	}
	/**
	 * 選択できる商品枚数登録メソッド
	 * @author Y.Narita
	 * @since 2015/04/11
	 * @param numberList 選択できる商品枚数
	 */
	public void setNumberList(List<Integer> numberList) {
		this.numberList = numberList;
	}
}
