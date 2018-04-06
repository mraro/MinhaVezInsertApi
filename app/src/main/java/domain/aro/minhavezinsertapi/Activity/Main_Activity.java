package domain.aro.minhavezinsertapi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import domain.aro.minhavezinsertapi.Adapters.RecyclerView_Adapter;
import domain.aro.minhavezinsertapi.Model.Narutinho;
import domain.aro.minhavezinsertapi.R;

public class Main_Activity extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/fethica/UITableViewJSON/gh-pages/characters.json\n";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Narutinho> lstNarutinho;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        lstNarutinho = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleview_id);
        jsonRequest();
    }

    private void jsonRequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Narutinho narutinho = new Narutinho();
                        narutinho.setName(jsonObject.getString("name"));
                        narutinho.setDescription(jsonObject.getString("description"));
                        narutinho.setImage(jsonObject.getString("photo"));
                        narutinho.setThumbnail(jsonObject.getString("thumbnail"));
                        lstNarutinho.add(narutinho);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecycleview(lstNarutinho);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(Main_Activity.this);
        requestQueue.add(request);

    }

    private void setuprecycleview(List<Narutinho> lstNarutinho) {
        RecyclerView_Adapter myadpter = new RecyclerView_Adapter(this,lstNarutinho);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadpter);
    }
}
