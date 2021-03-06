package com.example.chatfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.xwray.groupie.GroupAdapter;

public class SalaActivity extends AppCompatActivity {


    private GroupAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);


        verifyAuthentication();


        Button edit_enter1 = findViewById(R.id.edit_enter1);
        Button edit_enter2 = findViewById(R.id.edit_enter2);
        Button edit_enter3 = findViewById(R.id.edit_enter3);
        Button edit_enter4 = findViewById(R.id.edit_enter4);



        edit_enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_enter1 = new Intent(SalaActivity.this, ChatActivity.class);


                startActivity(edit_enter1);
            }

        });

        edit_enter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_enter2 = new Intent(SalaActivity.this, Contact.class);
                startActivity(edit_enter2);
            }

        });

        edit_enter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_enter3 = new Intent(SalaActivity.this, Contact.class);
                startActivity(edit_enter3);
            }

        });


        edit_enter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_enter4 = new Intent(SalaActivity.this, Contact.class);
                startActivity(edit_enter4);
            }

        });



    }


    private  void verifyAuthentication(){
        if (FirebaseAuth.getInstance().getUid()==null){
            Intent intent= new Intent(SalaActivity.this, ChatActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contacts:
                Intent  intent= new Intent(SalaActivity.this, ContactsActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                verifyAuthentication();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


}

