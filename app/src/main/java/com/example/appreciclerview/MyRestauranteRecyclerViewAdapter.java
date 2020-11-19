package com.example.appreciclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private RestauranteFragment.OnListFragmentInteractionListener myListener;
    private final List<Restaurante> mValues;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items, RestauranteFragment.OnListFragmentInteractionListener myListener) {
        this.mValues = items;
        this.context = context;
        this.myListener = myListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombreView.setText(holder.mItem.getNombre());
        holder.mDireccionView.setText(holder.mItem.getDireccion());
        holder.mValoracionView.setRating(holder.mItem.getValoracion());
        Glide.with(context).load(mValues.get(position).getUrlFoto()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNombreView;
        public final TextView mDireccionView;
        public final RatingBar mValoracionView;
        public final ImageView image;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombreView = view.findViewById(R.id.textViewNombre);
            mDireccionView = view.findViewById(R.id.textView2Direccion);
            image = view.findViewById(R.id.imageView3);
            mValoracionView = view.findViewById(R.id.ratingBar);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNombreView.getText() + "'";
        }
    }
}