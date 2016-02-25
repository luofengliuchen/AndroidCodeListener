package luofeng.androidcodelistener;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * <h1>
 *     android软键盘调用
 * </h1>
 * <p>
 *     android软键盘调用通过对焦点所属的EditText设置IME选项来控制android软键盘回车键的显示状态，
 *     单行的EditText才能将这种状态显示出来，其中有些状态的keycode在android自带键盘AOSP上监听不到，只能监听到
 *     actionID
 *     并且对keycode的监听对键盘正常的字符键值不起作用
 * </p>
 *
 *
 * */

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    EditText et;
    Button btn2;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        ll = (LinearLayout) findViewById(R.id.ll);
        Button btn = (Button) findViewById(R.id.btn);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.removeAllViews();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = new View(MainActivity.this);
                view.setMinimumHeight(10);
                view.setBackgroundColor(Color.RED);
                ll.addView(view);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //改变输入法输入回车键的模式
                switch(index){
                    case 1:
                        et.setImeOptions(EditorInfo.IME_ACTION_SEND);
                        btn2.setText("EditorInfo.IME_ACTION_SEND");
                        break;
                    case 2:
                        et.setImeOptions(EditorInfo.IME_ACTION_DONE);
                        btn2.setText("EditorInfo.IME_ACTION_DONE");
                        break;
                    case 3:
                        et.setImeOptions(EditorInfo.IME_ACTION_GO);
                        btn2.setText("EditorInfo.IME_ACTION_GO");
                        break;
                    case 4:
                        et.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                        btn2.setText("EditorInfo.IME_ACTION_NEXT");
                        break;
                    case 5:
                        et.setImeOptions(EditorInfo.IME_ACTION_NONE);
                        btn2.setText("EditorInfo.IME_ACTION_NONE");
                        break;
                    case 6:
                        et.setImeOptions(EditorInfo.IME_ACTION_PREVIOUS);
                        btn2.setText("EditorInfo.IME_ACTION_PREVIOUS");
                        break;
                    case 7:
                        et.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                        btn2.setText("EditorInfo.IME_ACTION_SEARCH");
                        break;
                    case 8:
                        et.setImeOptions(EditorInfo.IME_ACTION_UNSPECIFIED);
                        btn2.setText("EditorInfo.IME_ACTION_UNSPECIFIED");
                        break;

                }

                index ++;
                if(index>8){
                    index = 1;
                }

            }
        });


        et.setImeOptions(EditorInfo.IME_ACTION_SEND);


        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                showText("this actionID---" + actionId);
                return false;
            }
        });
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                showText("this keyCode---" + keyCode);
                return false;
            }
        });
        et.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                showText("beforeTextChanged---" + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showText("onTextChanged---" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        showText("keyCode---"+keyCode);
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        showText("onKeyDown---" + keyCode);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        showText("dispatchKeyEvent---" + event.getKeyCode());
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        showText("dispatchKeyShortcutEvent---" + event.getKeyCode());
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        showText("onKeyMultiple---" + event.getKeyCode());
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        showText("onKeyShortcut---" + event.getKeyCode());
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        showText("onTouchEvent---" + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        showText("onKeyLongPress---" + event.getKeyCode());
        return super.onKeyLongPress(keyCode, event);
    }


    private void showText(String text){

        TextView tv = new TextView(this);
        tv.setText(text);
        ll.addView(tv);

    }





}
