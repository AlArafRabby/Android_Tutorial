package tutorial.android.android_tutorial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class tutorial extends AppCompatActivity {

    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter1 listAdapter;
    private ExpandableListView simpleExpandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        final MediaPlayer mp =MediaPlayer.create(this,R.raw.click);
        loadData();
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter1(tutorial.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
        //expandAll();

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                if(groupPosition==0&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),What_is_android.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==0&&childPosition==1)
                {
                    Intent intent = new Intent(getApplicationContext(),History.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==0&&childPosition==2)
                {
                    Intent intent = new Intent(getApplicationContext(),architecture.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==0&&childPosition==3)
                {
                    Intent intent = new Intent(getApplicationContext(),emulator.class);
                    startActivity(intent);
                    mp.start();
                }

                else if(groupPosition==1&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),widgets.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==1&&childPosition==1)
                {
                    Intent intent = new Intent(getApplicationContext(),toast.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==1&&childPosition==2)
                {
                    Intent intent = new Intent(getApplicationContext(),spinner.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==1&&childPosition==3)
                {
                    Intent intent = new Intent(getApplicationContext(),ratingbar.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==1&&childPosition==4)
                {
                    Intent intent = new Intent(getApplicationContext(),progress.class);
                    startActivity(intent);
                    mp.start();
                }

                else if(groupPosition==2&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),activity.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==2&&childPosition==1)
                {
                    Intent intent = new Intent(getApplicationContext(),startactivity.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==3&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),optionmenu.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==3&&childPosition==1)
                {
                    Intent intent = new Intent(getApplicationContext(),context.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==3&&childPosition==2)
                {
                    Intent intent = new Intent(getApplicationContext(),popup.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==4&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),sqlite_tutorial_example.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==5&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),service.class);
                    startActivity(intent);
                    mp.start();
                }

                else if(groupPosition==6&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),graphic.class);
                    startActivity(intent);
                    mp.start();
                }
                else if(groupPosition==7&&childPosition==0)
                {
                    Intent intent = new Intent(getApplicationContext(),web.class);
                    startActivity(intent);
                    mp.start();
                }
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it
                Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
                        Toast.LENGTH_LONG).show();
                mp.start();

                return false;
            }
        });


    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.collapseGroup(i);
        }
    }

    //load some initial data into out list
    private void loadData(){

        addProduct("Basic of Android","What is Android?");
        addProduct("Basic of Android","History & Vertion");
        addProduct("Basic of Android","Android Architecture");
        addProduct("Basic of Android","Android Emulator");

        addProduct("UI Widgates","UI Wiggets");
        addProduct("UI Widgates","Toast");
        addProduct("UI Widgates","Spinner");
        addProduct("UI Widgates","RatingBar");
        addProduct("UI Widgates","ProgressBar");

        addProduct("Activity and\nIntent","Activity LifeCycle");
        addProduct("Activity and\nIntent","StartActivity For Result");

        addProduct("Android Menu","Option menu");
        addProduct("Android Menu","Context menu");
        addProduct("Android Menu","Pop up menu");



        addProduct("SQLite\nDatabases","SQLite Tutorial and Example");

        addProduct("Android Services","Android Services");

        addProduct("Android Graphic","Android Graphic");

        addProduct("Android Web\nService","Android Web Service");

    }

    private int addProduct(String department, String product){

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
}
class GroupInfo {

    private String name;
    private ArrayList<ChildInfo> list = new ArrayList<ChildInfo>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildInfo> getProductList() {
        return list;
    }

    public void setProductList(ArrayList<ChildInfo> productList) {
        this.list = productList;
    }

}
class ChildInfo {

    private String sequence = "";
    private String name = "";

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

