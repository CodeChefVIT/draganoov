package android.gaurav.com.medtraceadmin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;

import java.sql.Time;
import java.util.ArrayList;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackListViewHolder> {

    ArrayList<TrackClass> itemList;

    public TrackListAdapter(ArrayList<TrackClass> listItem)
    {
        this.itemList = listItem;
    }

    @NonNull
    @Override
    public TrackListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rootView = inflater.inflate(R.layout.track_list_item,viewGroup,false);
        return new TrackListViewHolder(rootView,i);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackListViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.time.setText(itemList.get(position).getTimestamp());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class TrackListViewHolder extends RecyclerView.ViewHolder{

        TextView time, name, latitude, longitude;
        TimelineView timelineView;

        public TrackListViewHolder(@NonNull View rootView, int viewType) {
            super(rootView);

            time = rootView.findViewById(R.id.time);
            name = rootView.findViewById(R.id.name);
            latitude = rootView.findViewById(R.id.latitude);
            longitude = rootView.findViewById(R.id.longitude);
            timelineView = rootView.findViewById(R.id.timeline);

            timelineView.initLine(viewType);

        }
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }
}
