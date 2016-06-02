package cap.dtx;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by decparnell on 27/05/2016.
 */
public class Holidays extends AppCompatActivity {

    ArrayList<String> months;
    Spinner monthSelector;
    HashMap<String,String> selectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.holiday_page);

        selectedItems = new HashMap<String, String>();
        monthSelector = (Spinner)findViewById(R.id.monthSelector);
        months = new ArrayList<String>();

        months.add("Month");
        months.add("January");months.add("February");months.add("March");months.add("April");months.add("May");months.add("June");
        months.add("July");months.add("August");months.add("September");months.add("October");months.add("November");months.add("December");



        //##########################################//
        // Handles what is selected in the spinners //
        //##########################################//

        monthSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

                                                {
                                                    @Override
                                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                        selectedItems.put("Month", monthSelector.getItemAtPosition(position).toString());
                                                    }

                                                    @Override
                                                    public void onNothingSelected(AdapterView<?> parent) {

                                                    }
                                                }

        );
/**
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(projectCode.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(), "Please select a project code"
                            ,Toast.LENGTH_SHORT).show();
                }
                else if(taskNum.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(), "Please select a task number"
                            ,Toast.LENGTH_SHORT).show();
                }
                else if(selectedItems.get("Type").equals("Type")){
                    Toast.makeText(getBaseContext(), "Please select a type"
                            ,Toast.LENGTH_SHORT).show();
                }
                else if(days.size() == 0){
                    Toast.makeText(getBaseContext(), "Please select days to book"
                            ,Toast.LENGTH_SHORT).show();
                }
                else {

                    String date = "";
                    for(int i = 0; i < days.size(); i++){
                        date += (i+1) + ") "+ days.get(i) + "\n";
                    }
                    selectedItems.put("Date", date);
                    selectedItems.put("Task Number", taskNum.getText().toString());
                    selectedItems.put("Project Code", projectCode.getText().toString());
                    selectedItems.put("Comment", comment.getText().toString());

                    String s = "";
                    Iterator it = selectedItems.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        s += pair.getKey() + ": " + pair.getValue() + "\n";
                    }
                    //will populate sql table instead of making a toast
                    Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();

                    Toast.makeText(getBaseContext(), "Time successfully booked", Toast.LENGTH_SHORT).show();
                    toMainActivity();


                }
            }
        });

 */
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months );
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSelector.setAdapter(typeAdapter);
    }

    //#####################//
    // Creates the toolbar //
    //#####################//

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_calendar) {
            Intent intent = new Intent(this, Calendar.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.booking) {
            Intent intent = new Intent(this, Booking.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.holidays) {
            Intent intent = new Intent(this, Holidays.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.approvals) {
            Intent intent = new Intent(this, Approvals.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.settings) {
            Toast.makeText(getBaseContext(), "To be added?", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

