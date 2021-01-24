package licy.demo.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import licy.demo.navigation.databinding.FragmentDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    FragmentDetailBinding mFragmentDetailBinding;
    ScoreViewModel mScoreViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mScoreViewModel = ViewModelProviders.of(getActivity()).get(ScoreViewModel.class);
        mFragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        mFragmentDetailBinding.setData(mScoreViewModel);
        mFragmentDetailBinding.setLifecycleOwner(getActivity());

        // Inflate the layout for this fragment
        return mFragmentDetailBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentDetailBinding.button4.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}