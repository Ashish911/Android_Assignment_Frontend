package com.example.onlinefoodportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodportal.api.FavouriteAPI;
import com.example.onlinefoodportal.channel.CreateChannel;
import com.example.onlinefoodportal.url.Url;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodDisplayActivity extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    Toolbar toolbar;
    private TextView tvName, tvPrice;
    private ImageView imgFood;
    private ImageButton favourite;
    private Button buybtn;
    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_display);

        toolbar = findViewById(R.id.toolBarF);
        setSupportActionBar(toolbar);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        imgFood = findViewById(R.id.imgfood);
        favourite = findViewById(R.id.favourites);
        buybtn = findViewById(R.id.buybtn);

        Intent intent = getIntent();
        final String Name = intent.getExtras().getString("Name");
        final String Price = intent.getExtras().getString("Price");
        final String img = intent.getExtras().getString("Image");
        final String FoodId = intent.getExtras().getString("id");

        tvName.setText(Name);
        tvPrice.setText("Rs " + Price);
        Picasso.get().load(Url.base_url_image + img).into(imgFood);


        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteAPI favouriteAPI = Url.getInstance().create(FavouriteAPI.class);
                Call<Void> voidCall = favouriteAPI.addUser(Url.token,FoodId);
                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(FoodDisplayActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(FoodDisplayActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                DisplayNotification();

                favourite.setVisibility(View.INVISIBLE);
            }
        });

        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FoodDisplayActivity.this, BuyActivity.class);
                intent1.putExtra("name", Name);
                intent1.putExtra("price", Price);
                startActivity(intent1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.Home:
                intent = new Intent(this, DashboardActivity.class);
                intent.putExtra("name", "home");
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void DisplayNotification() {

        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("Favourite")
                .setContentText("Successfully added to favourites")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }
}
