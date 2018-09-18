package com.example.camilomontoya.hictio.Misc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.camilomontoya.hictio.AboutActivity;
import com.example.camilomontoya.hictio.ListActivity;
import com.example.camilomontoya.hictio.NavActivity;
import com.example.camilomontoya.hictio.OptionsActivity;
import com.example.camilomontoya.hictio.R;

import java.util.ArrayList;

public class MenuFragment extends Fragment{

    private static final String PARAM1 = "Titulo";
    private static final String PARAM2 = "Tipo";
    private String titulo;
    private int type;

    private ArrayList activityList;

    public MenuFragment() {
        activityList = new ArrayList<>();
        activityList.add(NavActivity.class);
        activityList.add(ListActivity.class);
        activityList.add(OptionsActivity.class);
        activityList.add(AboutActivity.class);
    }

    public static MenuFragment newInstance (String titulo, int type){
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(PARAM1, titulo);
        args.putInt(PARAM2, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            titulo = getArguments().getString(PARAM1);
            type = getArguments().getInt(PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_slide, container, false);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.menu_slide_layout);
        TextView txt = (TextView) v.findViewById(R.id.menu_title);
        txt.setText(titulo);
        txt.setTypeface(Typo.getInstance().getTitle());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), (Class) activityList.get(type)));
            }
        });

        return v;
    }

    public String getTitulo() {
        return titulo;
    }
}
