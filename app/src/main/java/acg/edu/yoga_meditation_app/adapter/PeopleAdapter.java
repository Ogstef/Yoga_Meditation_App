package acg.edu.yoga_meditation_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import acg.edu.yoga_meditation_app.R;
import java.util.List;
import acg.edu.yoga_meditation_app.models.Person;

public class PeopleAdapter extends BaseAdapter {
    private Context context;
    private List<Person> people;

    public PeopleAdapter(Context context, List<Person> people) {
        this.context = context;
        this.people = people;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int position) {
        return people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.person_adapter_layout, parent, false);
        }

        Person person = (Person) getItem(position);
        ((TextView) convertView.findViewById(R.id.name)).setText(person.getName());
        ((TextView) convertView.findViewById(R.id.surname)).setText(person.getSurname());
        ImageView gender = convertView.findViewById(R.id.gender);
        switch (person.getGender()) {
            case "Male":
                gender.setImageResource(R.mipmap.male);
                break;
            case "Female":
                gender.setImageResource(R.mipmap.woman);
                break;
            default:
                gender.setImageResource(R.mipmap.unknown);
        }
        return convertView;
    }
}

