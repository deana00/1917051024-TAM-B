package com.tam.praktikum5.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<President> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(PresidentData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
        listPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(listPresidentAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
        cardViewPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        private void setActionBarTitle(String title) {
            getSupportActionBar().setTitle(title);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_list:
                    setActionBarTitle("Mode List");
                    showRecyclerList();
                    break;
                case R.id.action_grid:
                    setActionBarTitle("Mode Grid");
                    showRecyclerGrid();
                    break;

                case R.id.action_cardview:
                    setActionBarTitle("Mode Cardview");
                    showRecyclerCardView();
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

    private void showSelectedPresident(President president) {
        Toast.makeText(this, "Kamu memilih " + president.getName(), Toast.LENGTH_SHORT).show();
    }

//    SAVED INSTANCE STATE
//    private RecyclerView rvCategory;
//    private ArrayList<President> list = new ArrayList<>();
//    final String STATE_TITLE = "state_string";
//    final String STATE_LIST = "state_list";
//    final String STATE_MODE = "state_mode";
//    int mode;

//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        rvCategory = findViewById(R.id.rv_category);
//        rvCategory.setHasFixedSize(true);
//
//        list = new ArrayList<>();
//
//        if (savedInstanceState == null) {
//            setActionBarTitle("Mode List");
//            list.addAll(PresidentData.getListData());
//            showRecylerList();
//            mode = R.id.action_list;
//        } else {
//            String stateTitle = savedInstanceState.getString(STATE_TITLE);
//            ArrayList<President> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
//            int stateMode = savedInstanceState.getInt(STATE_MODE);
//            setActionBarTitle(stateTitle);
//            list.addAll(stateList);
//            setMode(stateMode);
//        }
//    }
//
//    private void showSelectedPresident(President president) {
//        Toast.makeText(this, "Kamu memilih " + president.getName(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public void setMode(int selectedMode) {
//        String title = null;
//        switch (selectedMode) {
//            case R.id.action_list:
//                title = "Mode List";
//                showRecylerList();
//                break;
//
//            case R.id.action_grid:
//                title = "Mode Grid";
//                showRecyclerGrid();
//                break;
//
//            case R.id.action_cardview:
//                title = "Mode Cardview";
//                showRecyclerCardView();
//                break;
//        }
//        mode = selectedMode;
//        setActionBarTitle(title);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        setMode(item.getItemId());
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
//        outState.putParcelableArrayList(STATE_LIST, (ArrayList<? extends Parcelable>) list);
//        outState.putInt(STATE_MODE, mode);
//    }
//
//    private void showRecylerList() {
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
//        listPresidentAdapter.setListPresident(list);
//        rvCategory.setAdapter(listPresidentAdapter);
//
//        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                showSelectedPresident(list.get(position));
//            }
//        });
//    }
//
//    private void showRecyclerGrid() {
//        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
//        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
//        gridPresidentAdapter.setListPresident(list);
//        rvCategory.setAdapter(gridPresidentAdapter);
//
//        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                showSelectedPresident(list.get(position));
//            }
//        });
//    }
//
//    private void showRecyclerCardView() {
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
//        cardViewPresidentAdapter.setListPresident(list);
//        rvCategory.setAdapter(cardViewPresidentAdapter);
//    }
//
//    private void setActionBarTitle(String title) {
//        getSupportActionBar().setTitle(title);
//    }
}