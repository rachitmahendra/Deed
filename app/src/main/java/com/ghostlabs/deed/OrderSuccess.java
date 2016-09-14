package com.ghostlabs.deed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Hp on 14-07-2016.
 */
public class OrderSuccess extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
    }
    private void onExit(View v){
        finish();
    }
    private void startNewOrder(View v){
        Intent i = new Intent(this,OrderDetails.class);
        startActivity(i);

    }
}