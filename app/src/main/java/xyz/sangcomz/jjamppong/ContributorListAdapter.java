package xyz.sangcomz.jjamppong;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.sangcomz.jjamppong.databinding.ItemBinding;

/**
 * Created by sangcomz on 05/11/2017.
 */

public class ContributorListAdapter extends RecyclerView.Adapter<ContributorListAdapter.ViewHolder> {

    List<Contributor> contributors = new ArrayList<>();

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item,
                        parent,
                        false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.setView(contributors.get(position));
        holder.bind(contributors.get(position));
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Contributor contributor) {
            binding.setContributor(contributor);
            binding.executePendingBindings();
        }

//        public void setView(Contributor contributor) {
//            Picasso.with(binding.profile.getContext())
//                    .load(contributor.avatar_url)
//                    .placeholder(R.mipmap.ic_launcher_round)
//                    .fit()
//                    .centerCrop()
//                    .into(binding.profile);
//
//            binding.name.setText(contributor.login);
//        }
    }
}
