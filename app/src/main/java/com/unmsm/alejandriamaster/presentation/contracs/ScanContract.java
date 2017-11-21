package com.unmsm.alejandriamaster.presentation.contracs;


import com.unmsm.alejandriamaster.core.BasePresenter;
import com.unmsm.alejandriamaster.core.BaseView;


public interface ScanContract {

    interface View extends BaseView<Presenter> {

        void getCodeQr();
    }

    interface Presenter extends BasePresenter {
        void getLoanData();

    }
}
