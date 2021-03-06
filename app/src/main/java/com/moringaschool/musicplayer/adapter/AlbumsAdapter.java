package com.moringaschool.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.musicplayer.PlayerActivity;
import com.moringaschool.musicplayer.R;

import com.moringaschool.musicplayer.models.Item;
import com.moringaschool.musicplayer.models.Snippet;
import com.squareup.picasso.Picasso;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>{
    private Context mcontext;
    private List<Item> mArtists;

    public AlbumsAdapter(Context context,List<Item> artists){
        mcontext = context;
        mArtists = artists;

    }

    public  class AlbumsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleTextView) TextView mTittleTextView;
        @BindView(R.id.artistNameView) TextView mArtistName;
        @BindView(R.id.alumLink) TextView mAlbumLink;
        @BindView(R.id.albumImageView) ImageView mCoverImage;

        private Context mContext;


        public AlbumsViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext= itemView.getContext();

        }

        public  void bindAlbums(Item artist){


            mArtistName.setText(artist.getSnippet().getTitle());
            mTittleTextView.setText(artist.getSnippet().getChannelTitle());
            mAlbumLink.setText(artist.getSnippet().getDescription());
//            mCoverImage.setText(artist.getSnippet().getThumbnails().getMedium().getUrl());
            Picasso.get().load(artist.getSnippet().getThumbnails().getMedium().getUrl()).into(mCoverImage);









        }

    }
    @Override
    public  int getItemCount(){
        System.out.println(mArtists.size());
        return mArtists.size();


    }

    @Override
    public AlbumsAdapter.AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_raw,parent,false);
            AlbumsViewHolder viewHolder = new AlbumsViewHolder(view);

            return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsAdapter.AlbumsViewHolder holder, int position){
        holder.bindAlbums(mArtists.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayerActivity.class);


                intent.putExtra("song",holder.mTittleTextView.getText().toString());
                intent.putExtra("link",holder.mAlbumLink.getText().toString());
                intent.putExtra("artist",holder.mArtistName.getText().toString());
//                intent.putExtra(" cover_image",holder.mCoverImage.getText().toString());


                view.getContext().startActivity(intent);


            }
        });


    }


}
