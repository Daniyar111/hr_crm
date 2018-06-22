package com.example.daniyar.hr_crm.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.daniyar.hr_crm.R;
import com.example.daniyar.hr_crm.ui.candidates.CandidatesFragment;
import com.example.daniyar.hr_crm.ui.interview.InterviewFragment;
import com.example.daniyar.hr_crm.ui.requests.RequestsFragment;
import com.example.daniyar.hr_crm.ui.vacancies.VacanciesFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class BaseActivity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

    protected abstract int getViewLayout();
    protected abstract int getToolbarId();

    private Toolbar mToolbar;
    private Drawer mDrawer;
    private AccountHeader mHeader;
    private ProfileDrawerItem mProfileDrawerItem;
    private PrimaryDrawerItem mRequestsDrawerItem, mVacanciesDrawerItem, mCandidatesDrawerItem, mInterviewDrawerItem, mExitDrawerItem;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setContentView(getViewLayout());
    }

    protected void getToolbar(String title, boolean isBack){
        mToolbar = findViewById(getToolbarId());
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isBack);
        }
    }

    private void setToolbarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    protected void getDrawer(){

        mProfileDrawerItem = new ProfileDrawerItem()
                .withName(R.string.name)
                .withEmail(R.string.email)
                .withIcon(R.drawable.ic_person_black_24dp);

        mHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimaryLight)
                .addProfiles(mProfileDrawerItem)
                .build();

        mRequestsDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.request)
                .withIdentifier(1)
                .withIcon(R.drawable.ic_local_post_office_black_24dp);

        mVacanciesDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.vacancies)
                .withIdentifier(2)
                .withIcon(R.drawable.ic_event_note_black_24dp);

        mCandidatesDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.candidates)
                .withIdentifier(3)
                .withIcon(R.drawable.ic_person_black_24dp);

        mInterviewDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.interview)
                .withIdentifier(4)
                .withIcon(R.drawable.ic_phone_in_talk_black_24dp);

        mExitDrawerItem = new PrimaryDrawerItem()
                .withName(R.string.exit)
                .withIdentifier(5)
                .withIcon(R.drawable.ic_exit_to_app_black_24dp);

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withOnDrawerItemClickListener(this)
                .withAccountHeader(mHeader)
                .withToolbar(mToolbar)
                .addDrawerItems(mRequestsDrawerItem,
                        mVacanciesDrawerItem,
                        mCandidatesDrawerItem,
                        mInterviewDrawerItem,
                        new DividerDrawerItem(),
                        mExitDrawerItem)
                .build();
    }

    protected void switchFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        switch ((int) drawerItem.getIdentifier()){
            case 1:
                switchFragment(new RequestsFragment());
                setToolbarTitle(getString(R.string.request));
                break;
            case 2:
                switchFragment(new VacanciesFragment());
                setToolbarTitle(getString(R.string.vacancies));
                break;
            case 3:
                switchFragment(new CandidatesFragment());
                setToolbarTitle(getString(R.string.candidates));
                break;
            case 4:
                switchFragment(new InterviewFragment());
                setToolbarTitle(getString(R.string.interview));
                break;
            case 5:
                finish();
                break;
        }
        return false;
    }
}
