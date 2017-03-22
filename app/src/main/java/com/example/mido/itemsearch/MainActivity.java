package com.example.mido.itemsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
JSONArray jsonArray;
    JSONObject jsonObject;
 ArrayList<Item> itemArrayList ;
ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String > names;
    MyItemAdapter myItemAdapter;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.items_name_list);
            editText= (EditText) findViewById(R.id.search_et);
         names= new ArrayList<>();
        itemArrayList=new ArrayList<>();
        String url="http://sodicservice.azurewebsites.net/sodic/Item/GetAllActiveItems/GetAll";
        StringRequest request=new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JsonElement root=new JsonParser().parse(response);
                    response = root.getAsString();
                     jsonObject=new JSONObject(response);
                    jsonArray=jsonObject.getJSONArray("ItemsList");
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        jsonObject = jsonArray.getJSONObject(i);
                        Item item=new Item();
                        item.setId(jsonObject.getString("ItemID"));
                        item.setName(jsonObject.getString("Name_En"));
                        item.setDescription(jsonObject.getString("Description_En"));
                        itemArrayList.add(item);
                        names.add(Html.fromHtml(jsonObject.getString("Name_En")).toString());
                    }
            /*        itemArrayList.size();*/
                    myItemAdapter=new MyItemAdapter(MainActivity.this,android.R.layout.simple_list_item_1,itemArrayList);
                    listView.setAdapter(myItemAdapter);

                    //  itemAdapter=new MyCustomListAdapter(getContext(),android.R.layout.simple_list_item_1,R.id.name2_tv,itemArrayList);
                    //  itemAdapter.setNotifyOnChange(true);
                /*   adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,names);
                    listView.setAdapter(adapter);*/
                }   catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();            }
        });
       request.setRetryPolicy(new DefaultRetryPolicy(
                20000,
               DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                myItemAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}
