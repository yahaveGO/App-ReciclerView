package com.example.appreciclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements RestauranteFragment.OnListFragmentInteractionListener{
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestauranteFragment lista = new RestauranteFragment(this);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenedor, lista, "rf");
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Restaurante restaurante) {
        Bundle parametros = new Bundle();
        parametros.putString("sitioWeb", restaurante.getUrl());
        FragmentoPaginaRestaurante fragmentoPagina = new FragmentoPaginaRestaurante();
        fragmentoPagina.setArguments(parametros);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contenedor, fragmentoPagina);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}