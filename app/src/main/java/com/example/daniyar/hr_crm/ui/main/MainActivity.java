package com.example.daniyar.hr_crm.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniyar.hr_crm.R;
import com.example.daniyar.hr_crm.ui.BaseActivity;
import com.example.daniyar.hr_crm.ui.requests.RequestsFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        getToolbar(getString(R.string.request), false);
        getDrawer();
        switchFragment(new RequestsFragment());
    }
}
