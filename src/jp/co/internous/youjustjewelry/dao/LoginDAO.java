package jp.co.internous.youjustjewelry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.internous.youjustjewelry.dto.LoginDTO;
import jp.co.internous.youjustjewelry.util.DBconnector;

/**
 * LoginActionがDBに接続するためのDAOクラス
 * @author Y.Gouda
 * @since 2015/4/9
 * @version 1.0
 */
public class LoginDAO{
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * con			コネクション
	 * firstName	名前
	 * userId		ユーザーID
	 * res			レスポンス
	 */
	Connection con;
	String firstName;
	String userId;
	boolean res;
/**
 * 入力された情報とDBcustomer_infoにある情報を照合するメソッド
 * @author Y.Gouda
 * @since 2015/4/9
 * @param emailId  EメールorID
 * @param pass     パスワード
 * @return res     例外処理に入らなければレスポンスを返す
 * @throws Exception
 * @see DBconnector LoginDTO
 */
	public boolean select(String emailId,String pass)throws Exception{
		res = false;
		con = DBconnector.getConnection();

		try{
			String sql = "SELECT * FROM customer_info WHERE ( user_id=? OR user_mail=? ) AND user_pass=?";
			PreparedStatement ps2;
			ps2 = con.prepareStatement(sql);
			ps2.setString(1,emailId);
			ps2.setString(2,emailId);
			ps2.setString(3,pass);

			ResultSet rs = ps2.executeQuery();

			while(rs.next()){
				res = true;

				LoginDTO dto = new LoginDTO();

				dto.setFirstName(rs.getString(5));
				dto.setUserId(rs.getString(2));
				firstName=dto.getFirstName();
				userId = dto.getUserId();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return res;
	}
	/**
	 * ユーザーID取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return userId ユーザーIDを返す
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 名前取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return firstName 名前を返す
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 名前登録メソッド
	 * @author Y.Gouda
	 * @param firstName
	 * @since 2015/4/9
	 * @param firstName 名前
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}