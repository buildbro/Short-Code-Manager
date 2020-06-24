package com.example.shortcodemanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shortcodemanager.model.Code;

import java.util.List;

public class CodeRecyclerViewAdapter extends RecyclerView.Adapter<CodeRecyclerViewAdapter.CodeViewHolder> {

    List<Code> mCodes;
    RecyclerViewClickListener mListener;

    public CodeRecyclerViewAdapter(RecyclerViewClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public CodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CodeViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CodeViewHolder holder, int position) {
        Code code = mCodes.get(position);
        holder.titleTextView.setText(code.getTitle());
        holder.codeTextView.setText(code.getCode());
    }

    @Override
    public int getItemCount() {
        if (mCodes != null) {
            return mCodes.size();
        } else {
            return 0;
        }
    }

    public void setCodes(List<Code> codes) {
        this.mCodes = codes;
        notifyDataSetChanged();
    }

    public class CodeViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, codeTextView;
        ImageView phoneIcon, deleteIcon;

        public CodeViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            codeTextView = itemView.findViewById(R.id.code_text_view);
            phoneIcon = itemView.findViewById(R.id.phone_ico);
            deleteIcon = itemView.findViewById(R.id.delete_ico);

            phoneIcon.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onViewClicked(view, getAdapterPosition());
                }
            });

            deleteIcon.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onViewClicked(view, getAdapterPosition());
                }
            });
        }
    }
}
