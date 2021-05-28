package com.openclassrooms.entrevoisins.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.AddNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsNeighbour_activity extends Activity {
    // UI Components

    @BindView(R.id.firstname)
    public TextView mFirstname;
    @BindView(R.id.infos_card_name)
    public TextView mCardName;
    @BindView(R.id.address)
    public TextView mAdress;
    @BindView(R.id.phoneNumber)
    public TextView mPhoneNumber;
    @BindView(R.id.web)
    public TextView mWebpage;
    @BindView(R.id.aboutMe)
    public TextView mBiography;

    @BindView(R.id.profile_picture)
    public ImageView mProfilePicture;
    @BindView(R.id.return_btn)
    public ImageButton mReturnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Neighbour value = getIntent().getExtras().getParcelable("test");
        mFirstname.setText(value.getName());
        mCardName.setText(value.getName());
        mAdress.setText(value.getAddress());
        mPhoneNumber.setText(value.getPhoneNumber());
        String webpage = "www.facebook.fr/" + value.getName();
        mWebpage.setText(webpage);
        mBiography.setText(value.getAboutMe());
        mReturnBtn.setOnClickListener(v -> finish());
        Glide.with(this)
                .load(value.getAvatarUrl())
                .into(mProfilePicture);

    }

     /**
     * Used to navigate to this activity
     * @param activity
     */
    public static void navigate(Context activity, Neighbour neighbour) {
        Intent intent = new Intent(activity, DetailsNeighbour_activity.class);
        intent.putExtra("test", neighbour);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
