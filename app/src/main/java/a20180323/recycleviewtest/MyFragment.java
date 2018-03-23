package a20180323.recycleviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by WHY on 2018/3/23.
 */

public class MyFragment extends Fragment {
    private static final String TAG = "---MyFragment";
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        mRecyclerView = (RecyclerView)inflater.inflate(R.layout.recycle_layout,container,false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
       // Log.d(TAG,"mRecyclerView:"+mRecyclerView);
      //  Log.d(TAG,"find:"+mRecyclerView.findViewById(R.id.recycle_layout));
        DataProvider dataProvider = new DataProvider();
        dataProvider.initData(100);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(dataProvider.getData());
        mRecyclerView.setAdapter(adapter);
        return mRecyclerView;
    }

    private class MyRecyclerViewHolder extends RecyclerView.ViewHolder{

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
        }

    }
    private class MyRecyclerViewAdapter extends RecyclerView.Adapter{
        TextView mString;
        TextView mOject;
        ArrayList<Map<String, Object>> mList;
        MyRecyclerViewAdapter(ArrayList<Map<String,Object>> list){
            mList = list;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder() called with: parent = [" + parent + "], viewType = [" + viewType + "]");
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.recycle_item_layout,parent,false);
            MyRecyclerViewHolder holder = new MyRecyclerViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "]");
            mString = holder.itemView.findViewById(R.id.item_string);
            mOject  = holder.itemView.findViewById(R.id.item_object);
            mString.setText(mList.get(position).get("String").toString());
            mOject.setText(mList.get(position).get("Object").toString());
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount() called");
            return mList.size();
        }
    }
}
