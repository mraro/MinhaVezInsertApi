package domain.aro.minhavezinsertapi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import domain.aro.minhavezinsertapi.R;

/**
 * Created by alessandro.roliveir4 on 04/04/2018.
 */

public class Narutinho_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naruto_layout);

        getSupportActionBar().hide();

        String name = getIntent().getExtras().getString("name_personagem");
        String description = getIntent().getExtras().getString("narutinho_description");
        String image_url = getIntent().getExtras().getString("narutinho_image");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);

        collapsingToolbarLayout.setTitleEnabled(true);


        TextView tv_name = findViewById(R.id.aa_name_personagem);
        TextView tv_description = findViewById(R.id.aa_description);
        ImageView tv_image_url = findViewById(R.id.aa_image);

        tv_name.setText(name);
        tv_description.setText(description);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(image_url).apply(requestOptions).into(tv_image_url);

    }
}
