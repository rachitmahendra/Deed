package com.ghostlabs.deed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Hp on 14-07-2016.
 */
public class UserDetails extends AppCompatActivity {
    EditText name, address,email , pincode, city ;
    String orderString;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        name = (EditText)findViewById(R.id.name);
        email =(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        pincode =(EditText)findViewById(R.id.pincode);
        city = (EditText)findViewById(R.id.city);

        Intent mIntent = getIntent();
          orderString = mIntent.getStringExtra("orderString");
    }
    public void onNextClick(View v){
        if((name.getText()!=null) && (address.getText()!=null) && (city.getText()!=null) &&(email.getText()!=null)&&(pincode.getText()!=null))
        {
            Intent newIntent = new Intent(this,OrderConfirmation.class);
            newIntent.putExtra("order",orderString);
            newIntent.putExtra("name",name.getText().toString());
            newIntent.putExtra("email",email.getText().toString());
            newIntent.putExtra("address",address.getText().toString() +city.getText().toString()+ pincode.getText().toString());
            startActivity(newIntent);
        }
        else
            makeToast("Please enter all the details");

    }
    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }

}
