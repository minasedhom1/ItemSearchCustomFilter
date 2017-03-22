package com.example.mido.itemsearch;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by mina on 12/01/2017.
 */

public class MyItemAdapter extends ArrayAdapter<Item> implements Filterable{


    Context context;
    List<Item> itemsList;

    public MyItemAdapter(Context context, int resource, List<Item> itemsList) {
        super(context, resource,itemsList);
        this.context= context;
        this.itemsList=itemsList;
    }

    class ViewHolder
        {

            TextView name;

        }
        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
           ViewHolder holder = new ViewHolder();

            try {

                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.listview_association, parent, false);
                    holder.name = (TextView) convertView.findViewById(R.id.item_name_tv);

                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                final Item myItem = itemsList.get(position);

/*------------------------------------set values and action to views----------------------------------------*/
           /*     holder.call.setTypeface(MainActivity.font);
                holder.share.setTypeface(MainActivity.font);
                holder.comment.setTypeface(MainActivity.font);
                holder.menu.setTypeface(MainActivity.font);*/


                holder.name.setText(Html.fromHtml(myItem.getName()));

return  convertView;

            } catch (Exception e) {
                return null;
            }

        }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                ArrayList<Item> tempList=new ArrayList<>();
                //constraint is the result from text you want to filter against.
                //objects is your data set you will filter from
                if(constraint != null && itemsList!=null) {
                    int length=itemsList.size();
                    int i=0;
                    while(i<length){
                        Item item=itemsList.get(i);
                        //do whatever you wanna do here
                        //adding result set output array
                        if(item.getName().contains(constraint))
                           tempList.add(item);

                        i++;
                    }
                    //following two lines is very important
                    //as publish result can only take FilterResults objects
                    filterResults.values = tempList;
                    filterResults.count = tempList.size();
                }
                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence contraint, FilterResults results) {
                itemsList = (ArrayList<Item>) results.values;
                if (results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
}
}

