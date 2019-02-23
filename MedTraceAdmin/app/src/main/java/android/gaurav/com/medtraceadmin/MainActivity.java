package android.gaurav.com.medtraceadmin;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;
    int req_code = 100;

    TrackListAdapter trackListAdapter;

    ArrayList<TrackClass> trackList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_button);
        recyclerView = findViewById(R.id.recyler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        trackList = new ArrayList<TrackClass>();

        //Sample Data
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        trackList.add(new TrackClass("23 Jan, 05:24PM","KRF Retails",54545.54,87845.49));
        //Sample data Ends

        //Setting the adapter
        trackListAdapter = new TrackListAdapter(trackList);
        recyclerView.setAdapter(trackListAdapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Scanner.class),req_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == req_code && resultCode == RESULT_OK)
        {
            if(data!=null)
            {
                Barcode barcode = data.getParcelableExtra("barcode");
                Log.e("barcode",barcode.displayValue);

                //API Calling here

            }
        }
    }
}
