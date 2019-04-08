package com.example.example1;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            //将map对象添加到List集合
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
            //根据position的值显示title数组中的内容
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
