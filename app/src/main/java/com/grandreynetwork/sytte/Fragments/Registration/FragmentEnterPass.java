package com.grandreynetwork.sytte.Fragments.Registration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.grandreynetwork.sytte.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentEnterPass extends Fragment {

    private static final String SIGN_UP_MODE = "SIGN_UP_MODE";
    private static final String ARG_PARAM2 = "param2";
    private boolean signupmode = false;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    Unbinder unbinder;

    @BindView(R.id.btn_proceed)
    Button btn_proceed;

    @BindView(R.id.txt_header)
    TextView txt_header;
    @BindView(R.id.txt_header_boady)
    TextView txt_header_boady;


    public FragmentEnterPass() {
        // Required empty public constructor
    }


    public static FragmentEnterPass newInstance(boolean signupmode) {
        FragmentEnterPass fragment = new FragmentEnterPass();
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
        View view = inflater.inflate(R.layout.fragment_enter_pass, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (signupmode)
            txt_header.setText("verify phone no.");
        txt_header_boady.setText("check your phone for verification code\nsent to you and enter it here");
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
        void onFragmentInteraction(Uri uri);

        void proceed();

        void loadAccDetail();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_proceed)
    public void proceed() {
        if (signupmode) {
            mListener.loadAccDetail();
        } else {
            mListener.proceed();
        }
    }
}
