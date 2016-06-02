package cap.dtx;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LIOWEN on 02/06/2016.
 */
public class Profile extends AppCompatActivity {
    TextView text_first_name, first_name;
    AssetManager assetManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        assetManager        = getAssets();
        text_first_name     = (TextView)findViewById(R.id.text_first_name);
        first_name          = (TextView)findViewById(R.id.first_name);

        first_name.setText(createTestData("testUsers"));

    }

    //#####################//
    // Creates the toolbar //
    //#####################//

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
        if (id == R.id.action_calendar) {
            Intent intent = new Intent(this, Calendar.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_profile) {
            Intent intent = new Intent(this, Profile.class);
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


    //#####################################################//
    //                    -TEST DATA-                      //
    // extracts data from assets file                      //
    // populates hashmap approvedItems                     //
    //#####################################################//

    public String createTestData(String file) {
        InputStream input;
        try {
            input = assetManager.open(file);
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            String text = new String(buffer);
            text.trim();
            text.replace("\n", "");
            return text;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
