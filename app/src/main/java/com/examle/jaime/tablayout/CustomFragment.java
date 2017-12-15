package com.examle.jaime.tablayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CustomFragment extends Fragment {
    public static final String KEY_MESSAGE = "keymessage";

    private TextView txvMessage;


    public static CustomFragment newInstance(Bundle bundle) {
        CustomFragment fragment = new CustomFragment();

        if (bundle != null)
            fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        txvMessage = view.findViewById(R.id.txv_message);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txvMessage.setText(getArguments().getString(KEY_MESSAGE));
    }
}
