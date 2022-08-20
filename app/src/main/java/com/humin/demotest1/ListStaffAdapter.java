package com.humin.demotest1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListStaffAdapter extends RecyclerView.Adapter<ListStaffAdapter.ViewHolder> {

    private ArrayList<Staff> listStaff = new ArrayList<>();
    private Context mContext;

    public ListStaffAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Staff> getListStaff() {
        return listStaff;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setListStaff(ArrayList<Staff> listStaff) {
        this.listStaff = listStaff;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_staff_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return listStaff.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvBirthday, tvDes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_staff);
            tvBirthday = itemView.findViewById(R.id.tv_birthday_staff);
            tvDes = itemView.findViewById(R.id.tv_description_staff);
        }

        @SuppressLint("SetTextI18n")
        public void onBind(int position) {
            if (listStaff.isEmpty()) return;
            Staff staff = listStaff.get(position);
            tvName.setText(staff.getNameStaff());
            tvBirthday.setText(staff.getBirthdayStaff());
            tvDes.setText(staff.getIdDepartment() + "");
        }
    }
}
