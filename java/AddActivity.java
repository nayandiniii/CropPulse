package com.example.drawer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends Fragment {

    private CheckBox checkBoxTitle;
    private EditText editTextDescription;
    private Button buttonPickDate;
    private Button buttonPickTime;
    private Button buttonSubmit;
    private TextView textViewDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat timeFormat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_activity, container, false);

        checkBoxTitle = view.findViewById(R.id.checkBoxTitle);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        buttonPickDate = view.findViewById(R.id.buttonPickDate);
        buttonPickTime = view.findViewById(R.id.buttonPickTime);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
        textViewDisplay = view.findViewById(R.id.textViewDisplay);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        timeFormat = new SimpleDateFormat("hh:mm a", Locale.US);

        buttonPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        buttonPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

        return view;
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        buttonPickDate.setText(dateFormat.format(calendar.getTime()));
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        buttonPickTime.setText(timeFormat.format(calendar.getTime()));
                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
        );
        timePickerDialog.show();
    }

    private void submitData() {
        String title = checkBoxTitle.isChecked() ? "Selected" : "Not Selected";
        String description = editTextDescription.getText().toString().trim();
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        if (!TextUtils.isEmpty(description)) {
            String result = "Title: " + title + "\nDescription: " + description + "\nDate: " + date + "\nTime: " + time;
            textViewDisplay.setText(result);
        } else {
            Toast.makeText(requireContext(), "Description cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
