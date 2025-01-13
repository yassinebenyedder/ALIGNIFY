package com.yassinenourchene.alighnify.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yassinenourchene.alighnify.Model.Exercise;
import com.yassinenourchene.alighnify.R;
import java.util.List;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Toast;
import android.app.AlertDialog;
import android.widget.Button;


public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder> {

    private List<Exercise> exercises;
    private Context context;

    public ExercisesAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.exercise_item, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.title.setText(exercise.getTitle());
        holder.image.setImageResource(exercise.getImageResId());

        // Click listener for both image and text to show the popup
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCountdownPopup();
            }
        };

        holder.image.setOnClickListener(clickListener);
        holder.title.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    private void showCountdownPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.countdown_popup, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        final Button startButton = dialogView.findViewById(R.id.start_countdown_button);
        final TextView countdownText = dialogView.findViewById(R.id.countdown_text);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        countdownText.setText("Seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        countdownText.setText("Done!");
                        Toast.makeText(context, "Countdown Finished", Toast.LENGTH_SHORT).show();
                    }
                }.start();
                startButton.setEnabled(false);
            }
        });

        dialog.show();
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.exercise_image);
            title = itemView.findViewById(R.id.exercise_title);
        }
    }
}