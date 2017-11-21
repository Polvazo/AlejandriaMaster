package com.unmsm.alejandriamaster.Presentation.Contracs;

import com.unmsm.alejandriamaster.Core.BasePresenter;
import com.unmsm.alejandriamaster.Core.BaseView;

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