package com.broa.phonbookapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.broa.phonbookapp.Django.PhoneService;
import com.broa.phonbookapp.Django.RetrofitClient;
import com.broa.phonbookapp.fragment.Contact_fragment;
import com.broa.phonbookapp.fragment.Message_fragment;
import com.broa.phonbookapp.fragment.New_contact_fragment;
import com.broa.phonbookapp.models.MyContacts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    SearchView searchView;
    Retrofit retrofit;
    PhoneService phoneService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.search);
        toolbar   = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);

        retrofit = RetrofitClient.getInsrtanc();
        phoneService = retrofit.create(PhoneService.class);

        Call<List<MyContacts>> listCall = phoneService.getContact();
        listCall.enqueue(new Callback<List <MyContacts>>() {
            @Override
            public void onResponse(Call <List <MyContacts>> call, Response<List <MyContacts>> response) {

                List <MyContacts> modelsList = response.body();

            }

            @Override
            public void onFailure(Call <List <MyContacts>> call, Throwable t) {
                Toast.makeText(getApplication(), t.toString(), Toast.LENGTH_SHORT).show();


            }

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });



       // toolbar.setTitle("Phone Book");
        toolbar.setSubtitle("efb1371");
        toolbar.setLogo(R.drawable.ic_contact_phone_red_400_24dp);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;

            }
        });

        configViewpager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts_black_24dp);
//       // tabLayout.getTabAt(0).getIcon().setColorFilter(Color.BLUE,PorterDuff.Mode.SRC);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_call_black_24dp);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_message_black_24dp);
        setcustomTabs();




    }

    private void setcustomTabs() {
        TextView tab1 = (TextView) LayoutInflater.from(this).inflate(R.layout.custum_tab,null);
        tab1.setText("Message");
        tab1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_message_black_24dp,0,0);
        tabLayout.getTabAt(2).setCustomView(tab1);

        TextView tab2 = (TextView) LayoutInflater.from(this).inflate(R.layout.custum_tab,null);
        tab2.setText("New Contact");
        tab2.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.add,0,0);
        tabLayout.getTabAt(1).setCustomView(tab2);

        TextView tab3 = (TextView) LayoutInflater.from(this).inflate(R.layout.custum_tab,null);
        tab3.setText("Contacts");
        tab3.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_contacts_black_24dp,0,0);
        tabLayout.getTabAt(0).setCustomView(tab3);


    }



    private void configViewpager(ViewPager viewPager) {
        ViewpagerAdaptor adapter = new ViewpagerAdaptor(getSupportFragmentManager());
        Contact_fragment contectFragment=new Contact_fragment();
        Message_fragment message_fragment = new Message_fragment();
        New_contact_fragment new_contact_fragment = new New_contact_fragment();
        adapter.addtolist(contectFragment,"contacts");
        adapter.addtolist(new_contact_fragment,"New contact");
        adapter.addtolist(message_fragment,"Message");
        viewPager.setAdapter(adapter);


    }

    class  ViewpagerAdaptor extends FragmentPagerAdapter{
        List<Fragment>   myFragmentlist   = new ArrayList <>();
        List<String> myPageTitlelist   = new ArrayList <>();


        public ViewpagerAdaptor(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return myFragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return myFragmentlist.size();
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return  null;//myPageTitlelist.get(position);
        }
        public void  addtolist(Fragment fragment,String title){
            myFragmentlist.add(fragment);
            myPageTitlelist.add(title);
        }
    }
}
