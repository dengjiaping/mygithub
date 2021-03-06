package com.yy.android.gamenews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.duowan.android.base.model.BaseModel.ResponseListener;
import com.yy.android.sportbrush.R;
import com.yy.android.gamenews.model.CommentModel;
import com.yy.android.gamenews.ui.view.ActionBar;

public class CommentActivity extends BaseActivity {
	public static final String KEY_ARTICLE_ID = "article_id";
	private EditText mComment;
	private TextView mWordsNum;
	private int mMaxWordsNum = 140;
	private long mArticleId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		if (intent != null) {
			mArticleId = intent.getLongExtra(KEY_ARTICLE_ID, -1);
			if (mArticleId == -1) {
				finish();
				return;
			}
		} else {
			finish();
			return;
		}

		setContentView(R.layout.activity_comment);
		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		actionBar.setOnLeftClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		actionBar.setOnRightClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final String comment = mComment.getText().toString().trim();
				if (TextUtils.isEmpty(comment)) {
					Toast.makeText(
							CommentActivity.this,
							getResources().getString(
									R.string.comment_empty_hint),
							Toast.LENGTH_SHORT).show();
					return;
				}
				CommentModel.addComment(new ResponseListener<Boolean>(
						CommentActivity.this) {

					@Override
					public void onError(Exception e) {
						// TODO Auto-generated method stub
						super.onError(e);
						if (!TextUtils.isEmpty(e.getMessage())) {
							Toast.makeText(CommentActivity.this,
									e.getMessage(), Toast.LENGTH_SHORT).show();
						}
					}

					@Override
					public void onResponse(Boolean arg0) {
						// TODO Auto-generated method stub
						if (arg0) {
							Intent intent = new Intent();
							intent.putExtra(ArticleDetailActivity.KEY_COMMENT,
									comment);
							setResult(RESULT_OK, intent);
							finish();
						}

					}

				}, mArticleId, comment);
			}
		});

		mComment = (EditText) findViewById(R.id.posts_editor);
		mComment.addTextChangedListener(mTextWatcher);
		mComment.requestFocus();
		mWordsNum = (TextView) findViewById(R.id.words_num);
		mWordsNum.setText(String.format("0/%d", mMaxWordsNum));

	}

	private TextWatcher mTextWatcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			mWordsNum.setText(String.format("%d/%d", s.length(), mMaxWordsNum));
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};
}
