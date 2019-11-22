package com.slab.scientificcalculatorx;



import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Settings extends ListActivity{
    MessagesAndStrings msg = new MessagesAndStrings();

    String[] msgs = msg.list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(Settings.this, android.R.layout.simple_list_item_1, msgs));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String pos = msgs[position];
        AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
        builder.setItems(msg.themeList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences(msg.preferenceTheme, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                switch (which) {
                    case 1:
                        editor.putInt("ThemeID", 1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt("ThemeID", 2);
                        editor.commit();
                        break;
                }
            }
        });
        builder.show();


    }
}

