package com.example.youji.samplefragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    EditText inputID, inputPW, inputPW2;
    Button signupBtn;

    SharedPreferences mPrefs;           // 메모지
    SharedPreferences.Editor mEditor;   // 펜

    public static final String LOGIN_ID = "ID";
    public static final String LOGIN_PW = "PW";

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor = mPrefs.edit();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // View Initialize
        inputID = (EditText) view.findViewById(R.id.inputID);
        inputPW = (EditText) view.findViewById(R.id.inputPW);
        inputPW2 = (EditText) view.findViewById(R.id.inputPW2);
        signupBtn = (Button) view.findViewById(R.id.signupBtn);

        // 회원가입
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = inputID.getText().toString();
                String pw = inputPW.getText().toString();
                String pw2 =inputPW2.getText().toString();

                if( TextUtils.isEmpty(id) ) {
                    Toast.makeText(getActivity(), "Input ID!", Toast.LENGTH_SHORT).show();
                } else if ( TextUtils.isEmpty(pw) ) {
                    Toast.makeText(getActivity(), "Input PW!", Toast.LENGTH_SHORT).show();
                } else if ( !pw2.equals(pw) ) {
                    Toast.makeText(getActivity(), "Check PW2!", Toast.LENGTH_SHORT).show();
                } else {
                    // 회원가입 로직
                    // SharedPreferences Editor
                    mEditor.putString(LOGIN_ID, id);
                    mEditor.putString(LOGIN_PW, pw);
                    mEditor.commit(); // 저장

                    // Fragment가 소속된 Activity를 finish
                    getActivity().finish();

                }
            }
        });

        return view;
    }


}
