package com.unmsm.alejandriamaster.Core;

/**
 * Created by christian on 6/23/17.
 */

public interface BaseView<T> {

    void setLoadingIndicator(boolean active);
    void setMessageError(String error);
    void setDialogMessage(String message);
    boolean isActive();
    void setPresenter(T presenter);

}