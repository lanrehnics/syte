package com.grandreynetwork.sytte.Fragments.Registration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.grandreynetwork.sytte.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentVerifier extends Fragment {

    private static final String SIGN_UP_MODE = "SIGN_UP_MODE";
    private static final String ARG_PARAM2 = "param2";

    private boolean signupmode = false;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.lin_phone)
    LinearLayout lin_phone;

    @BindView(R.id.lin_email)
    LinearLayout lin_email;

    @BindView(R.id.txt_phone)
    TextView txt_phone;

    @BindView(R.id.txt_email)
    TextView txt_email;

    @BindView(R.id.dot_phone)
    View dot_phone;

    @BindView(R.id.dot_email)
    View dot_email;

    @BindView(R.id.et_field)
    EditText et_field;

    @BindView(R.id.btn_send)
    Button btn_send;

    @BindView(R.id.btn_signin)
    Button btn_signin;

    @BindColor(R.color.grey_600)
    int grey_600;
    @BindColor(R.color.grey_400)
    int grey_400;

    @BindView(R.id.txt_header)
    TextView txt_header;

    @BindView(R.id.txt_headercontent)
    TextView txt_headercontent;


    public FragmentVerifier() {
        // Required empty public constructor
    }


    public static FragmentVerifier newInstance(boolean signupmode) {
        FragmentVerifier fragment = new FragmentVerifier();
        Bundle args = new Bundle();
        args.putBoolean(SIGN_UP_MODE, signupmode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            signupmode = getArguments().getBoolean(SIGN_UP_MODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verifier, container, false);
        ButterKnife.bind(this, view);
        defaultSetup();
        if (signupmode)
            txt_header.setText("sign up");
        txt_headercontent.setText("enter your phone no. or email to create\nyour sytte accout");
        btn_send.setText("proceed");

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        void openEnterPass();

        void openVerification();
    }

    @OnClick({R.id.lin_phone,
            R.id.lin_email,
            R.id.btn_send,
            R.id.btn_signin})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.lin_phone:
                defaultSetup();
                break;
            case R.id.lin_email:
                txt_email.setTextColor(grey_600);
                txt_phone.setTextColor(grey_400);
                dot_phone.setVisibility(View.INVISIBLE);
                dot_email.setVisibility(View.VISIBLE);
                et_field.setHint("email");
                et_field.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

                break;

            case R.id.btn_send:
                if (signupmode) {
                    mListener.openVerification();
                } else {
                    mListener.openEnterPass();
                }

                break;
            case R.id.btn_signin:
                break;
        }
    }

    private void defaultSetup() {
        txt_phone.setTextColor(grey_600);
        txt_email.setTextColor(grey_400);
        dot_phone.setVisibility(View.VISIBLE);
        dot_email.setVisibility(View.INVISIBLE);
        et_field.setHint("phone no");
        et_field.setInputType(InputType.TYPE_CLASS_PHONE);
    }
}
