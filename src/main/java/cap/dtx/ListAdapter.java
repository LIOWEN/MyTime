package cap.dtx;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by LIOWEN on 04/04/2016.
 */
public class ListAdapter extends BaseAdapter {
    private final ArrayList mData;
    //CheckBox checkBox;

    public ListAdapter(Map<String, String> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, String> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public int getViewTypeCount() {

        if (getCount() != 0)
            return getCount();

        return 1;
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, String> item = getItem(position);
        String[] pairs = item.getKey().split("\\s");
        final String projCode = pairs[0] + " " + pairs[1] + " " + pairs[2];
        String fullDate = pairs[3];

        ((TextView) result.findViewById(android.R.id.text1)).setText(projCode);
        ((TextView) result.findViewById(android.R.id.text1)).setTextColor(Color.parseColor("#FF0D0F4B"));
        ((TextView) result.findViewById(android.R.id.text2)).setText(fullDate);
        ((TextView) result.findViewById(android.R.id.text2)).setTextColor(Color.parseColor("#FF0D0F4B"));
        ((TextView) result.findViewById(android.R.id.checkbox)).setText(item.getValue());
        ((TextView) result.findViewById(android.R.id.checkbox)).setTextColor(Color.parseColor("#FF0D0F4B"));


        if(Approvals.checkedItems.contains(projCode + " " +fullDate)){
            result.setBackgroundColor(Color.parseColor("#01528E"));
        }
        else {
            result.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }


        for (int i = 0; i < Approvals.approvedItems.size(); i++) {
            if(item.getValue().equals("rejected")){
                //result.set(Color.parseColor("#960018"));
                ((TextView) result.findViewById(android.R.id.text1)).setTextColor(Color.parseColor("#960018"));
                ((TextView) result.findViewById(android.R.id.checkbox)).setTextColor(Color.parseColor("#960018"));
                ((TextView) result.findViewById(android.R.id.text2)).setTextColor(Color.parseColor("#960018"));

            }
        }

        return result;
    }
}


