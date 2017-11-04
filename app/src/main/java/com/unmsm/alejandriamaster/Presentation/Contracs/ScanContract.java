package com.unmsm.alejandriamaster.Presentation.Contracs;

import android.app.Activity;
import android.content.Intent;

import com.unmsm.alejandriamaster.Core.BasePresenter;
import com.unmsm.alejandriamaster.Core.BaseView;
import com.unmsm.alejandriamaster.Data.Entities.loginData;

public interface ScanContract {

    interface View extends BaseView<Presenter> {
        void errorScanQr(String msg);
        void successScanQr(String msg);
        void getCodeQr();

    }

    interface Presenter extends BasePresenter {
        void ScanPhoto(String msg);
    }
}
