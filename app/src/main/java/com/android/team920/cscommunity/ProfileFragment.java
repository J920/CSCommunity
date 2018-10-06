package com.android.team920.cscommunity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.AppCompatDialog;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.android.team920.cscommunity.ProfileAdapter;






public class ProfileFragment extends Fragment implements AnswerFragment.OnFragmentInteractionListener,
        YourQuestionsFragment.OnFragmentInteractionListener{


    private Switch nightMode;






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

                final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.DarkTheme);

    // clone the inflater using the ContextThemeWrapper
    LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
            return localInflater.inflate(R.layout.fragment_profile, container, false);




        }else{
            final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);

            // clone the inflater using the ContextThemeWrapper
            LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
            return localInflater.inflate(R.layout.fragment_profile, container, false);
        }



        // Inflate the layout for this fragment

       // return inflater.inflate(R.layout.fragment_profile, container, false);
    }
public void refresh(LayoutInflater inflater){

////
////    FragmentTransaction ft = getFragmentManager().beginTransaction();
////    ft.detach(this).attach(this).commit();
//
//    getFragmentManager()
//            .beginTransaction()
//            .detach(this)
//            .attach(this)
//            .commit();
//
//
}

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        nightMode=view.findViewById(R.id.switch1);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

            nightMode.setChecked(true);

        }else{
            nightMode.setChecked(false);

        }
        TabLayout tabLayout = view.findViewById(R.id.profile_tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile_answer_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile_question_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile_like_icon));
        tabLayout.setTabGravity( TabLayout.GRAVITY_FILL);


        nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);




                    Intent intent=new Intent(getContext(),MainActivity.class);
                    getContext().startActivity(intent);
                    getActivity().finish();


                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    Intent intent=new Intent(getContext(),MainActivity.class);
                    getContext().startActivity(intent);
                    getActivity().finish();


                    // refresh();
//                    ProfileFragment fragment = (ProfileFragment)
//                            getFragmentManager().findFragmentById(R.id.container1);
//
//                    getFragmentManager().beginTransaction()
//                            .detach(fragment)
//                            .attach(fragment)
//                            .commit();

                }
            }
        });

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
