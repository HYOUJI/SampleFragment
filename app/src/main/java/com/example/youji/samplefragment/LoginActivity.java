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

        // ���� ���� �ÿ��� �⺻ȭ������ �̰� �ΰڴ�.
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
        // null�� "ȸ������ �����׸�Ʈ�� ��ü" ���� String ���� �� �ִ�.
    }

    public void popFragment() {
        getFragmentManager().popBackStack();
    }

}