package com.bignerdranch.android.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        ImageView imageView = findViewById(R.id.recipe_image_view);
        TextView title = findViewById(R.id.recipe_title_text_view);
        TextView description = findViewById(R.id.recipe_description_text_view);
        TextView recipe = findViewById(R.id.recipe_text_view);

        Intent intent = getIntent();
        if (intent != null) {
            imageView.setImageResource(intent.getIntExtra("imageResource", 0));
            title.setText(intent.getStringExtra("title"));
            description.setText(intent.getStringExtra("description"));
            recipe.setText(intent.getStringExtra("recipe"));
        }
    }
}
