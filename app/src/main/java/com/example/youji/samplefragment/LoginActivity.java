package com.example.youji.samplefragment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 최초 구동 시에만 기본화면으로 이걸 두겠다.
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }

    }

    public void pushSignupFragment(){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new SignUpFragment())
                .addToBackStack(null)
                .commit();
        // null에 "회원가입 프래그먼트로 교체" 같은 String 넣을 수 있다.
    }

    public void popFragment() {
        getFragmentManager().popBackStack();
    }

}
