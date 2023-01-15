package com.fstt.cours.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;




import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ProductDetailsActivity extends AppCompatActivity {

    private Button addToCard;
    private ImageView productImage,rr;
    private ElegantNumberButton numberButton;
    private TextView productPrice, productDescription, productName;
    private String productID = "", states = "normal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        productID = getIntent().getStringExtra("pid");

        addToCard = (Button) findViewById(R.id.product_add_to_card_btn);
        numberButton = (ElegantNumberButton) findViewById(R.id.number_btn);
        productImage = (ImageView) findViewById(R.id.product_image_details);
        productPrice = (TextView) findViewById(R.id.product_price_details);
        productName = (TextView) findViewById(R.id.product_name_details);
        productDescription = (TextView) findViewById(R.id.product_description_details);
        rr = (ImageView) findViewById(R.id.rr);

        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        addToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (states == "livre" || states == "non livre") {

                    Toast.makeText(ProductDetailsActivity.this, "Veuiller attendre la confirmation de votre précédent commande SVP", Toast.LENGTH_LONG).show();
                    
                }
                else {
                    addingToCard();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void addingToCard() {

        String saveCurrentDate, saveCurrentTIme;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd,yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTIme = currentTime.format(calendar.getTime());


        final HashMap<String, Object> cardMap = new HashMap<>();
        cardMap.put("pid", productID);
        cardMap.put("pname", productName.getText().toString());
        cardMap.put("price", productPrice.getText().toString());
        cardMap.put("date", saveCurrentDate);
        cardMap.put("time", saveCurrentTIme);
        cardMap.put("quantity", numberButton.getNumber());
        cardMap.put("discount", "");

    }


}
