package jp.co.internous.youjustjewelry.util;
import java.util.Comparator;

import jp.co.internous.youjustjewelry.dto.GoodsCartDTO;
/**
 * CartComparator ID順に商品を並べ替えるメソッド
 * @author Y.Matsukawa
 * @since 2015/4/15
 * @version 1.0
 * @see GoodsCartDTO
 */
public class CartComparator implements Comparator<GoodsCartDTO>{
/**
 * ID順に商品を並べ替えるメソッド
 * @author Y.Matsukawa
 * @since 2015/4/15
 * @param a GoodsCartDTOを格納した変数
 * @param b GoodsCartDTOを格納した変数
 * @see GoodsCartDTO
 * @return 1,0,-1 条件によって1,0,-1の値を返す

 */
	public int compare(GoodsCartDTO a, GoodsCartDTO b) {
	    int no1 = a.getTicketId();
	    int no2 = b.getTicketId();
	    if (no1 > no2) {
	        return 1;
	    } else if (no1 == no2) {
	        return 0;
	    } else {
	        return -1;
	    }
	}
}