package proba.vjezbanje.android.dagger2mvpretrofit2test;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hr.sil.android.dagger2mvpretrofit2test.R;
import proba.vjezbanje.android.dagger2mvpretrofit2test.pojo.CountryData;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<CountryData> data;
    private RecyclerViewAdapter.ClickListener clickListener;

    @Inject
    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(data.get(position).name);
        holder.txtRegion.setText(data.get(position).region);
        holder.txtSubRegion.setText("Subregion: " + data.get(position).subregion);
        holder.txtCapital.setText(data.get(position).capital);
        holder.txtAlpha2Code.setText(data.get(position).alpha2Code);
        holder.txtAlpha3Code.setText(data.get(position).alpha3Code);
        holder.txtPopulation.setText("Population: " + data.get(position).population);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtAlpha2Code;
        private TextView txtAlpha3Code;
        private TextView txtRegion;
        private TextView txtSubRegion;
        private TextView txtCapital;
        private TextView txtPopulation;
        private ConstraintLayout constraintLayoutContainer;

        ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtAlpha2Code = itemView.findViewById(R.id.txtAlpha2Code);
            txtAlpha3Code = itemView.findViewById(R.id.txtAlpha3Code);
            txtRegion = itemView.findViewById(R.id.txtRegion);
            txtSubRegion = itemView.findViewById(R.id.txtSubRegion);
            txtCapital = itemView.findViewById(R.id.txtCapital);
            txtPopulation = itemView.findViewById(R.id.txtPopulation);
            constraintLayoutContainer = itemView.findViewById(R.id.constraintLayout);

            constraintLayoutContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.launchIntent(data.get(getAdapterPosition()).name);
                }
            });
        }
    }

    public interface ClickListener {
        void launchIntent(String name);
    }

    public void setData(List<CountryData> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}

