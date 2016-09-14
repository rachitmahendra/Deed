package com.ghostlabs.deed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.andexert.expandablelayout.library.ExpandableLayout;

/**
 * Created by Hp on 14-07-2016.
 */
public class OrderDetails extends AppCompatActivity {
    NumberPicker elderlyClothesNum,childClothesNum,womenClothesNum,menClothesNum, utensilsNum, primaryBooksNum,higherBooksNum,collegeBooksNum,competitionBooksNum,otherBooksNum;
    CheckBox clothes,elderlyClothes,childClothes,womenClothes,menClothes , books,primaryBooks,higherBooks,collegeBooks,competitionBooks,otherBooks ,utensils;
    ExpandableLayout mExpandableLayout, mExpandableLayout2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        mExpandableLayout = (ExpandableLayout)findViewById(R.id.expandableLayout);
        mExpandableLayout2 = (ExpandableLayout)findViewById(R.id.expandableLayout2);
        clothes = (CheckBox)findViewById(R.id.clothes);
        elderlyClothes=(CheckBox)findViewById(R.id.elderly_clothes_content);
        childClothes=(CheckBox)findViewById(R.id.child_clothes_content);
        womenClothes=(CheckBox)findViewById(R.id.women_clothes_content);
        menClothes=(CheckBox)findViewById(R.id.men_clothes_content);
        utensils =(CheckBox)findViewById(R.id.utensils);
        books = (CheckBox) findViewById(R.id.books);
        primaryBooks=(CheckBox)findViewById(R.id.primary_books_content);
        higherBooks=(CheckBox)findViewById(R.id.higher_books_content);
        collegeBooks=(CheckBox)findViewById(R.id.college_books_content);
        otherBooks=(CheckBox)findViewById(R.id.other_books_content);

        elderlyClothesNum = (NumberPicker) findViewById(R.id.num_elderly_clothes);
        childClothesNum = (NumberPicker) findViewById(R.id.num_child_clothes);
        womenClothesNum = (NumberPicker) findViewById(R.id.num_women_clothes);
        menClothesNum = (NumberPicker) findViewById(R.id.num_men_clothes);
        primaryBooksNum=(NumberPicker)findViewById(R.id.num_primary_books);
        higherBooksNum=(NumberPicker)findViewById(R.id.num_higher_books);
        collegeBooksNum=(NumberPicker)findViewById(R.id.num_college_books);
        competitionBooksNum=(NumberPicker)findViewById(R.id.num_competition_books);
        otherBooksNum=(NumberPicker)findViewById(R.id.num_other_books);

        utensilsNum = (NumberPicker) findViewById(R.id.num_utensils);

        elderlyClothesNum.setVisibility(View.INVISIBLE);
        menClothesNum.setVisibility(View.INVISIBLE);
        womenClothesNum.setVisibility(View.INVISIBLE);
        childClothesNum.setVisibility(View.INVISIBLE);
        utensilsNum.setVisibility(View.INVISIBLE);
        primaryBooksNum.setVisibility(View.INVISIBLE);
        higherBooksNum.setVisibility(View.INVISIBLE);
        collegeBooksNum.setVisibility(View.INVISIBLE);
        otherBooksNum.setVisibility(View.INVISIBLE);
        competitionBooksNum.setVisibility(View.INVISIBLE);

       /* clothesNum.setVisibility(View.INVISIBLE);
        booksNum.setVisibility(View.INVISIBLE);

        booksNum.setMaxValue(50);
        booksNum.setMinValue(2);
        booksNum.setValue(2);
        booksNum.setWrapSelectorWheel(true);*/
        utensilsNum.setMaxValue(50);
        utensilsNum.setMinValue(2);
        utensilsNum.setValue(2);
        utensilsNum.setWrapSelectorWheel(true);
        elderlyClothesNum.setMinValue(2);
        elderlyClothesNum.setMaxValue(50);
        elderlyClothesNum.setValue(2);
        elderlyClothesNum.setWrapSelectorWheel(true);
        menClothesNum.setMinValue(2);
        menClothesNum.setMaxValue(50);
        menClothesNum.setValue(2);
        menClothesNum.setWrapSelectorWheel(true);
       womenClothesNum.setMinValue(2);
        womenClothesNum.setMaxValue(50);
        womenClothesNum.setValue(2);
        womenClothesNum.setWrapSelectorWheel(true);
        childClothesNum.setMinValue(2);
        childClothesNum.setMaxValue(50);
        childClothesNum.setValue(2);
        childClothesNum.setWrapSelectorWheel(true);
        primaryBooksNum.setMinValue(2);
        primaryBooksNum.setMaxValue(50);
        primaryBooksNum.setValue(2);
        primaryBooksNum.setWrapSelectorWheel(true);
        higherBooksNum.setMinValue(2);
        higherBooksNum.setMaxValue(50);
        higherBooksNum.setValue(2);
        higherBooksNum.setWrapSelectorWheel(true);
        collegeBooksNum.setMinValue(2);
        collegeBooksNum.setMaxValue(50);
        collegeBooksNum.setValue(2);
        collegeBooksNum.setWrapSelectorWheel(true);
        competitionBooksNum.setMinValue(2);
        competitionBooksNum.setMaxValue(50);
        competitionBooksNum.setValue(2);
        competitionBooksNum.setWrapSelectorWheel(true);
        otherBooksNum.setMinValue(2);
        otherBooksNum.setMaxValue(50);
        otherBooksNum.setValue(2);
        otherBooksNum.setWrapSelectorWheel(true);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.clothes:
                if (checked) {
                    mExpandableLayout.show();

                    makeToast("Please select the Category");
                }
                else
                    mExpandableLayout.hide();

                break;
            case R.id.child_clothes_content:
                if (checked) {

                    childClothesNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    childClothesNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.women_clothes_content:
                if (checked) {

                    womenClothesNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    womenClothesNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.elderly_clothes_content:
                if (checked) {

                    elderlyClothesNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    elderlyClothesNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.men_clothes_content:
                if (checked) {

                    menClothesNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    menClothesNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.utensils:
                if(checked){
                    utensilsNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else
                utensilsNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.books:
                if (checked) {
                    mExpandableLayout2.show();

                    makeToast("Please select the Category");
                }
                else
                    mExpandableLayout2.hide();

                break;
            case R.id.primary_books_content:
                if (checked) {

                    primaryBooksNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    primaryBooksNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.higher_books_content:
                if (checked) {

                    higherBooksNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    higherBooksNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.college_books_content:
                if (checked) {

                    collegeBooksNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    collegeBooksNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.competition_books_content:
                if (checked) {

                    competitionBooksNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    competitionBooksNum.setVisibility(View.INVISIBLE);
                break;
            case R.id.other_books_content:
                if (checked) {

                    otherBooksNum.setVisibility(View.VISIBLE);
                    makeToast("Please select the quantity");
                }
                else

                    otherBooksNum.setVisibility(View.INVISIBLE);
                break;
        }
    }
    public void onNextClick(View v){
        String orderString ="";
        if(clothes.isChecked()){
            orderString+="Clothes :";
            if(elderlyClothes.isChecked()){
                orderString+="Elderly="+elderlyClothesNum.getValue();
            }
            if(womenClothes.isChecked()){
                orderString+="Women="+womenClothesNum.getValue();
            }
            if(menClothes.isChecked()){
                orderString+="Men="+menClothesNum.getValue();
            }
            if(childClothes.isChecked()){
                orderString+="Child="+ childClothesNum.getValue();
            }

        }
        if(utensils.isChecked()){
            orderString += "Utensils=" + utensilsNum.getValue();
        }
        if(books.isChecked()){
            orderString+="Books :";
            if(primaryBooks.isChecked()){
                orderString+="Primary="+primaryBooksNum.getValue();
            }
            if(higherBooks.isChecked()){
                orderString+="Higher="+ higherBooksNum.getValue();
            }
            if(collegeBooks.isChecked()){
                orderString+="College="+collegeBooksNum.getValue();
            }
            if(otherBooks.isChecked()){
                orderString+="Other="+ otherBooksNum.getValue();
            }
            //orderString += "Books=" + booksNum.getValue();
        }
        if(orderString!=""){
            Intent intent=new Intent(this, UserDetails.class);
            intent.putExtra("orderString",orderString);
            startActivity(intent);
        }
        else
            makeToast("Please select an item");
    }
    public void makeToast(String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }
}