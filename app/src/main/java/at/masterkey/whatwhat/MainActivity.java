package at.masterkey.whatwhat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener{

    private RecyclerView myRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);

        myRecyclerViewAdapter = new RecyclerViewAdapter(this);
        myRecyclerViewAdapter.setOnItemClickListener(this);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        findViewById(R.id.activity_main_fab_add).setOnClickListener(new View.OnClickListener() {
            int i = 1;
            @Override
            public void onClick(View v) {
                myRecyclerViewAdapter.add(2 + i, "3. " + String.valueOf(i));
                i++;
            }
        });

        //insert dummy items
        myRecyclerViewAdapter.add(0, "15");
        myRecyclerViewAdapter.add(0, "14");
        myRecyclerViewAdapter.add(0, "13");
        myRecyclerViewAdapter.add(0, "12");
        myRecyclerViewAdapter.add(0, "11");
        myRecyclerViewAdapter.add(0, "10");
        myRecyclerViewAdapter.add(0, "9");
        myRecyclerViewAdapter.add(0, "8");
        myRecyclerViewAdapter.add(0, "7");
        myRecyclerViewAdapter.add(0, "6");
        myRecyclerViewAdapter.add(0, "5");
        myRecyclerViewAdapter.add(0, "4");
        myRecyclerViewAdapter.add(0, "3");
        myRecyclerViewAdapter.add(0, "2");
        myRecyclerViewAdapter.add(0, "1");
        myRecyclerViewAdapter.add(0, "0");
    }

    @Override
    public void onItemClick(RecyclerViewAdapter.ItemHolder item, int position) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = item.getTitle().toString();
        if(title.equals(getString(R.string.layout_linear_vert))) {
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } else if(title.equals(getString(R.string.layout_linear_hor))) {
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        } else if(title.equals(getString(R.string.layout_grid_vert))) {
            myRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        } else if(title.equals(getString(R.string.layout_grid_hor))) {
            myRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
        }
        myRecyclerView.requestLayout();

        return true;
    }
}
