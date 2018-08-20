package eu.artouch.todoapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.artouch.todoapp.R;
import eu.artouch.todoapp.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private final Context context;
    private final List<Todo> todos;
    private final LayoutInflater inflater;

    public TodoAdapter(Context context, List<Todo> todos) {
        this.context = context;
        this.todos = todos;
        this.inflater=LayoutInflater.from(context);
    }

    /**
     * Meghívja ha létre kell hozni za egyes felületi elemeket
     * @param parent
     * @param viewType Megadható, hogy miyen típusu elemeket használjon
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.li_todo,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * Meghívja ha Újra-Használja az elemet és adatokat tölt bele
     * A lehető legkevesebb hívást kell bele tenni, ha "megrántjuk" a legörgetést több 10szer lefuthat
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.titleTV.setText(todo.getTitlr());
        holder.assigneeTV.setText("Felelős: "+todo.getAssignee());
        holder.descriptionTV.setText(todo.getDescription());
        Log.d("ViewHolder", "Id: " + position);
    }

    /**
     * A lista összes elemének darabszáma
     * @return
     */
    @Override
    public int getItemCount() {
        return todos.size();
    }

    /**
     * Ezzel az osztályal tudja megoldani a nézetek újra használatát
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleTV;
        public final TextView descriptionTV;
        public final TextView assigneeTV;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            assigneeTV = itemView.findViewById(R.id.assigneeTV);
        }
    }
}
