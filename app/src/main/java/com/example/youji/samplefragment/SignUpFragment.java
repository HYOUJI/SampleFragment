package com.example.youji.samplefragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
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



    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                if( TextUtils.isEmpty(inputID.getText().toString()) ) {
                    Toast.makeText(getActivity(), "Input ID!", Toast.LENGTH_SHORT).show();
                } else if ( TextUtils.isEmpty(inputPW.getText().toString()) ) {
                    Toast.makeText(getActivity(), "Input PW!", Toast.LENGTH_SHORT).show();
                } else if ( TextUtils.isEmpty(inputPW2.getText().toString()) ) {
                    Toast.makeText(getActivity(), "Input PW2!", Toast.LENGTH_SHORT).show();
                } else {
                    // SIGN UP!


                    // Fragment가 소속된 Activity를 finish
                    getActivity().finish();

                }
            }
        });

        return view;
    }


}
