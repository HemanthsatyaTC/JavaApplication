package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private Spinner spinner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        spinner = binding.spinner;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getContext(),
                R.array.spinner,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        binding.button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String userName = binding.editTextTextEmailAddress.getText().toString();
                String password = binding.editTextTextPassword.getText().toString();

                if (!notificationsViewModel.isValidUsername(userName)){
                    Toast.makeText(getActivity(), "InValid Username", Toast.LENGTH_SHORT).show();
                } else if (!notificationsViewModel.isValidPassword(password)) {
                    Toast.makeText(getActivity(),"Invalid Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}