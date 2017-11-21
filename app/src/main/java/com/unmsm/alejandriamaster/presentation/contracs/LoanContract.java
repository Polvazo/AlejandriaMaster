package com.unmsm.alejandriamaster.presentation.contracs;

import com.unmsm.alejandriamaster.core.BasePresenter;
import com.unmsm.alejandriamaster.core.BaseView;

public interface LoanContract {

    interface View extends BaseView<Presenter> {
        void successLoginUser();

        void setMessage(boolean active, String message);
        void getTextView(String user, String book);


           }

    interface Presenter extends BasePresenter {
        void checkBook(String idBook);

        void getLoanData(int user, int book);

        void pathLoan();

        void pathLoanBook();
    }
}