package cj.com.a1604kproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;


public abstract class BaseActivity extends AppCompatActivity {

    protected FrameLayout content;
    private View progress;
    private View childView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_base);
        content = this.findViewById(R.id.content);
        progress = findViewById(R.id.progress);

        int id = setSelfView();
        childView = LayoutInflater.from(this).inflate(id,null);
        content.addView(childView);
}

    public void showProgress(){
        childView.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        childView.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    abstract int setSelfView();
}
