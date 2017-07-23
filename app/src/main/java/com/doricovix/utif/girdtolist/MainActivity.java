package com.doricovix.utif.girdtolist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubGird, stubList;
    private ListView lv_dash;
    private GridView gv_dash;
    private DashGirdAdapter girdAdapter;
    private DashListAdapter listAdapter;
    private List<ItemMhs> itemMhs;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private int defaultViewMode = 0;

    private final static int LIST_VIEW_MODE = 1;
    private final static int GRID_VIEW_MODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubGird = (ViewStub) findViewById(R.id.stub_gird);
        stubList = (ViewStub) findViewById(R.id.stub_list);

        lv_dash = (ListView) findViewById(R.id.lv_dash);
        gv_dash = (GridView) findViewById(R.id.gv_dash);

        pref = getSharedPreferences("view_mode", MODE_PRIVATE);
        defaultViewMode = pref.getInt("default_view_mode", GRID_VIEW_MODE);

        getMhsList();
        switchView();

        lv_dash.setOnItemClickListener(onItemClick);
        gv_dash.setOnItemClickListener(onItemClick);
    }


    private void switchView() {

        if(GRID_VIEW_MODE == defaultViewMode) {
            stubList.setVisibility(View.VISIBLE);
            stubGird.setVisibility(View.GONE);
        } else {
            stubList.setVisibility(View.GONE);
            stubGird.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    private void setAdapters() {
        if(GRID_VIEW_MODE == defaultViewMode) {
            girdAdapter = new DashGirdAdapter(this, R.layout.dash_gird_item, itemMhs);
            gv_dash.setAdapter(girdAdapter);
        } else {
            listAdapter = new DashListAdapter(this, R.layout.dash_list_item, itemMhs);
            lv_dash.setAdapter(listAdapter);
        }
    }

    public List<ItemMhs> getMhsList() {
        //pseudo code to get ItemMhs(), replace your code to get real ItemMhs() here
        itemMhs = new ArrayList<>();
        itemMhs.add(new ItemMhs("This is description 1", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 2", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 3", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 4", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 5", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 6", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 7", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 8", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 9", R.drawable.icon_android));
        itemMhs.add(new ItemMhs("This is description 10", R.drawable.icon_android));

        return itemMhs;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do any thing when user click to item
            Toast.makeText(getApplicationContext(), itemMhs.get(position).getNm_mhs() + " - " + itemMhs.get(position).getFt_mhs(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dash_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.dash_action_switch:
                doSwitching();
                break;
        }
        return true;
    }

    private void doSwitching() {
        if (GRID_VIEW_MODE == defaultViewMode){
            defaultViewMode = LIST_VIEW_MODE;
        }else{
            defaultViewMode = GRID_VIEW_MODE;
        }

        switchView();
        pref = getSharedPreferences("view_mode", MODE_PRIVATE);
        editor.putInt("defaultViewMode", defaultViewMode);
        editor.commit();
    }
}
