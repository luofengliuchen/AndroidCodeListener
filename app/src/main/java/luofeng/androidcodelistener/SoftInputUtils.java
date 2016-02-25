package luofeng.androidcodelistener;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by 美工 on 2016/2/25.
 */
public class SoftInputUtils {

    /**
     * <h>隐藏系统软键盘工具方法</h>
     * <p>
     *     与第二种方式原理相同，但是不需要传入焦点view，自动获取到焦点所属的token
     * </p>
     * */
    public static void hideInputView(Activity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && ((Activity) context).getCurrentFocus() != null) {
            if (context.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    /**
     * 隐藏系统软件盘
     */
    public static void hideSoftInputMethod(Context context, View v) {
		/* 隐藏软键盘 */
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }
}
