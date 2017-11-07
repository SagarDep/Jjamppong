package xyz.sangcomz.jjamppong;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by seokwon.jeong on 07/11/2017.
 */

public class ListBindingAdapter {

    @android.databinding.BindingAdapter({"imgUrlLoad"})
    public static void imgUrlLoad(CircleImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .fit()
                .centerCrop()
                .into(view);
    }

    public void onClickItem(View view, Contributor contributor) {
        new AlertDialog.Builder(view.getContext())
                .setTitle("Contributor")
                .setMessage(contributor.login)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}
