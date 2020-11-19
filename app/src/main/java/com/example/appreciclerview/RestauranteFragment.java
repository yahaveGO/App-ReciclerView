package com.example.appreciclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RestauranteFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private RecyclerView recyclerView;
    //private MyRestauranteRecyclerViewAdapter adapterRestaurante;
    private OnListFragmentInteractionListener myListener;
    private List<Restaurante> restauranteList;

    public RestauranteFragment() {
    }

    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restauranteList=new ArrayList<>();
            restauranteList.add(new Restaurante("Mariscos Robbert","https://www.intuxanadu.com/wp-content/uploads/2019/09/que-es-fast-food-gourmet.jpg",4.0f,"Morelos Sur 52,Zitacuaro"));
            restauranteList.add(new Restaurante("La casa de la hamburguesa","https://xto5417wdyi1sj59j35kiadt-wpengine.netdna-ssl.com/wp-content/uploads/2020/06/pollo-comida-americana.jpg",5.0f,"Hidalgo Sur 52,Zitacuaro"));
            restauranteList.add(new Restaurante("Chinesse Food","https://xto5417wdyi1sj59j35kiadt-wpengine.netdna-ssl.com/wp-content/uploads/2020/06/costillas-gastronom%C3%ADa-americana.jpg",4.5f,"Lerdo Sur 52,Zitacuaro"));
            restauranteList.add(new Restaurante("Pizzeria Peter","https://www.thecooksters.com/wp-content/uploads/2019/11/tipos-hamburguesas-1-768x513.png",3.5f,"Miguel Carrilo Sur 52,Zitacuaro"));
            restauranteList.add(new Restaurante("Italinanis Food","https://www.thecooksters.com/wp-content/uploads/2019/11/foie-1.jpg",3.0f,"Ocampo Sur 52,Zitacuaro"));
            recyclerView.setAdapter(new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList, myListener));
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener){
            myListener= (OnListFragmentInteractionListener) context;
        }else{
            throw  new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListener = null;
    }

    public interface OnListFragmentInteractionListener{
        void onListFragmentInteraction(Restaurante restaurante);
    }

}

