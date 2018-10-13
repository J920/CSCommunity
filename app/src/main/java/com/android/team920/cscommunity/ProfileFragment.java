package com.android.team920.cscommunity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileFragment extends Fragment implements PostFragment.OnFragmentInteractionListener,
        YourQuestionsFragment.OnFragmentInteractionListener{


     //private DayNightSwitch nightMode;
    private ImageView setting;
    TextView profileName ;






    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

                 Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.DarkTheme);


//            Resources res = getContext().getResources();
//            final int newColor = res.getColor(R.color.whiteGrean);
//            setting.setColorFilter(newColor, Mode.SRC_ATOP);

    // clone the inflater using the ContextThemeWrapper
     inflater = inflater.cloneInContext(contextThemeWrapper);
            return inflater.inflate(R.layout.fragment_profile, container, false);




        }else{
             Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);


//            Resources res = getContext().getResources();
//            final int newColor = res.getColor(R.color.black);
//            setting.setColorFilter(newColor, Mode.SRC_ATOP);
            // clone the inflater using the ContextThemeWrapper
            inflater = inflater.cloneInContext(contextThemeWrapper);
            return inflater.inflate(R.layout.fragment_profile, container, false);
        }



        // Inflate the layout for this fragment

       // return inflater.inflate(R.layout.fragment_profile, container, false);
    }


    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // nightMode= (DayNightSwitch) view.findViewById(R.id.switch1);
       // nightMode.setThumbDrawable(R.drawable.day_icon);

        setting= view.findViewById(R.id.setting);
        profileName = view.findViewById(R.id.txtProfileName);
        TabLayout tabLayout = view.findViewById(R.id.profile_tabs);
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.edit).setText("تدويناتي"));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile_question_icon).setText("اسئلتي و اجوبتي"));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile_like_icon).setText("المفضلة"));

        tabLayout.addTab(tabLayout.newTab().setText("تدويناتي"));
        tabLayout.addTab(tabLayout.newTab().setText("اسئلتي و اجوبتي"));
        tabLayout.addTab(tabLayout.newTab().setText("المفضلة"));

        tabLayout.setTabGravity( TabLayout.GRAVITY_FILL);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),Setting.class);
                intent.putExtra("Profile Name",profileName.getText());
                startActivity(intent);

            }
        });

//TODO Night swich with library begin
//        nightMode.setDuration(2000);
//
//        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
//            nightMode.setIsNight(true);
//        }
//
//        nightMode.setListener(new DayNightSwitchListener() {
//            @Override
//            public void onSwitch(boolean isNight) {
//
//                if(isNight){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//
//
//
//                    Intent intent=new Intent(getContext(),MainActivity.class);
//                    getContext().startActivity(intent);
//                    getActivity().finish();
//
//
//                }else{
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//                    Intent intent=new Intent(getContext(),MainActivity.class);
//                    getContext().startActivity(intent);
//                    getActivity().finish();
//
//
//
//                }
//
//            }
//        });


        //TODO Night swich with library end]








//        nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//
//
//
//                    Intent intent=new Intent(getContext(),MainActivity.class);
//                    getContext().startActivity(intent);
//                    getActivity().finish();
//
//
//                }else{
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//                    Intent intent=new Intent(getContext(),MainActivity.class);
//                    getContext().startActivity(intent);
//                    getActivity().finish();
//
//
//                    // refresh();
////                    ProfileFragment fragment = (ProfileFragment)
////                            getFragmentManager().findFragmentById(R.id.container1);
////
////                    getFragmentManager().beginTransaction()
////                            .detach(fragment)
////                            .attach(fragment)
////                            .commit();
//
//                }
//            }
//        });

        final ViewPager viewPager = view.findViewById(R.id.container_profile);
        ProfileAdapter adapter = new ProfileAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {



            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    // TODO: Rename method, update argument and hook method into UI event

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
