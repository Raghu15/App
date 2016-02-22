package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by punit on 19/01/2016.
 */
public class Popup_menu extends AppCompatActivity implements android.widget.PopupMenu.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        button = (Button) findViewById(R.id.btnPopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popmenu = new PopupMenu(Popup_menu.this,button);
                popmenu.setOnMenuItemClickListener(Popup_menu.this);
                popmenu.inflate(R.menu.popup_menu);
                popmenu.show();

            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
      switch (item.getItemId()){
          case R.id.one:
              Toast.makeText(this,"One Clicked",Toast.LENGTH_LONG).show();
              return true;
          case R.id.two:
              Toast.makeText(this,"Two clicked",Toast.LENGTH_LONG).show();
              return true;
      }
        return false;
    }
}