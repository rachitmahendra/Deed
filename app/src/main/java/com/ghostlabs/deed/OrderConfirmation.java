package com.ghostlabs.deed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Hp on 14-07-2016.
 */
public class OrderConfirmation extends AppCompatActivity {
    TextView name , email, address, items, organization;
    String orderString, nameString,addressString, emailString, organizationString;
    DatabaseReference myRef;
    Order value;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        address = (TextView)findViewById(R.id.address);
        items =(TextView)findViewById(R.id.items);
        organization = (TextView)findViewById(R.id.organization);


        Intent mIntent = getIntent();
        orderString = mIntent.getStringExtra("order");
        nameString = mIntent.getStringExtra("name");
        emailString =mIntent.getStringExtra("email");
        addressString= mIntent.getStringExtra("address");

        organizationString = "Varuni Orphanage , Nungambakkam Road , Chennai 603207";

        name.setText(nameString);
        items.setText(orderString);
        email.setText(emailString);
        organization.setText(organizationString);
        address.setText(addressString);

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
                Toast.makeText(getApplicationContext(),"Sorry an unknown error occurred .Please try again",Toast.LENGTH_LONG).show();
            }
        });


    }
    public void onConfirm(View v){
        writeNewUser( nameString, emailString , addressString , orderString , organizationString);

        Intent newIntent =  new Intent(this,Last_Page.class);

        startActivity(newIntent);

    }
    private void writeNewUser(String name, String email, String address, String items, String organization) {
        Order order = new Order(name, email, address, items, organization);

        myRef.push().setValue(order);
    }

}