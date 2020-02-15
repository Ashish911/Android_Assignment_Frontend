package com.example.onlinefoodportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodportal.api.OrderAPI;
import com.example.onlinefoodportal.model.Order;
import com.example.onlinefoodportal.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyActivity extends AppCompatActivity {

    TextView tvFoodName, tvPrice;
    EditText etAddress, etPhoneNo;
    Button btnOrder, btnCancel;
    String Address, FoodName, PhoneNo;
    int Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        tvFoodName = findViewById(R.id.tvBFoodName);
        tvPrice = findViewById(R.id.tvBFoodPrice);
        etAddress = findViewById(R.id.etLocation);
        etPhoneNo = findViewById(R.id.etPhoneNos);
        btnOrder = findViewById(R.id.btnOrder);
        btnCancel = findViewById(R.id.btnCancel);
        Intent intent = getIntent();
        FoodName = intent.getExtras().getString("name");
        Price = intent.getExtras().getInt("price");

        tvFoodName.setText(FoodName);
        tvPrice.setText("Rs " + Price);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etAddress.getText())) {
                    etAddress.setError("Please Enter Address");
                    etAddress.requestFocus();
                } else if (TextUtils.isEmpty(etPhoneNo.getText())) {
                    etPhoneNo.setError("Please Enter Phone No");
                    etPhoneNo.requestFocus();
                }
                Address = etAddress.getText().toString();
                PhoneNo = etPhoneNo.getText().toString();
                Order order = new Order(FoodName, Price, Address, PhoneNo);
                OrderAPI orderAPI = Url.getInstance().create(OrderAPI.class);
                Call<Void> voidCall = orderAPI.order(Url.token, order);
                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(BuyActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(BuyActivity.this, "Bought Successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(BuyActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                finish();
            }
        });

    }
}
