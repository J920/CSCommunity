package com.android.team920.cscommunity.Trophy;

import android.content.Context;
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

import com.android.team920.cscommunity.R;
import com.android.team920.cscommunity.Trophy.Adapter.TrophyAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TrophyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TrophyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrophyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TrophyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrophyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrophyFragment newInstance(String param1, String param2) {
        TrophyFragment fragment = new TrophyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

            final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.DarkTheme);

            // clone the inflater using the ContextThemeWrapper
            inflater = inflater.cloneInContext(contextThemeWrapper);
            return inflater.inflate(R.layout.fragment_trophy, container, false);




        }else{
            final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);

            // clone the inflater using the ContextThemeWrapper
            inflater = inflater.cloneInContext(contextThemeWrapper);
            return inflater.inflate(R.layout.fragment_trophy, container, false);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TabLayout tabLayout = view.findViewById(R.id.trophy_tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.trophy_week_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.trophy_month_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.trophy_year_icon));
        tabLayout.setTabGravity( TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = view.findViewById(R.id.container_trophy);
        TrophyAdapter adapter = new TrophyAdapter(getFragmentManager(), tabLayout.getTabCount());
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
