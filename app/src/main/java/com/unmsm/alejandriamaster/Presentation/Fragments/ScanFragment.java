package com.unmsm.alejandriamaster.Presentation.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.unmsm.alejandriamaster.Core.BaseFragment;
import com.unmsm.alejandriamaster.Data.Entities.loginData;
import com.unmsm.alejandriamaster.Presentation.Activity.LoginAlejandria;
import com.unmsm.alejandriamaster.Presentation.Contracs.LoginContract;
import com.unmsm.alejandriamaster.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by USUARIO on 03/11/2017.
 */

public class ScanFragment  extends BaseFragment{

    public static ScanFragment newInstance() {
        return new ScanFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scan, container, false);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

       @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
