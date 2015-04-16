package com.game.chiendh.iqtestforfun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.array;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenSlidePageFragment extends Fragment implements
		OnClickListener {
	/**
	 * The argument key for the page number this fragment represents.
	 */

	public static final String TAG = "ChienDH";

	public static final String ARG_PAGE = "page";

	/**
	 * The fragment's page number, which is set to the argument value for
	 * {@link #ARG_PAGE}.
	 */
	private int mPageNumber;

	private ArrayList<Integer> mArray;

	private static EveryoneActivity mActivity;

	ImageView imgA;
	ImageView imgB;
	ImageView imgC;
	ImageView imgD;
	ImageView imgE;
	ImageView imgF;
	ImageView imgG;
	ImageView imgH;

	ImageView imgLabelA;
	ImageView imgLabelB;
	ImageView imgLabelC;
	ImageView imgLabelD;
	ImageView imgLabelE;
	ImageView imgLabelF;
	ImageView imgLabelG;
	ImageView imgLabelH;

	/**
	 * Factory method for this fragment class. Constructs a new fragment for the
	 * given page number.
	 */
	public static ScreenSlidePageFragment create(int pageNumber,
			EveryoneActivity act) {

		ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
		mActivity = act;
		SharedPreferences pre = mActivity.getSharedPreferences("pfAnswer",
				mActivity.MODE_PRIVATE);
		ArrayList<Integer> mList = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 1; i < 40; i++) {
			temp = pre.getInt("" + i, -1);
			mList.add(temp);
		}
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, pageNumber);
		args.putIntegerArrayList("answer", mList);
		fragment.setArguments(args);

		return fragment;
	}

	public ScreenSlidePageFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPageNumber = getArguments().getInt(ARG_PAGE);
		mArray = getArguments().getIntegerArrayList("answer");
		Log.d(TAG, "Page Number: " + mPageNumber);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout containing a title and body text.
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.fragment_screen_slide_page, container, false);

		// Set the title view to show the page number.
		((TextView) rootView.findViewById(android.R.id.text1))
				.setText(getString(R.string.title_template_step, mPageNumber));
		Utils u = new Utils();
		((ImageView) rootView.findViewById(R.id.imgQ)).setImageResource(u
				.getQuestion(mPageNumber));

		imgA = (ImageView) rootView.findViewById(R.id.imgAwA);
		imgB = (ImageView) rootView.findViewById(R.id.imgAwB);
		imgC = (ImageView) rootView.findViewById(R.id.imgAwC);
		imgD = (ImageView) rootView.findViewById(R.id.imgAwD);
		imgE = (ImageView) rootView.findViewById(R.id.imgAwE);
		imgF = (ImageView) rootView.findViewById(R.id.imgAwF);
		imgG = (ImageView) rootView.findViewById(R.id.imgAwG);
		imgH = (ImageView) rootView.findViewById(R.id.imgAwH);

		imgA.setImageResource(Utils.getAnswerA(mPageNumber));
		imgB.setImageResource(Utils.getAnswerB(mPageNumber));
		imgC.setImageResource(Utils.getAnswerC(mPageNumber));
		imgD.setImageResource(Utils.getAnswerD(mPageNumber));
		imgE.setImageResource(Utils.getAnswerE(mPageNumber));
		imgF.setImageResource(Utils.getAnswerF(mPageNumber));
		imgG.setImageResource(Utils.getAnswerG(mPageNumber));
		imgH.setImageResource(Utils.getAnswerH(mPageNumber));

		imgLabelA = (ImageView) rootView.findViewById(R.id.labela);
		imgLabelB = (ImageView) rootView.findViewById(R.id.labelb);
		imgLabelC = (ImageView) rootView.findViewById(R.id.labelc);
		imgLabelD = (ImageView) rootView.findViewById(R.id.labeld);
		imgLabelE = (ImageView) rootView.findViewById(R.id.labele);
		imgLabelF = (ImageView) rootView.findViewById(R.id.labelf);
		imgLabelG = (ImageView) rootView.findViewById(R.id.labelg);
		imgLabelH = (ImageView) rootView.findViewById(R.id.labelh);

		int tempAnser = 0;
		tempAnser = mArray.get(mPageNumber);
		if (tempAnser != -1) {
			if (tempAnser == 1)
				imgLabelA.setBackgroundColor(Color.RED);
			if (tempAnser == 2)
				imgLabelB.setBackgroundColor(Color.RED);
			if (tempAnser == 3)
				imgLabelC.setBackgroundColor(Color.RED);
			if (tempAnser == 4)
				imgLabelD.setBackgroundColor(Color.RED);
			if (tempAnser == 5)
				imgLabelE.setBackgroundColor(Color.RED);
			if (tempAnser == 6)
				imgLabelF.setBackgroundColor(Color.RED);
			if (tempAnser == 7)
				imgLabelG.setBackgroundColor(Color.RED);
			if (tempAnser == 8)
				imgLabelH.setBackgroundColor(Color.RED);
		} else {
				imgLabelA.setBackgroundColor(Color.BLUE);
				imgLabelB.setBackgroundColor(Color.BLUE);
				imgLabelC.setBackgroundColor(Color.BLUE);
				imgLabelD.setBackgroundColor(Color.BLUE);
				imgLabelE.setBackgroundColor(Color.BLUE);
				imgLabelF.setBackgroundColor(Color.BLUE);
				imgLabelG.setBackgroundColor(Color.BLUE);
				imgLabelH.setBackgroundColor(Color.BLUE);
		}

		imgA.setOnClickListener(this);
		imgB.setOnClickListener(this);
		imgC.setOnClickListener(this);
		imgD.setOnClickListener(this);
		imgE.setOnClickListener(this);
		imgF.setOnClickListener(this);
		imgG.setOnClickListener(this);
		imgH.setOnClickListener(this);

		return rootView;
	}

	/**
	 * Returns the page number represented by this fragment object.
	 */
	public int getPageNumber() {
		return mPageNumber;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.imgAwA:
			// imgLabelA.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(1);
			break;
		case R.id.imgAwB:
			// imgLabelB.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(2);
			break;
		case R.id.imgAwC:
			// imgLabelC.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(3);
			break;
		case R.id.imgAwD:
			// imgLabelD.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(4);
			break;
		case R.id.imgAwE:
			// imgLabelE.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(5);
			break;
		case R.id.imgAwF:
			// imgLabelF.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(6);
			break;
		case R.id.imgAwG:
			// imgLabelG.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(7);
			break;
		case R.id.imgAwH:
			// imgLabelH.setBackgroundColor(Color.RED);
			mActivity.nextQuesstion(8);
			break;
		}

	}
}
