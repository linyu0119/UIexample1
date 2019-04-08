activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <ListView
        android:id="@+id/listView1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></ListView>

    <Button
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/listView1"
        android:layout_marginTop="30dp"
        android:gravity="center"
        android:text="next"

        />
</LinearLayout>

mainactivity
  
  public class MainActivity extends Activity implements OnItemClickListener{
  
    private ListView listview;
    
    private Button nexbut;
    
    int [] imageId = new int[]{R.mipmap.lion,R.mipmap.tiger,R.mipmap.monkey,R.mipmap.dog,R.mipmap.cat,R.mipmap.elephant};
    
    String[] title = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView1);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0;i<imageId.length;i++)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image", imageId[i]);
            map.put("title", title[i]);
            listItems.add(map);
        }
        final SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.items, new String[]{"title","image"},new int[]{R.id.title,R.id.image});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        nexbut = findViewById(R.id.button1);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,

                            long id) {
        if (((ListView)parent).getTag() != null){

            ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);
        }
        ((ListView)parent).setTag(view);
        view.setBackgroundColor(Color.RED);
        switch ( position )
        {
            case 0 : Toast.makeText(this, ""+title[position]+id,
                    Toast.LENGTH_SHORT).show();
                break;
            case 1 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
                break;
            case 2 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
                break;
            case 3 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
                break;
            case 4 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
                break;

            case 5 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
                break;
            default :return;
        }
    }
 }

结果截图：https://github.com/linyu0119/UIexample1/blob/master/app/images/1.png
