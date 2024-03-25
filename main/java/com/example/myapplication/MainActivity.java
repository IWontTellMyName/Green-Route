package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter;
    String source, destination;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView=findViewById(R.id.sourceSelector);
        String[] Places= getResources().getStringArray(R.array.Places);
        arrayAdapter=new ArrayAdapter<String>(this, R.layout.list_item, Places);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                source = parent.getItemAtPosition(position).toString();
                System.out.println(source);
            }
        });

        autoCompleteTextView=findViewById(R.id.destinationSelector);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                destination = parent.getItemAtPosition(position).toString();
                System.out.println(destination);



                int len=1302, i, j;
                String routeNo[]=new String[len];
                String via[][]=new String[len][60];
                String img[]=new String[len];
                int ecoScore[]=new int[len];
                String tmp[]=new String[len];
                String[] Routes= getResources().getStringArray(R.array.Routes);
                //for(i=0; i< Routes.length; i++)
                //    System.out.println(Routes[i]);
                for (i=0; i<len; i++)
                {
                    tmp=Routes[i].split(":");
                    routeNo[i]=tmp[0];//.substring(5);
                    img[i]=tmp[4].trim();
                    ecoScore[i]=Integer.parseInt(tmp[5].substring(0, 3).trim());//.split("\"")[0].trim());
                    via[i]=tmp[2].trim().split("\\s*,+\\s*,*\\s*");
                    via[i][via[i].length-1]=via[i][via[i].length-1].split("]")[0];
                    /*System.out.println("\n"+i+"\t"+routeNo[i]+"\t"+ecoScore[i]+"\t"+img[i]);
                    for (j=0; j<via[i].length; j++)
                        System.out.print(via[i][j]+"-->");
                    //if(i==650)	sc.nextLine();*/
                }

                int busArray[]=new int[70], index=0, flag;


                for (i=0; i<len; i++)
                    for (flag=j=0; j<via[i].length; j++)
                        if(flag==0 && via[i][j].equals(source))	flag=1;
                        else if(flag==1 && via[i][j].equals(destination))
                        {
                            busArray[index++]=i;
                            break;
                        }

                for(i=0; i<index; i++)
                    System.out.println(routeNo[busArray[i]]+"\t"+ecoScore[busArray[i]]);
                if(index==0)
                    System.out.println("No direct bus found between the routes");

                List<Item> items=new ArrayList<Item>();
                if(index==0)    items.add(new Item("No direct bus found", 0, 0));
                for(i=0; i<index; i++)
                    items.add(new Item(routeNo[busArray[i]],ecoScore[busArray[i]], 0));


                RecyclerView recyclerView=findViewById(R.id.recyclerview);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));


            }
        });

        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
         */
    }
}