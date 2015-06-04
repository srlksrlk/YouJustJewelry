package jp.co.internous.youjustjewelry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.internous.youjustjewelry.util.DBconnector;

/**
 * NewCustomerActionから取得したデータをDBのcustomer_info,customer_addressに追加するDAOクラス
 * @author Y.Narita
 * @since 2015/04/11
 * @version 1.0
 */
public class NewCustomerDAO {

    /**
     * ユーザーが入力したIDとDBのcustomer_infoに存在するユーザーIDを比較するメソッド
     * @author Y.Narita
     * @since 2015/04/18
     * @param userId    ユーザーID
     * @return res 例外処理に入らなければレスポンスを返す
     * @throws SQLException
     */
    public boolean isCheckID(String userId) throws SQLException{
        boolean res = true ;

        Connection conn = null;
        conn = DBconnector.getConnection();
        try{
            String sql = "select * from customer_info where user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                res = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
        return res;
    }

    /**
     * ユーザーが入力したパスワードとDBのcustomer_infoに存在するパスワードを比較するメソッド
     * @author Y.Narita
     * @since 2015/04/18
     * @param userPass          ユーザーパス
     * @param userPassRekey     ユーザーパス再確認
     * @return result 必ず実行結果を返す
     */
    public boolean isCheckPassword(String userPass,String userPassRekey){
        boolean result = false;
        if(userPass.equals(userPassRekey)){
            result = true;
        }
        return result;
    }


    /**
     * DBのcustomer_addressに顧客住所情報を格納するメソッド
     * @author Y.Narita
     * @since 2015/04/15
     * @param userId           ユーザーID
     * @param zipcode          郵便番号
     * @param prefecture       都道府県
     * @param citytown         市区町村
     * @param houseNomber      番地
     * @throws SQLException
     */
    public void insertCustomerAddress(String userId,String zipcode,String prefecture,
            String citytown,String houseNomber) throws SQLException{

        Connection conn = null;
        conn = DBconnector.getConnection();
        try{
            String sql = "INSERT INTO customer_address (user_id,zipcode,prefecture,citytown,house_number) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setString(2,zipcode);
            pstmt.setString(3,prefecture);
            pstmt.setString(4,citytown);
            pstmt.setString(5,houseNomber);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }
    /**
     * Customer_infoテーブルに顧客情報を追加するメソッド
     * @author Y.Narita
     * @since 2015/04/18
     * @param userId            ユーザーID
     * @param userPass          ユーザーパス
     * @param lastName          苗字
     * @param firstName         名前
     * @param userMail          ユーザーメール
     * @param gender            性別
     * @param birthday          生年月日
     * @param userIp            ユーザーIP
     * @param registerDate      登録日時
     * @param updateDate        ユーザー情報の更新
     * @param deleteDate        ユーザー情報の削除
     * @throws SQLException
     */
    public void insertCustomerInfo(String userId,String userPass,String lastName,
            String firstName,String userMail,int gender,String birthday,String userIp,
            String registerDate,String updateDate,String deleteDate) throws SQLException{

        Connection conn = null;
        conn = DBconnector.getConnection();
        try{
            String sql = "INSERT INTO customer_info (user_id,user_pass,last_name,first_name,user_mail,"
                    + "gender,birthday,user_ip,register_date,update_date,delete_date) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setString(2,userPass);
            pstmt.setString(3,lastName);
            pstmt.setString(4,firstName);
            pstmt.setString(5,userMail);
            pstmt.setInt(6,gender);
            pstmt.setString(7,birthday);
            pstmt.setString(8,userIp);
            pstmt.setString(9,registerDate);
            pstmt.setString(10,updateDate);
            pstmt.setString(11,deleteDate);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }
}
