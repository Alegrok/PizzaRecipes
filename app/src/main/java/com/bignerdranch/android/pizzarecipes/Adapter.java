package com.bignerdranch.android.pizzarecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private List<PizzaItem> mPizzaItems;
    private Context mContext;

    public Adapter(List<PizzaItem> pizzaItems, Context context) {
        this.mPizzaItems = pizzaItems;
        this.mContext = context;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mPizzaImageView;
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mPizzaImageView = itemView.findViewById(R.id.pizza_item_image_view);
            mTitleTextView = itemView.findViewById(R.id.pizza_item_title_text_view);
            mDescriptionTextView = itemView.findViewById(R.id.pizza_item_description_text_view);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            PizzaItem item = mPizzaItems.get(position);

            Intent intent = new Intent(mContext, RecipeActivity.class);
            intent.putExtra("imageResource", item.getImageResource());
            intent.putExtra("title", item.getTitle());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("recipe", item.getRecipe());
            mContext.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_pizza_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PizzaItem item = mPizzaItems.get(position);
        holder.mPizzaImageView.setImageResource(item.getImageResource());
        holder.mTitleTextView.setText(item.getTitle());
        holder.mDescriptionTextView.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return mPizzaItems.size();
    }
}
