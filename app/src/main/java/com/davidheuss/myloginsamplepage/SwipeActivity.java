package com.davidheuss.myloginsamplepage;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mindorks.placeholderview.*;

public class SwipeActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                    .setPaddingTop(20)
                    .setRelativeScale(0.01f)
                    .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                    .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        for (Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mSwipeView.doSwipe(true);
            }
        });
    }
}