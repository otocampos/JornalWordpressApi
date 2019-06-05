package br.com.ocdev.jornalwordpressapi.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

import br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Post;
import br.com.ocdev.jornalwordpressapi.R;


//TUTORIAL 


public class RecyclerViewPostsAdapter extends RecyclerView.Adapter<RecyclerViewPostsAdapter.MyViewHolder> {
    private List<Post> data;
    Context context;
    private OnClickNoticia onClickNoticia;


    public interface OnClickNoticia {
        void getDetalhesNoticias(Post article);
    }


    public RecyclerViewPostsAdapter(OnClickNoticia onClickNoticia) {
        this.onClickNoticia = onClickNoticia;
    }


    @NonNull
    @Override
    public RecyclerViewPostsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_view_item_noticias, parent, false);
        context = parent.getContext();


        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPostsAdapter.MyViewHolder holder, int position) {
        final Post post = data.get(position);
        holder.bind(post);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickNoticia.getDetalhesNoticias(data.get(position));


            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.news, obj);
            binding.executePendingBindings();
        }


    }

    public void setCategoriaData(List<Post> data) {
        this.data = data;
    }


}
