package com.example.numberseriesgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.numberseriesgame.databinding.CustumLayoutGameBinding;

import java.util.ArrayList;

public class Gameadubture extends RecyclerView.Adapter<Gameadubture.Gameholder> {

        private ArrayList<Database_newGame> gamer;
    private Context context;

    public Gameadubture(ArrayList<Database_newGame> gamer, Context context) {
        this.gamer = gamer;
        this.context = context;
    }

    @NonNull
    @Override
    public Gameholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustumLayoutGameBinding binding =
                CustumLayoutGameBinding.inflate(LayoutInflater.from(context));

        return new Gameholder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull Gameholder holder, int position) {
        Database_newGame c=gamer.get(position);
        holder.binding.txtFullname.setText(c.getName());
        holder.binding.txtTimeadtae.setText(c.getTime_date());
        holder.binding.txtScore.setText(String.valueOf(c.getScore()));

    }

    @Override
    public int getItemCount() {
        return gamer.size();
    }



    class Gameholder extends RecyclerView.ViewHolder {
        CustumLayoutGameBinding binding;

        public Gameholder(@NonNull View itemView) {
            super(itemView);
            binding=CustumLayoutGameBinding.bind(itemView);
        }
    }

}





































//    public Gameadubture(ArrayList<Data> gamer, Context context) {
//        this.gamer = gamer;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return gamer.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//CustumLayoutGameBinding binding;
//        if (convertView==null){
//
//    binding=CustumLayoutGameBinding.inflate(LayoutInflater.from(context));
//    }
//        else {
//            binding=CustumLayoutGameBinding.bind(convertView);
//
//        }
//
//        Data c=gamer.get(position);
//
//        binding.txtFullname.setText(c.getName());
//        binding.txtScore.setText(String.valueOf(c.getScore()));
//        binding.txtTimeadtae.setText(String.valueOf(c.getTime_date()));
//
//        return binding.getRoot();
//
//        }
//    }
//
//    private ArrayList<Data> list;
//   private Context context;
//
//
//    @NonNull
//    @Override
//    public Recview_holder_games onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new Recview_holder_games(LayoutInflater.from(parent.getContext())
//        .inflate(R.layout.custum_layout_game,parent,false));
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Recview_holder_games holder, int position) {
//                Data d =list.get(position);
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//
//static class Recview_holder_games extends RecyclerView.ViewHolder{
//        CustumLayoutGameBinding binding;
//        Data data;
//        private Object object;
//
//        public Recview_holder_games(@NonNull View itemView){
//            super(itemView);
//            binding = CustumLayoutGameBinding.bind(itemView);
//        }
//        void data1(Data data){
//            binding.txtFullname.setText(data.getName());
//                binding.txtTimeadtae.setText(data.getTime_date());
//            binding.txtScore.setText(data.getScore());
//        }


