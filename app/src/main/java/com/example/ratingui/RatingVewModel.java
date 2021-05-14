package com.example.ratingui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RatingVewModel extends ViewModel {
    private final MutableLiveData<List<Rating>> ratinglistMutableLiveData;


    public RatingVewModel() {
        ratinglistMutableLiveData = new MutableLiveData<>();
        List<Rating> ratingList = new ArrayList<>();
        String Cmt1 = "I am very satisfied with this product ";
        String Cmt2 = "Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come out haha. It’s like famine and then feast and dresses HAPPY SPRING! ";
        String Cmt3 = "Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come ";


        ratingList.add(new Rating(R.drawable.profile1, "Kim Joong***",5,"06-04-2021 11:36", Cmt2,null, null, null, false, null));
        ratingList.add(new Rating(R.drawable.profile1, "Kim Joong***",4,"06-04-2021 11:36", Cmt1, null ,null, null, false, null));
        ratingList.add(new Rating(R.drawable.profile2, "Park H***",5,"06-04-2021 11:36", Cmt2,"See more", null, null, false,Cmt3));
        ratingList.add(new Rating(R.drawable.profile3, "Kim*******",3,"06-04-2021 11:36", Cmt3, null,
                "Angela Soraphiare Shop", "Hi, thank you for feedback",true,null));
        ratingList.add(new Rating(R.drawable.profile4, "Park H***",4,"06-04-2021 11:36", Cmt2, null,null, null,false,null));
        ratingList.add(new Rating(R.drawable.profile2, "Kim*******",5,"06-04-2021 11:36", Cmt1, "See more",
                "Angela Soraphiare Shop", "Hi, thank you for feedback", false, Cmt3));
        ratingList.add(new Rating(R.drawable.profile3, "Kim Joong***",2,"06-04-2021 11:36", Cmt2, "See More",null, null, false, Cmt3));
        ratingList.add(new Rating(R.drawable.profile4, "Park H***",4,"06-04-2021 11:36", Cmt1, null,null, null, false, null));
        ratingList.add(new Rating(R.drawable.profile1, "Kim Joong***",5,"06-04-2021 11:36", Cmt3, null,null, null, true, null));
        ratinglistMutableLiveData.setValue(ratingList);

    }

    public MutableLiveData<List<Rating>> getRatinglistMutableLiveData() {
        return ratinglistMutableLiveData;
    }
}
