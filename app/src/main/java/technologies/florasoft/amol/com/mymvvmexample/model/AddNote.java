package technologies.florasoft.amol.com.mymvvmexample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import technologies.florasoft.amol.com.mymvvmexample.BR;

public class AddNote extends BaseObservable {

    public String Title;
    public String Discription;

    public String getTitle() {
        return Title;
    }

    @Bindable
    public void setTitle(String Title) {
        this.Title = Title;
        notifyPropertyChanged(BR.title);
    }

    public String getDiscription() {
        return Discription;
    }

    @Bindable
    public void setDiscription(String Discription) {
        this.Discription = Discription;
        notifyPropertyChanged(BR.discription);
    }


}
