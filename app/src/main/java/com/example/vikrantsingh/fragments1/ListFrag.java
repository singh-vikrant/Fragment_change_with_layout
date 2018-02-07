package com.example.vikrantsingh.fragments1;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {
private ClassListener cl;

    public ListFrag() {
        // Required empty public constructor

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,getResources()
                .getStringArray(R.array.days)));
    if(this.getActivity().findViewById(R.id.layout_default)==null)
    {cl.ClassListen(0);}
    }

    public interface ClassListener{
        public void ClassListen(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            cl = (ClassListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement the interface ClassListener");
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

            cl.ClassListen(position);

    }
}
