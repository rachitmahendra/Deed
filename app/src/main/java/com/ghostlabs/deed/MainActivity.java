package com.ghostlabs.deed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Order value;
    Button btn;
    DatabaseReference myRef;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        btn = (Button) findViewById(R.id.btnUpdate);
         database = FirebaseDatabase.getInstance();
       myRef= FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                 value = dataSnapshot.getValue(Order.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


    }
    public void Update(View v){

        writeNewUser("Rachit","ghostlabs.2015@gmail.com","Agra", "2 shirts + 10 books ","CRY Organization , Chennai");


    }
    private void writeNewUser(String name, String email, String address, String items, String organization) {
        Order order = new Order(name, email, address, items, organization);
        String b="";
       b= name + email;
        txt.setText(b);
        myRef.push().setValue(order);
    }
}
