package pub.com.mypub.admin;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import pub.com.mypub.R;
import pub.com.mypub.admin.models.Category;
import pub.com.mypub.admin.models.Language;
import pub.com.mypub.admin.models.Specialist;
import pub.com.mypub.admin.models.Ticket;
import pub.com.mypub.home.RecycleItemClickListener;


public class CategoryCustomAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    RecycleItemClickListener mListener;
    public ArrayList<Category> mCategoryList ;
    public CategoryCustomAdapter(ArrayList<Category> category) {
        mCategoryList = category;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_info, viewGroup, false);
        CategoryViewHolder dateobject = new CategoryViewHolder(itemView, this);
        dateobject.ch1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox ch1 = (CheckBox) v ;
                Category category=(Category) ch1.getTag();
                category.setSelected(ch1.isChecked());

            }
        });
        return dateobject;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
       Category category= mCategoryList.get(i);
        categoryViewHolder.ch1.setText(category.name);
        categoryViewHolder.ch1.setChecked(category.isSelected());
        categoryViewHolder.ch1.setTag(category);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
