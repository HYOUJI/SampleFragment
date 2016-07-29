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


import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText inputID, inputPW;
    Button loginBtn, signupBtn;

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor = mPrefs.edit();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // View Initialize
        inputID = (EditText) view.findViewById(R.id.inputID);
        inputPW = (EditText) view.findViewById(R.id.inputPW);
        loginBtn = (Button) view.findViewById(R.id.loginBtn);
        signupBtn = (Button) view.findViewById(R.id.signupBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = inputID.getText().toString();
                String pw = inputPW.getText().toString();

                if(TextUtils.isEmpty(id)) {
                    Toast.makeText(getActivity(), "Input ID!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pw)) {
                    Toast.makeText(getActivity(), "Input PW!", Toast.LENGTH_SHORT).show();
                } else {
                    // LOGIN !
                    String memberID = mPrefs.getString(SignUpFragment.LOGIN_ID, "");
                    String memberPW = mPrefs.getString(SignUpFragment.LOGIN_PW, "");

                    if (id.equals(memberID) && pw.equals(memberPW)) {
                        Toast.makeText(getActivity(), "Success!!", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    } else if (TextUtils.isEmpty(memberID) && TextUtils.isEmpty(memberPW)) {
                        Toast.makeText(getActivity(), "NO ID!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "CHECK ID/PW!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).pushSignupFragment();
            }
        });

        return view;
    }


}
