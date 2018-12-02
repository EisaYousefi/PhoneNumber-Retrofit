package com.broa.phonbookapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.broa.phonbookapp.Django.PhoneService;
import com.broa.phonbookapp.Django.RetrofitClient;
import com.broa.phonbookapp.models.MyContacts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AddContactActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextInputEditText name,tel,img_newContect;
    Button save ;
    MyContacts myContacts;
    Retrofit retrofit;
    PhoneService phoneService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contect);

        name           = findViewById(R.id.name_newContect);
        tel            = findViewById(R.id.tel_newContect);
        img_newContect = findViewById(R.id.tel_newContect);
        save           = findViewById(R.id.btn_saveNewContect);

        toolbar        =findViewById(R.id.toolbar);
        toolbar.setTitle("Phone Book");
        toolbar.setSubtitle("efb1371");
        toolbar.setLogo(R.drawable.ic_contact_phone_red_400_24dp);



        retrofit     = RetrofitClient.getInsrtanc();
        phoneService = retrofit.create(PhoneService.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(myContacts == null) myContacts = new MyContacts();

                if (name.getText().toString().equals("")
                        || tel.getText().toString().equals("")
                        || img_newContect.getText().toString().equals("")
                        ) {
                    Toast.makeText(getApplication(), "لطفا فیلد های خالی را مقدار دهی کنید ", Toast.LENGTH_SHORT).show();

                } else {
                         myContacts.setName(name.getText().toString().trim());
                         myContacts.setTel(tel.getText().toString().trim());
                        // myContacts.setImg(Integer.valueOf(img_newContect.getText().toString().trim()));

                    Call<MyContacts> call = phoneService.create(myContacts);
                         call.enqueue(new Callback <MyContacts>() {
                         @Override
                         public void onResponse(Call <MyContacts> call, Response <MyContacts> response) {
                            if (response.isSuccessful())
                               Toast.makeText(getApplication(), "با موفقیت ثبت شد", Toast.LENGTH_SHORT).show();

                    }

                        @Override
                        public void onFailure(Call <MyContacts> call, Throwable t) {
                           Toast.makeText(getApplication(), "اتصال با سرور رابرسی کنید", Toast.LENGTH_SHORT).show();


                        }
                    });

                        Intent intent = new Intent(AddContactActivity.this,MainActivity.class);
                        startActivity(intent);
                }

            }
        });


    }
}
