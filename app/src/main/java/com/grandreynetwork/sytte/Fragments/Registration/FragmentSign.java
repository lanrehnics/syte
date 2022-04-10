package com.grandreynetwork.sytte.Fragments.Registration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.grandreynetwork.sytte.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentSign extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Unbinder unbinder;

    @BindView(R.id.lin_signin)
    LinearLayout lin_signin;
    @BindView(R.id.lin_signup)
    LinearLayout lin_signup;
    @BindView(R.id.dot_signin)
    View dot_signin;
    @BindView(R.id.dot_signup)
    View dot_signup;
    @BindView(R.id.signin_container)
    LinearLayout signin_container;
    @BindView(R.id.signup_container)
    LinearLayout signup_container;
    @BindView(R.id.txt_signin)
    TextView txt_signin;
    @BindView(R.id.txt_signup)
    TextView txt_signup;
    @BindView(R.id.txt_forgetpass)
    TextView txt_forgetpass;

    @BindView(R.id.txt_or)
    TextView txt_or;

    @BindView(R.id.btn_signup)
    Button btn_signup;

    @BindColor(R.color.grey_400)
    int grey_400;

    @BindColor(R.color.grey_600)
    int grey_600;

    private OnFragmentInteractionListener mListener;

    public FragmentSign() {
        // Required empty public constructor
    }

    public static FragmentSign newInstance(String param1, String param2) {
        FragmentSign fragment = new FragmentSign();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign, container, false);
        unbinder = ButterKnife.bind(this, view);
        dot_signup.setVisibility(View.INVISIBLE);
        txt_signup.setTextColor(grey_400);
        return view;
    }

    @OnClick({R.id.lin_signin, R.id.lin_signup, R.id.txt_forgetpass,R.id.btn_signup})
    public void switchView(View focus) {
        switch (focus.getId()) {
            case R.id.lin_signin:
                dot_signup.setVisibility(View.INVISIBLE);
                dot_signin.setVisibility(View.VISIBLE);
                txt_signin.setTextColor(grey_600);
                txt_signup.setTextColor(grey_400);
                signin_container.setVisibility(View.VISIBLE);
                signup_container.setVisibility(View.GONE);
                txt_or.setText("or sign in with");

                break;
            case R.id.lin_signup:
                dot_signup.setVisibility(View.VISIBLE);
                dot_signin.setVisibility(View.INVISIBLE);
                txt_signup.setTextColor(grey_600);
                txt_signin.setTextColor(grey_400);
                signin_container.setVisibility(View.GONE);
                signup_container.setVisibility(View.VISIBLE);
                txt_or.setText("or");
                break;

            case R.id.txt_forgetpass:
                mListener.forgetPass();
                break;

            case R.id.btn_signup:
                mListener.signup();
                break;
        }
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
        void onFragmentInteraction(Uri uri);

        void forgetPass();

        void signup();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
