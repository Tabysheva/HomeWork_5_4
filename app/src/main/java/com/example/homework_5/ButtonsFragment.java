package com.example.homework_5;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonsFragment extends Fragment {
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multiply, division, percent, clear, equal, dot,history,hisory;
    TextView result;
    ArrayList<String> list = new ArrayList<>();
    double num1, num2;
    String operation;
HistoryFragment historyFragment;

    public ButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
historyFragment = new HistoryFragment();

        View view = inflater.inflate(R.layout.fragment__buttons, container, false);
        one = view.findViewById(R.id.button_one);
        two = view.findViewById(R.id.button_two);
        three = view.findViewById(R.id.button_three);
        four = view.findViewById(R.id.button_four);
        five = view.findViewById(R.id.button_five);
        six = view.findViewById(R.id.button_six);
        seven = view.findViewById(R.id.button_seven);
        eight = view.findViewById(R.id.button_eight);
        nine = view.findViewById(R.id.button_nine);
        zero = view.findViewById(R.id.button_zero);
        division = view.findViewById(R.id.button_dv);
        clear = view.findViewById(R.id.button_cl);
        dot = view.findViewById(R.id.button_point);
        equal = view.findViewById(R.id.button_eq);
        plus = view.findViewById(R.id.button_pl);
        minus = view.findViewById(R.id.button_mn);
        multiply = view.findViewById(R.id.button_ml);
        percent = view.findViewById(R.id.button_pr);
        result = view.findViewById(R.id.result);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_one:
                        result.append(one.getText());
                        break;
                    case R.id.button_two:
                        result.append(two.getText());
                        break;
                    case R.id.button_three:
                        result.append(three.getText());
                        break;
                    case R.id.button_four:
                        result.append(four.getText());
                        break;
                    case R.id.button_five:
                        result.append(five.getText());
                        break;
                    case R.id.button_six:
                        result.append(six.getText());
                        break;
                    case R.id.button_seven:
                        result.append(seven.getText());
                        break;
                    case R.id.button_eight:
                        result.append(eight.getText());
                        break;
                    case R.id.button_nine:
                        result.append(nine.getText());
                        break;
                    case R.id.button_zero:
                        result.append(zero.getText());
                        break;
                    case R.id.button_pl:
                        num1 = Double.parseDouble(result.getText().toString());
                        result.setText("");
                        operation = "+";

                        break;

                    case R.id.button_dv:
                        num1 = Double.parseDouble(result.getText().toString());
                        result.setText("");
                        operation = "/";
                        break;

                    case R.id.button_mn:
                        num1 = Double.parseDouble(result.getText().toString());
                        result.setText("");
                        operation = "-";

                        break;

                    case R.id.button_ml:
                        num1 = Double.parseDouble(result.getText().toString());
                        result.setText("");
                        operation = "*";

                        break;
                    case R.id.button_eq:
                        Log.d("TAG", "onClick: ");
                        num2 = Double.parseDouble(result.getText().toString());
                        if (operation == "+") {
                            result.setText(Double.toString(num1 + num2));
                        } else if (operation == "-") {
                            result.setText(Double.toString(num1 - num2));

                        } else if (operation == "*") {
                            result.setText(Double.toString(num1 * num2));

                        } else if (operation == "/") {
                            result.setText(Double.toString(num1 / num2));

                        } else if (operation == "%") {
                            result.setText(Double.toString((num1 / 100) * num2));
                        }
                        break;
                    case R.id.button_pr:
                        num1 = Double.parseDouble(result.getText().toString());
                        result.setText("");
                        operation = "%";
                    case R.id.button_cl:
                        result.setText("");
                        break;
                }

            }

        };
        percent.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        plus.setOnClickListener(listener);
        equal.setOnClickListener(listener);
        one.setOnClickListener(listener);
        two.setOnClickListener(listener);
        three.setOnClickListener(listener);
        four.setOnClickListener(listener);
        five.setOnClickListener(listener);
        six.setOnClickListener(listener);
        seven.setOnClickListener(listener);
        eight.setOnClickListener(listener);
        nine.setOnClickListener(listener);
        zero.setOnClickListener(listener);
        division.setOnClickListener(listener);
        clear.setOnClickListener(listener);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        history=view.findViewById(R.id.button_history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForButton button = (ForButton) getActivity();
                button.showHistoryFragment();
            }
        });
    }

    public void sendAnswer() {
        changeFragment(historyFragment);

        Bundle bundle = new Bundle();
        String oneAnswer = result.getText().toString();
        list.add(oneAnswer);
        bundle.putStringArrayList("key", list);
        historyFragment.setArguments(bundle);
    }
    public void changeFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
    }



