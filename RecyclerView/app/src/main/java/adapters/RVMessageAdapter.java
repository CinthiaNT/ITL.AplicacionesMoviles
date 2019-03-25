package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.R;

import org.w3c.dom.Text;

public class RVMessageAdapter extends RecyclerView.Adapter<RVMessageAdapter.RVMessageAdapterViewHolder> {

    private Context context;
    public RVMessageAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RVMessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        View view= LayoutInflater.from(context).inflate(
                R.layout.item_rv_message,
                viewGroup,
                false);
        return new RVMessageAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVMessageAdapterViewHolder rvMessageAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RVMessageAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView tv_username;
        TextView tv_title;
        TextView tv_description;
        TextView tv_hour;
        public RVMessageAdapterViewHolder(View view){
            super(view);

            tv_username = view.findViewById(R.id.tv_username);
            tv_title = view.findViewById(R.id.tv_title);
            tv_description = view.findViewById(R.id.tv_description);
            tv_hour = view.findViewById(R.id.tv_hour);
        }
    }
}
