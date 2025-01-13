package com.yassinenourchene.alighnify;
import com.yassinenourchene.alighnify.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.yassinenourchene.alighnify.Model.Exercise;
import com.yassinenourchene.alighnify.Adapters.ExercisesAdapter;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        RecyclerView recyclerView = findViewById(R.id.exercises_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Standing Hand to Big Toe", R.drawable.standinghandtobigtoe));
        exerciseList.add(new Exercise("Revolved Half Moon", R.drawable.revolvedhalfmoon));
        exerciseList.add(new Exercise("Standing Bow", R.drawable.standingbow));
        exerciseList.add(new Exercise("Revolved Standing Hand to Big Toe", R.drawable.revolvedstandinghandtobigtoe));
        exerciseList.add(new Exercise("Standing Half Bound Lotus Forward Bend", R.drawable.standinghalfboundlotusforwardbend));
        exerciseList.add(new Exercise("warrior III", R.drawable.warrioriii));

        ExercisesAdapter adapter = new ExercisesAdapter(exerciseList);
        recyclerView.setAdapter(adapter);

        Button tasksButton = findViewById(R.id.nav_tasks);
        tasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to MainActivity
                Intent intent = new Intent(ExercisesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
