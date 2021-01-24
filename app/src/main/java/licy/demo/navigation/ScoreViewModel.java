package licy.demo.navigation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * ScoreViewModel
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/24
 * email ：licy3051@qq.com
 */
public class ScoreViewModel extends AndroidViewModel {

    private SavedStateHandle mStateHandle;
    private static final String KEY_NUMBER = "key_number";

    public ScoreViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.mStateHandle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if (!mStateHandle.contains(KEY_NUMBER)) {
            mStateHandle.set(KEY_NUMBER, 0);
        }
        return mStateHandle.getLiveData(KEY_NUMBER);
    }

    public void setNumber(int number) {
        getNumber().setValue(number);
    }

    public void addNumber(int number) {
        getNumber().setValue(getNumber().getValue() + number);
    }
}
