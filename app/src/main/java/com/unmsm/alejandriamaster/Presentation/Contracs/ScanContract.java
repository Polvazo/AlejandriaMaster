package com.unmsm.alejandriamaster.Presentation.Contracs;


import com.unmsm.alejandriamaster.Core.BasePresenter;
import com.unmsm.alejandriamaster.Core.BaseView;


public interface ScanContract {

    interface View extends BaseView<Presenter> {

        void getCodeQr();
    }

    interface Presenter extends BasePresenter {
        void getLoanData();

    }
}
